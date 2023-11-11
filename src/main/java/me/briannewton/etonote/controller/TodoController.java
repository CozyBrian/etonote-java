package me.briannewton.etonote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<List<Todo>> getTodosByListId(@RequestParam("listId") String listId) {
    List<Todo> todos = todoService.getTodosByListId(listId);
    return ResponseEntity.ok(todos);
  }

  @GetMapping(path = "{todoId}")
  public ResponseEntity<Todo> getTodoById(@PathVariable("todoId") String todoId) {
    return todoService.getTodoById(todoId)
      .map(todo -> ResponseEntity.ok().body(todo))
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Todo> postNewTodo(
    @RequestBody Todo todo
  ) {
    return todoService.createTodo(todo)
    .map(newTodo -> ResponseEntity.status(201).body(newTodo))
    .orElse(ResponseEntity.badRequest().build());
  }
}
