package me.briannewton.etonote.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
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
  private String title;
  private Boolean isDone;
  private String listId;
  private String note;

  public Todo(String listId, String title, String note) {
    this.title = title;
    this.listId = listId;
    this.note = note;
    this.isDone = false;
  }

  public Todo(String title, Boolean isDone, String listId, String note) {
    this.title = title;
    this.isDone = isDone;
    this.listId = listId;
    this.note = note;
  }
}
