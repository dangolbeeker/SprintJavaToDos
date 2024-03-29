package com.todos.sprintjavatodos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SprintjavatodosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprintjavatodosApplication.class, args);
    }

}
