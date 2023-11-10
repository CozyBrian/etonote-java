package me.briannewton.etonote.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/lists")
public class ListController {

  private final ListService listService;

  @Autowired
  public ListController(ListService listService) {
    this.listService = listService;
  }

  @GetMapping
  public java.util.List<List> getLists() {
    return listService.getLists();
  }
  
}
