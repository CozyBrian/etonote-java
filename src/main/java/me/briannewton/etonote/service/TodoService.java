package me.briannewton.etonote.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.briannewton.etonote.model.Todo;
import me.briannewton.etonote.repository.TodoRepository;

@Service
public class TodoService {
  private final TodoRepository todoRepository;

  @Autowired
  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public java.util.List<Todo> getTodosByListId(UUID listId) {
    return todoRepository.findByListId(listId);
  }
}
