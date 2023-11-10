package me.briannewton.etonote.model;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
  name = "users",
  uniqueConstraints = @UniqueConstraint(
    columnNames = "email", name = "unique_email"
  )
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  @GeneratedValue
  private UUID id;
  private String username;
  private String password;
  @Column(nullable = false)
  private String email;

  public User(String username, String password, String email) {
    this.username = username;
    this.password = password;
    this.email = email;
  }
}
