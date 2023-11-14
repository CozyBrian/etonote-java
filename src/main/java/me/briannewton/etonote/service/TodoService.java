package me.briannewton.etonote.service;

import java.util.Optional;

import me.briannewton.etonote.model.Todo;

public interface TodoService {
  public java.util.List<Todo> getTodosByListId(String listId);

  public Optional<Todo> getTodoById(String todoId);

  public Optional<Todo> createTodo(Todo todo);
}
