package me.briannewton.etonote.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todos")
public class Todo {
  @Id
  @GeneratedValue
  private UUID id;
  private String title;
  private Boolean isDone;
  private String listId;
  private String note;

  public Todo() {
  }

  public Todo(UUID id, String title, Boolean isDone, String listId, String note) {
    this.id = id;
    this.title = title;
    this.isDone = isDone;
    this.listId = listId;
    this.note = note;
  }

  public Todo(String title, Boolean isDone, String listId, String note) {
    this.title = title;
    this.isDone = isDone;
    this.listId = listId;
    this.note = note;
  }

  public UUID getId() {
    return id;
  }
  public void setId(UUID id) {
    this.id = id;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public Boolean getIsDone() {
    return isDone;
  }
  public void setIsDone(Boolean isDone) {
    this.isDone = isDone;
  }
  public String getListId() {
    return listId;
  }
  public void setListId(String listId) {
    this.listId = listId;
  }
  public String getNote() {
    return note;
  }
  public void setNote(String note) {
    this.note = note;
  }

  
}
