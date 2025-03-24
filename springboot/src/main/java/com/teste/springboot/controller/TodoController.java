package com.teste.springboot.controller;

import com.teste.springboot.entity.Todo;
import com.teste.springboot.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<List<Todo>> create(@RequestBody Todo todo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(todo));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> list() {
        return ResponseEntity.ok(todoService.list());
    }

    @PutMapping
    public ResponseEntity<List<Todo>> update(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.update(todo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}