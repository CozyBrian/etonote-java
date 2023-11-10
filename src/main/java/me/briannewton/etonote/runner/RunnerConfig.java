package me.briannewton.etonote.runner;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import me.briannewton.etonote.model.*;
import me.briannewton.etonote.repository.*;


@Configuration
public class RunnerConfig {
  
  @Bean
  CommandLineRunner commandLineRunner(UserRepository userRepository, ListRepository listRepository, TodoRepository todoRepository) {
    return args -> {
      User brian = new User(
        UUID.randomUUID(), 
        "cozy", 
        "cozy1234", 
        "cozy@brian.com"
        );
        
      userRepository.save(brian);
      
      List etonote = new List(
        UUID.randomUUID(), 
        brian.getId(), 
        "etonote", 
        new Icon("color", "#26ff69")
      );

      List home = new List(
        UUID.randomUUID(), 
        brian.getId(), 
        "Home", 
        new Icon("color", "#CFDEE7")
      );

      listRepository.saveAll(
        java.util.List.of(etonote, home)
      );

      Todo todo1 = new Todo(
        etonote.getId(),
        "Chaley I really try oo",
        ""
      );

      Todo todo2 = new Todo(
        etonote.getId(),
        "Finish cooking up etonote",
        ""
      );

      Todo todo3 = new Todo(
        "Hours in silence",
        true,
        etonote.getId(),
        "note...lol"
      );

      todoRepository.saveAll(
        java.util.List.of(todo1, todo2, todo3)
      );

    };
  }
}
