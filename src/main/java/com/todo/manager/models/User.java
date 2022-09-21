package com.todo.manager.models;

import javax.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String username;

    private String password;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Todo> todoList;

    //constructors
    public User(Long id, String name, String username, String password, Address address) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.address = address;
    }

    public User() {

    }

    //getters
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public Address getAddress() {
        return address;
    }
    public List<Todo> getTodoList() {
        return todoList;
    }

    //setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}
