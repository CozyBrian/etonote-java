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
  private String title;

  @Embedded
  private Icon icon;

  public List(UUID id, String title, String iconType, String iconData) {
    this.id = id;
    this.title = title;
    this.icon = new Icon(iconType, iconData);
  }

  public List(String title, String iconType, String iconData) {
    this.title = title;
    this.icon = new Icon(iconType, iconData);
  }
}
