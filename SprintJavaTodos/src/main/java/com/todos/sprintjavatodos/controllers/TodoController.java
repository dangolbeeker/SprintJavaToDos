package com.todos.sprintjavatodos.controllers;

import com.todos.sprintjavatodos.models.Todo;
import com.todos.sprintjavatodos.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/todos")
public class TodoController
{

    @Autowired
    private TodoService todoService;


    ////localhost:5005/todos/todoid/{todoid}
    @PutMapping(value = "/todoid/{todoid}", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<?> updateTodo(@PathVariable long todoid, @RequestBody Todo todo)
    {
        return new ResponseEntity<>(todoService.update(todo, todoid), HttpStatus.OK);
    }

}
