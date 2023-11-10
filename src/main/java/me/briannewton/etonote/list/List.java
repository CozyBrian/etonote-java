package me.briannewton.etonote.list;

import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "lists")
public class List {

  @Id
  @GeneratedValue
  private UUID id;
  private String title;
  private String iconType;
  private String iconData;

  public List() {
  }

  public List(String title, String iconType, String iconData) {
    this.title = title;
    this.iconType = iconType;
    this.iconData = iconData;
  }

  public List(UUID id, String title, String iconType, String iconData) {
    this.id = id;
    this.title = title;
    this.iconType = iconType;
    this.iconData = iconData;
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
  public String getIconType() {
    return iconType;
  }
  public void setIconType(String iconType) {
    this.iconType = iconType;
  }
  public String getIconData() {
    return iconData;
  }
  public void setIconData(String iconData) {
    this.iconData = iconData;
  }

  

  
}
