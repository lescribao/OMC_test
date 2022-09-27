package com.todo.manager.controllers;
import com.todo.manager.dtos.TodoDTO;
import com.todo.manager.models.Todo;
import com.todo.manager.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getTodos (@RequestParam(required = false) String sortDir, @RequestParam(required = false) String sortBy) {

        return todoService.getTodos(sortDir, sortBy);
    }

    @GetMapping("/todos/{username}")
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getTodoByUsername(@PathVariable String username) {

        return todoService.getTodoByUsername(username);
    }

    @GetMapping("/todos/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getTodoByTitle(@PathVariable String title) {

        return todoService.getTodoByTitle(title);
    }


    @GetMapping("/todo/id")
    @ResponseStatus(HttpStatus.OK)
    public Todo getTodo (@PathVariable Long id) {

        return todoService.getTodo(id);
    }

    @PostMapping("/todo")
    @ResponseStatus(HttpStatus.CREATED)
    public void newTodo (@RequestBody Todo todo) {

        todoService.newTodo(todo);
    }

    @PutMapping("/todos/id")
    @ResponseStatus(HttpStatus.OK)
    public void updateTodo(@PathVariable Long id, @RequestBody TodoDTO todoDTO) {

        todoService.updateTodo(id, todoDTO);
    }

    @PatchMapping("/todo/id")
    @ResponseStatus(HttpStatus.OK)
    public void patchTodo(@PathVariable Long id, @RequestBody TodoDTO todoDTO) {

        todoService.patchTodo(id, todoDTO);
    }

    @DeleteMapping("/todo/id")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTodo(@PathVariable Long id) {

        todoService.deleteTodo(id);
    }
}
