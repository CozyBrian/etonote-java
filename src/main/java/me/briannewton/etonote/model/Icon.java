package me.briannewton.etonote.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
  @AttributeOverride(name = "type", column = @Column(name = "icon_type")),
  @AttributeOverride(name = "data", column = @Column(name = "icon_data"))
})
public class Icon {
  @Enumerated(EnumType.STRING)
  private IconType type;
  private String data;

  public Icon(String type, String data) {
    this.type = IconType.valueOf(type);
    this.data = data;
  }
}