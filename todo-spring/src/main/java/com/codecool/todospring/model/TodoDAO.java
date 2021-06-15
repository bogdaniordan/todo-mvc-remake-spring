package com.codecool.todospring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

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
}
