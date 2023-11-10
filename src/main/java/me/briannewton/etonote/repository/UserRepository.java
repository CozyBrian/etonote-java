package me.briannewton.etonote.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.briannewton.etonote.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
  public User findByEmail(String email);
}
