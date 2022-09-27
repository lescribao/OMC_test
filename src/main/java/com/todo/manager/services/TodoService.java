package com.todo.manager.services;

import com.todo.manager.dtos.TodoDTO;
import com.todo.manager.models.Todo;
import com.todo.manager.models.User;
import com.todo.manager.repositories.TodoRepository;
import com.todo.manager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    UserRepository userRepository;

    public List<Todo> getTodos(String sortBy, String sortDir) {

        if (todoRepository.count() == 0) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There isn't any created Todo tasks currently.");

        } else {

            //I'm not completely happy with this part of code due to the amount of code repetition
            //having *3* times the sortBy ifs I'm sure is not optimal, but at the time I'm unsure how to avoid repetition

            if ( sortDir.equals("asc") || sortDir.equals("desc") || !sortBy.isEmpty()) {

                switch(sortDir) {
                    case "asc":

                        if (sortBy.equals("id")) {

                            return todoRepository.findByOrderByIdAsc();

                        } else if (sortBy.equals("title")) {

                            return todoRepository.findByOrderByTitleAsc();

                        } else if (sortBy.equals("user")) {

                            return todoRepository.findByOrderByUserAsc();

                        } else {

                            //if no sortBy is provided, it will sort by default by the Id
                            return todoRepository.findByOrderByIdAsc();
                        }

                    case "desc":

                        if (sortBy.equals("id")) {

                            return todoRepository.findByOrderByIdDesc();

                        } else if (sortBy.equals("title")) {

                            return todoRepository.findByOrderByTitleDesc();

                        } else if (sortBy.equals("user")) {

                            return todoRepository.findByOrderByUserDesc();

                        } else {

                            //if no sortBy is provided, it will sort by default by the Id
                            return todoRepository.findByOrderByIdDesc();
                        }

                }


            } else {

                //If no order is specified, it will still try to sortBy, and by default it will sort descending.

                if (sortBy.equals("id")) {

                    return todoRepository.findByOrderByIdDesc();

                } else if (sortBy.equals("title")) {

                    return todoRepository.findByOrderByTitleDesc();

                } else if (sortBy.equals("user")) {

                    return todoRepository.findByOrderByUserDesc();

                } else {

                    //if no sortBy is provided, it will sort by default by the Id
                    return todoRepository.findByOrderByIdDesc();
                }
            }

            return todoRepository.findAll();
        }
    }

    public List<Todo> getTodoByUsername(String username) {

        User user = userRepository.findByUsername(username);

        return todoRepository.findAllWhereUserEquals(user);
    }

    public List<Todo> getTodoByTitle(String title) {
        if (todoRepository.findAllWhereTitleContainingIgnoreCase(title).size() == 0) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no Todo tasks with a title containing" +
                    "the given text.");
        } else {

            return todoRepository.findAllWhereTitleContainingIgnoreCase(title);
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

