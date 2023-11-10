package me.briannewton.etonote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.briannewton.etonote.model.User;
import me.briannewton.etonote.repository.UserRepository;

@Service
public class UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User addUser(User user) {
    return userRepository.save(user);
  }

  public User getUserById(String id) {
    return userRepository.findById(id).orElse(null);
  }

  public User getUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }
  
}
