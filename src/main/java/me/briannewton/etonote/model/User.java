package me.briannewton.etonote.model;

import org.hibernate.annotations.GenericGenerator;

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
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
      name = "UUID",
      strategy = "org.hibernate.id.UUIDGenerator",
      parameters = {
          @org.hibernate.annotations.Parameter(
              name = "uuid_gen_strategy_class",
              value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
          )
      }
  )
  @Column(name = "id", columnDefinition = "VARCHAR(36)")
  private String id;
  private String username;
  private String password;
  @Column(nullable = false)
  private String email;
  @OneToMany(
    cascade = CascadeType.ALL
  )
  @JoinColumn(name = "userId")
  private java.util.List<List> lists;

  public User(String id, String username, String password, String email) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.email = email;
  }

  public User(String username, String password, String email) {
    this.username = username;
    this.password = password;
    this.email = email;
  }
}
