package me.briannewton.etonote.service;

import me.briannewton.etonote.model.User;

public interface UserService {
  public User addUser(User user);

  public User getUserById(String id);

  public User getUserByEmail(String email);
}
