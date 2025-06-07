package com.ToeicPreBackend.controller;

import java.util.List;

import com.ToeicPreBackend.service.CrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public abstract class ViewController<T,ID> {

    private final CrudService<T, ID> crudService;

    public ViewController(CrudService<T, ID> crudService) {
        this.crudService = crudService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<T>> findAll() {
        return ResponseEntity.ok(crudService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable ID id) {
        T entity = crudService.getById(id);
        return ResponseEntity.ok(entity);
    }
}