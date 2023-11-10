package me.briannewton.etonote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import me.briannewton.etonote.model.User;
import me.briannewton.etonote.service.UserService;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public User getUserById(@RequestParam("id") String id) {
    return userService.getUserById(id);
  }
  
}