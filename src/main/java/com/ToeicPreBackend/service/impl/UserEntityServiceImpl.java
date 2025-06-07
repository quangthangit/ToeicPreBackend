package com.ToeicPreBackend.service.impl;

import java.util.List;
import com.ToeicPreBackend.entity.Role;
import com.ToeicPreBackend.entity.UserEntity;
import com.ToeicPreBackend.exception.AlreadyExistsException;
import com.ToeicPreBackend.exception.NotFoundException;
import com.ToeicPreBackend.repository.UserEntityRepository;
import com.ToeicPreBackend.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserEntityServiceImpl implements UserEntityService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity getByUsername(String username) {
        return userEntityRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("Use " + username+ " Not Found"));
    }

    @Override
    public UserEntity create(UserEntity entity) {
        userEntityRepository.findByUsername(entity.getUsername()).ifPresent(u -> {
            throw new AlreadyExistsException(entity.getUsername() + " already exists");
        });
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        entity.setRole(Role.ROLE_USER);
        entity.setIsActive(true);
        return userEntityRepository.save(entity);
    }

    @Override
    public UserEntity update(Integer integer, UserEntity entity) {
        return null;
    }

    @Override
    public UserEntity getById(Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<UserEntity> getAll() {
        return List.of();
    }
}