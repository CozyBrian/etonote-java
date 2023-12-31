package me.briannewton.etonote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import me.briannewton.etonote.model.List;
import me.briannewton.etonote.model.DTOs.ListDTO;
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
  public ResponseEntity<java.util.List<ListDTO>> getListsByUserId(@RequestParam String userId) {
    java.util.List<ListDTO> userLists = listService.getUserLists(userId);
    return ResponseEntity.ok(userLists);
  }

  @GetMapping(path = "/")
  public ResponseEntity<java.util.List<ListDTO>> getAllLists() {
    java.util.List<ListDTO> allLists = listService.getAllLists();
    return ResponseEntity.ok(allLists);
  }

  @GetMapping(path = "{listId}")
  public ResponseEntity<List> getList(@PathVariable String listId) {
    return listService.getList(listId)
      .map(list -> ResponseEntity.ok().body(list))
      .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<List> addList(@RequestBody List list) {
    List newList = listService.addList(list);
    return ResponseEntity.status(201).body(newList);
  }
  
}
