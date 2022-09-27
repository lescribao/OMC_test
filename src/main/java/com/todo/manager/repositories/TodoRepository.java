package com.todo.manager.repositories;

import com.todo.manager.models.Todo;
import com.todo.manager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAllWhereTitleContainingIgnoreCase(String title);

    List<Todo> findAllWhereUserEquals(User user);


    //order by id
    List<Todo> findByOrderByIdAsc();
    List<Todo> findByOrderByIdDesc();

    //order by title
    List<Todo> findByOrderByTitleAsc();
    List<Todo> findByOrderByTitleDesc();

    //order by user
    List<Todo> findByOrderByUserAsc();
    List<Todo> findByOrderByUserDesc();


}
