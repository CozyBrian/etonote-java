package me.briannewton.etonote.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.briannewton.etonote.model.Todo;
import me.briannewton.etonote.repository.TodoRepository;
import me.briannewton.etonote.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {
  private final TodoRepository todoRepository;

  @Autowired
  public TodoServiceImpl(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @Override
  public java.util.List<Todo> getTodosByListId(String listId) {
    return todoRepository.findByListId(listId);
  }

  @Override
  public Optional<Todo> getTodoById(String todoId) {
    return todoRepository.findById(todoId);
  }

  @Override
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
