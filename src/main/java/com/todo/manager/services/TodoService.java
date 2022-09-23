package com.todo.manager.services;

import com.todo.manager.dtos.TodoDTO;
import com.todo.manager.models.Todo;
import com.todo.manager.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public List<Todo> getTodos() {

        if (todoRepository.count() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There isn't any created Todo tasks currently.");
        } else {
            return todoRepository.findAll();
        }
    }

    public Todo getTodo(Long id) {

        if (todoRepository.findById(id).isPresent()) {
            return todoRepository.findById(id).get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The Todo task with the given ID does not exist.");
        }
    }

    public void newTodo(Todo todo) {

        todoRepository.save(todo);
    }

    public void updateTodo(Long id, TodoDTO todoDTO) {

        if (todoRepository.findById(id).isPresent()) {
            Todo todo = todoRepository.findById(id).get();

            if (todoDTO.getTitle() != null) {
                todo.setTitle(todoDTO.getTitle());
            }

            if (todoDTO.getCompleted() != null) {
                todo.setCompleted(todoDTO.getCompleted());
            }

            todoRepository.save(todo);

        } else {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The Todo task with the given ID does not exist.");
        }
    }

    public void patchTodo(Long id, TodoDTO todoDTO) {

        if (todoRepository.findById(id).isPresent()) {

            Todo todo = todoRepository.findById(id).get();

            if (todoDTO.getTitle() != null) {
                todo.setTitle(todoDTO.getTitle());
            }

            if (todoDTO.getCompleted() != null) {
                todo.setCompleted(todoDTO.getCompleted());
            }

            todoRepository.save(todo);
        } else {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The Todo task with the given ID does not exist.");
        }
    }

    public void deleteTodo(Long id) {

        if (todoRepository.findById(id).isPresent()) {

            todoRepository.delete(todoRepository.findById(id).get());
        } else {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The Todo task with the given ID does not exist.");
        }
    }
}

