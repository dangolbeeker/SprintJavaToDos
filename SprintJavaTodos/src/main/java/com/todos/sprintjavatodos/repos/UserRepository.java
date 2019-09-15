package com.todos.sprintjavatodos.repos;

import com.todos.sprintjavatodos.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
