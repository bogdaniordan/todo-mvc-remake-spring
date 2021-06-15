package com.codecool.todospring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class TodoDAO {

    @Autowired
    TodoRepository todoRepository;

    public void toggleAll(boolean complete) {
        List<Todo> todos = todoRepository.findAll();
        todos.forEach(todo -> {
            todo.setStatus(complete ? Status.COMPLETE : Status.ACTIVE);
            todoRepository.save(todo);
        });
    }

    public void toggleToDoStatus(String id, boolean isComplete) {
        Optional<Todo> todo = todoRepository.findById(Long.parseLong(id));
        if (todo.isPresent()) {
            if (isComplete) {
                todo.get().setStatus(Status.COMPLETE);
            } else {
                todo.get().setStatus(Status.ACTIVE);
            }
            todoRepository.save(todo.get());
        }
    }
}
