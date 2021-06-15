package com.codecool.todospring.controller;

import com.codecool.todospring.model.Status;
import com.codecool.todospring.model.Todo;
import com.codecool.todospring.model.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToDoController {

    @Autowired
    TodoRepository todoRepository;

    @GetMapping("/")
    public String index() {
        Todo firstTodo = new Todo("first", Status.ACTIVE);
        Todo secondTodo = new Todo("second", Status.ACTIVE);
        Todo thirdTodo = new Todo("third", Status.ACTIVE);
        todoRepository.save(firstTodo);
        todoRepository.save(secondTodo);
        todoRepository.save(thirdTodo);
        return "index";
    }
}
