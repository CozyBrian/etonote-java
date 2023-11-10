package me.briannewton.etonote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import me.briannewton.etonote.model.List;
import me.briannewton.etonote.service.ListService;

@RestController
@RequestMapping(path = "api/v1/lists")
public class ListController {

  private final ListService listService;

  @Autowired
  public ListController(ListService listService) {
    this.listService = listService;
  }
  
  @GetMapping
  public java.util.List<List> getListsByUserId(@RequestParam String userId) {
    return listService.getUserLists(userId);
  }

  @GetMapping(path = "{listId}")
  public ResponseEntity<List> getList(@PathVariable String listId) {
    return listService.getList(listId)
      .map(list -> ResponseEntity.ok().body(list))
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public List addList(@RequestBody List list) {
    return listService.addList(list);
  }
  
}
