package com.ToeicPreBackend.controller;

import java.util.List;
import com.ToeicPreBackend.service.CrudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

public abstract class CrudController<T, ID> {

    private final CrudService<T, ID> crudService;

    public CrudController(CrudService<T, ID> crudService) {
        this.crudService = crudService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<T>> getAll() {
        return ResponseEntity.ok(crudService.getAll());
    }

    @PostMapping
    public ResponseEntity<T> create(@Valid @RequestBody T entity) {
        T createdEntity = crudService.create(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEntity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable ID id) {
        T entity = crudService.getById(id);
        return ResponseEntity.ok(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @Valid @RequestBody T entity) {
        T updatedEntity = crudService.update(id, entity);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        crudService.delete(id);
        return ResponseEntity.noContent().build();
    }
}