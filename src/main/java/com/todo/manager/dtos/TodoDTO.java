package com.todo.manager.dtos;

public class TodoDTO {

    private String title;

    private Boolean completed = false;

    //constructor
    public TodoDTO(String title, Boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    //getters
    public String getTitle() {
        return title;
    }
    public Boolean getCompleted() {
        return completed;
    }

    //setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
