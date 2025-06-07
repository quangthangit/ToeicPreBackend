package com.ToeicPreBackend.controller.admin;

import com.ToeicPreBackend.controller.CrudController;
import com.ToeicPreBackend.entity.User;
import com.ToeicPreBackend.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/user")
public class AdminUser extends CrudController<User, Integer> {
    public AdminUser(CrudService<User, Integer> crudService) {
        super(crudService);
    }
}
