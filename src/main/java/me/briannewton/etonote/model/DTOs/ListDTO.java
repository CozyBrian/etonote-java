package me.briannewton.etonote.model.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.briannewton.etonote.model.Icon;
import me.briannewton.etonote.model.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListDTO {
  private String id;
  private String userId;
  private String title;
  private Icon icon;

  public ListDTO(String userId, String title, String iconType, String iconData) {
    this.title = title;
    this.userId = userId;
    this.icon = new Icon(iconType, iconData);
  }

  public ListDTO(List list) {
    this.id = list.getId();
    this.userId = list.getUserId();
    this.title = list.getTitle();
    this.icon = list.getIcon();
  }
}
