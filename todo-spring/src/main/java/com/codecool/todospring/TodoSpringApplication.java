package com.codecool.todospring;

import com.codecool.todospring.model.Status;
import com.codecool.todospring.model.Todo;
import com.codecool.todospring.model.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoSpringApplication.class, args);
	}

}
