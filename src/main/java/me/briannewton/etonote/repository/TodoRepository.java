package me.briannewton.etonote.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.briannewton.etonote.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, String> {

  List<Todo> findByListId(String listId);
  
}
