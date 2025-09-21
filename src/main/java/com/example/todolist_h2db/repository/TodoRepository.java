package com.example.todolist_h2db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todolist_h2db.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{

}


