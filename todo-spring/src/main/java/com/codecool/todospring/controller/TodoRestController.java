package com.codecool.todospring.controller;

import com.codecool.todospring.model.Status;
import com.codecool.todospring.model.Todo;
import com.codecool.todospring.model.TodoDAO;
import com.codecool.todospring.model.TodoRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TodoRestController {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    TodoDAO todoDAO;

    //Add new
    @PostMapping("/addTodo")
    public void addTodo(@RequestParam Map<String, String> param) {
        Todo todo = new Todo(param.get("todo-title"), Status.ACTIVE);
        todoRepository.save(todo);
    }

    //List by id
    @PostMapping("/list")
    public String todosList(@RequestParam Map<String, String> param) throws JSONException {
        List<Todo> todos;
        if (param.get("status").equals("")) {
            todos = todoRepository.findAll();
        } else {
            todos = todoRepository.findTodosByStatus(param.get("status"));
        };
        JSONArray arr = new JSONArray();
        for (Todo dao : todos) {
            JSONObject jo = new JSONObject();
            jo.put("id", dao.getId());
            jo.put("title", dao.getTitle());
            jo.put("completed", dao.isCompleted());
            arr.put(jo);
        }
        return arr.toString(2);
    }

    // Remove all completed
    @DeleteMapping("/todos/completed")
    public void deleteCompleted() {
        List<Todo> todos = todoRepository.findTodosByStatus("COMPLETE");
        todos.forEach(todo -> todoRepository.delete(todo));
    }

    //Toggle all status
    @PutMapping("/todos/toggle_all")
    public void toggleAll(@RequestParam Map<String, String> param) {
        String complete = param.get("toggle-all");
        todoDAO.toggleAll(complete.equals("true"));
    }

    //Remove by id
    @DeleteMapping("todos/{id}")
    public void deleteById(@RequestParam Map<String, String> param, @PathVariable String id) {
        todoRepository.deleteById(Long.parseLong(id));
    }
}
