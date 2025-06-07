package com.ToeicPreBackend.controller.admin;

import com.ToeicPreBackend.controller.CrudController;
import com.ToeicPreBackend.entity.UserEntity;
import com.ToeicPreBackend.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/user")
public class AdminUser extends CrudController<UserEntity, Integer> {
    public AdminUser(CrudService<UserEntity, Integer> crudService) {
        super(crudService);
    }
}
