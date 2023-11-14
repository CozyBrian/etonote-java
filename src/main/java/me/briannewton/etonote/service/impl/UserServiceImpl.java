package me.briannewton.etonote.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.briannewton.etonote.model.User;
import me.briannewton.etonote.repository.UserRepository;
import me.briannewton.etonote.service.UserService;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User addUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public User getUserById(String id) {
    return userRepository.findById(id).orElse(null);
  }

  @Override
  public User getUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }
  
}
