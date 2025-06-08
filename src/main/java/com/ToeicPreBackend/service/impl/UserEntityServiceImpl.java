package com.ToeicPreBackend.service.impl;

import java.util.List;
import com.ToeicPreBackend.entity.Role;
import com.ToeicPreBackend.entity.User;
import com.ToeicPreBackend.exception.AlreadyExistsException;
import com.ToeicPreBackend.exception.NotFoundException;
import com.ToeicPreBackend.repository.UserEntityRepository;
import com.ToeicPreBackend.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserEntityServiceImpl implements UserEntityService {

    private final UserEntityRepository userEntityRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserEntityServiceImpl(UserEntityRepository userEntityRepository, PasswordEncoder passwordEncoder) {
        this.userEntityRepository = userEntityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User getByUsername(String username) {
        return userEntityRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("Use " + username+ " Not Found"));
    }

    @Override
    public User create(User user) {
        userEntityRepository.findByUsername(user.getUsername()).ifPresent(u -> {
            throw new AlreadyExistsException(user.getUsername() + " already exists");
        });
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.ROLE_USER);
        user.setIsActive(true);
        return userEntityRepository.save(user);
    }

    @Override
    public User update(Integer integer, User user) {
        User existingUser = userEntityRepository.findById(integer)
                .orElseThrow(() -> new NotFoundException("User ID " + integer + " not found"));
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        existingUser.setNikName(user.getNikName());
        existingUser.setImageUrl(user.getImageUrl());
        return userEntityRepository.save(existingUser);
    }

    @Override
    public User getById(Integer integer) {
        return userEntityRepository.findById(integer).orElseThrow(() -> new NotFoundException("Use ID " + integer+ " Not Found"));
    }

    @Override
    public void delete(Integer id) {
        userEntityRepository.findById(id).orElseThrow(() -> new NotFoundException("User ID " + id + " Not Found"));
        userEntityRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return userEntityRepository.findAll();
    }
}