package me.briannewton.etonote.model;

import org.hibernate.annotations.GenericGenerator;

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
  private String userId;
  private String title;
  @Embedded
  private Icon icon;
  @OneToMany(
    cascade = CascadeType.ALL
  )
  @JoinColumn(name = "listId")
  private java.util.List<Todo> todos;

  public List(String id, String userId, String title, String iconType, String iconData) {
    this.id = id;
    this.userId = userId;
    this.title = title;
    this.icon = new Icon(IconType.valueOf(iconType.toUpperCase()), iconData);
  }
  
  public List(String id, String userId, String title, Icon icon) {
    this.id = id;
    this.title = title;
    this.userId = userId;
    this.icon = icon;
  }
  
  public List(String userId, String title, String iconType, String iconData) {
    this.title = title;
    this.userId = userId;
    this.icon = new Icon(IconType.valueOf(iconType.toUpperCase()), iconData);
  }
}
