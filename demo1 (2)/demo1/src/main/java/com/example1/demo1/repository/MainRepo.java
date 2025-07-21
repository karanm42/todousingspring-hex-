package com.example1.demo1.repository;

import com.example1.demo1.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainRepo extends JpaRepository<Todo, Long> {
}
