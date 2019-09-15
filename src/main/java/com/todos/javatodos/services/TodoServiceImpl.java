package com.todos.javatodos.services;

import com.todos.javatodos.models.Todo;
import com.todos.javatodos.repos.ToDoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;


@Service(value = "todoService")
public abstract class TodoServiceImpl implements TodoService
{

    private static final Logger logger = LoggerFactory.getLogger(TodoServiceImpl.class);

    @Autowired
    ToDoRepository todorepos;

    @Override
    public ArrayList<Todo> findAll(long id)
    {
        ArrayList<Todo> todo = new ArrayList<>();
        todorepos.getAllByID(id).iterator().forEachRemaining(todo::add);
        return todo;
    }

    @Override
    public Todo findTodoById(long id)
    {
        return todorepos.findById(id).orElseThrow(() -> new EntityNotFoundException((Long.toString(id))));
    }


    @Override
    public void delete(long id)
    {
        todorepos.findById(id).orElseThrow(() -> new EntityNotFoundException((Long.toString(id))));
        todorepos.deleteById(id);
    }

    @Override
    public Todo save(Todo todo)
    {
        return todorepos.save(todo);
    }

    @Override
    public Todo update(Todo todo, long id)
    {
        Todo currentTodo = todorepos.findById(id).orElseThrow(() -> new EntityNotFoundException((Long.toString(id))));
        if (todo.getDatestarted() != null){
            currentTodo.setDatestarted(todo.getDatestarted());
        }
        if (todo.getDescription() != null){
            currentTodo.setDescription(todo.getDescription());
        }
        if (todo.isCompleted()){
            currentTodo.setCompleted(true);
        }else{
            currentTodo.setCompleted(false);
        }
        todorepos.save(currentTodo);
        return currentTodo;
    }
}