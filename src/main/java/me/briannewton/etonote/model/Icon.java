package me.briannewton.etonote.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
  private String type;
  private String data;
}
