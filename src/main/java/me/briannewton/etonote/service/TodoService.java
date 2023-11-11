package me.briannewton.etonote.service;

import java.util.Optional;

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

  public java.util.List<Todo> getTodosByListId(String listId) {
    return todoRepository.findByListId(listId);
  }

  public Optional<Todo> getTodoById(String todoId) {
    return todoRepository.findById(todoId);
  }

  public Optional<Todo> createTodo(Todo todo) {
    if (todo.getListId() == null || todo.getListId().isEmpty() &&
        todo.getTitle() == null || todo.getTitle().isEmpty() &&
        todo.getNote() == null || todo.getNote().isEmpty()
    ) {
      return Optional.empty();
    }
    Todo newTodo = todoRepository.save(new Todo(todo.getListId(), todo.getTitle(), todo.getNote()));
    return Optional.of(newTodo);
  }
}
