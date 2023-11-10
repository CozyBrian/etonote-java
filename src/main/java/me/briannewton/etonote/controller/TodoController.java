package me.briannewton.etonote.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import me.briannewton.etonote.model.Todo;
import me.briannewton.etonote.service.TodoService;

@RestController
@RequestMapping(path = "api/v1/todos")
public class TodoController {
  
  private final TodoService todoService;

  @Autowired
  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping
  public List<Todo> getTodosByListId(@RequestParam("listId") UUID listId) {
    return todoService.getTodosByListId(listId);
  }
}
