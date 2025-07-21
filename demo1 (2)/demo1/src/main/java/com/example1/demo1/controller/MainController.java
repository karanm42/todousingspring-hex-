package com.example1.demo1.controller;

import com.example1.demo1.model.Todo;
import com.example1.demo1.repository.MainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class MainController {

    @Autowired
    private MainRepo todoRepo;

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoRepo.findAll();
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoRepo.save(todo);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo updated) {
        Todo todo = todoRepo.findById(id).orElseThrow(() -> new RuntimeException("Todo not found with id: " + id));
        todo.setTask(updated.getTask());
        todo.setCompleted(updated.isCompleted());
        return todoRepo.save(todo);
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoRepo.deleteById(id);
        return "Todo deleted with id: " + id;
    }
}
