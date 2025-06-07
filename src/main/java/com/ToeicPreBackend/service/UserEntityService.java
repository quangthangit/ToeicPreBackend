package com.ToeicPreBackend.service;

import com.ToeicPreBackend.entity.User;

public interface UserEntityService extends CrudService<User, Integer> {
    User getByUsername(String username);
}
