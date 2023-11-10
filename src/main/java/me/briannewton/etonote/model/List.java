package me.briannewton.etonote.model;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lists")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class List {

  @Id
  @GeneratedValue
  private UUID id;
  private UUID userId;
  private String title;
  @Embedded
  private Icon icon;
  @OneToMany(
    cascade = CascadeType.ALL
  )
  @JoinColumn(name = "listId")
  private java.util.List<Todo> todos;

  public List(UUID id, UUID userId, String title, String iconType, String iconData) {
    this.id = id;
    this.userId = userId;
    this.title = title;
    this.icon = new Icon(iconType, iconData);
  }
  
  public List(UUID userId, String title, String iconType, String iconData) {
    this.title = title;
    this.userId = userId;
    this.icon = new Icon(iconType, iconData);
  }
}
