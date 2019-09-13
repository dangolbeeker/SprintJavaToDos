package com.todos.javatodos.services;

import com.todos.javatodos.models.Todo;

import java.util.ArrayList;

public interface TodoService
{
    ArrayList<Todo> findAll();

    Todo findTodoById(long id);

    Todo findTodoByName(String name);

    void delete(long id);

    Todo save(Todo todo);

    Todo update(Todo todo, long id);

}