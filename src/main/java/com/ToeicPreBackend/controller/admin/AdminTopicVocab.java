package com.ToeicPreBackend.controller.admin;

import com.ToeicPreBackend.controller.CrudController;
import com.ToeicPreBackend.entity.TopicVocab;
import com.ToeicPreBackend.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/topic-vocab")
public class AdminTopicVocab extends CrudController<TopicVocab, Integer> {
    public AdminTopicVocab(CrudService<TopicVocab, Integer> crudService) {
        super(crudService);
    }
}
