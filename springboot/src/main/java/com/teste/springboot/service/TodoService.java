package com.teste.springboot.service;

import com.teste.springboot.entity.Todo;
import com.teste.springboot.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service; // Importe a anotação @Service

import java.util.List;

@Service // Adicione a anotação @Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return list();
    }
    public List<Todo> list(){
        Sort sort = Sort.by("priority").descending().and(
                Sort.by("name").ascending()
        );
        return todoRepository.findAll(sort);
    }
    public List<Todo> update(Todo todo){
        todoRepository.save(todo);
        return list();
    }
    public List<Todo> delete(Long id){
        todoRepository.deleteById(id);
        return list();
    }
}