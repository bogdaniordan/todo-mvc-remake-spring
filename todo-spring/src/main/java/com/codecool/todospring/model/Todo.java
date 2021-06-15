package com.codecool.todospring.model;

import javax.persistence.*;

@Entity(name = "ToDo")
public class Todo {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Todo(String title, Status status) {
        this.title = title;
        this.status = status;
    }

    public Todo() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isCompleted() {
        return this.status == Status.COMPLETE;
    }
}
