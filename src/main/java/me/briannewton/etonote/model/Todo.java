package me.briannewton.etonote.model;

import java.util.UUID;

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
  @GeneratedValue
  private UUID id;
  private String title;
  private Boolean isDone;
  private UUID listId;
  private String note;

  public Todo(String title, Boolean isDone, UUID listId, String note) {
    this.title = title;
    this.isDone = isDone;
    this.listId = listId;
    this.note = note;
  }
}
