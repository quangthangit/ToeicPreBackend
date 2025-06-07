package com.ToeicPreBackend.service;

import com.ToeicPreBackend.entity.UserEntity;

public interface UserEntityService extends CrudService<UserEntity, Integer> {
    UserEntity getByUsername(String username);
}
