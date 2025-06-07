package com.ToeicPreBackend.controller;

import com.ToeicPreBackend.entity.UserEntity;
import com.ToeicPreBackend.exception.AuthenticationFailedException;
import com.ToeicPreBackend.jwt.JwtService;
import com.ToeicPreBackend.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import request.UserRequest;
import response.UserResponse;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final UserEntityService userService;

    @Autowired
    public AuthController(AuthenticationManager authManager, JwtService jwtService, UserEntityService userService) {
        this.authManager = authManager;
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
            String token = jwtService.generateToken(authentication);
            UserEntity user = userService.getByUsername(request.getUsername());
            UserResponse userLoginResponse = new UserResponse();
            userLoginResponse.setUsername(user.getUsername());
            userLoginResponse.setRole(user.getRole().toString());
            userLoginResponse.setActive(user.getIsActive());
            userLoginResponse.setToken(token);
            return ResponseEntity.ok().body(Map.of(
                    "message", "User login successfully",
                    "user", userLoginResponse
            ));
        } catch (BadCredentialsException ex) {
            throw new AuthenticationFailedException("Invalid username or password");
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred during login");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserEntity user) {
        UserEntity createdUser = userService.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "message", "User registered successfully",
                "user", createdUser
        ));
    }
}
