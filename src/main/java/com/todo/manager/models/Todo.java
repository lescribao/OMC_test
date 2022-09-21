package com.todo.manager.models;

import javax.persistence.*;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Boolean completed;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    //constructor
    public Todo(Long id, String title, Boolean completed, User user) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.user = user;
    }

    public Todo() {

    }

    //getters
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public Boolean getCompleted() {
        return completed;
    }
    public User getUser() {
        return user;
    }

    //setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
