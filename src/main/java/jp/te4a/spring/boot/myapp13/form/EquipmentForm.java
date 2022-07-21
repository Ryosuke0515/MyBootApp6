package jp.te4a.spring.boot.myapp13.form;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class EquipmentForm {
  @NotNull
  @Size(max = 9)
  private String machine_id;
  @NotNull
  @Size(max = 40)
  private String name;
  @NotNull
  @Size(max = 200)
  private String model_number;
  @NotNull
  @Size(max = 200)
  private String maker;
  @NotNull
  @Size(max = 200)
  private String spec;
  @DateTimeFormat(pattern = "yyyy/mm/dd")
  private Date purchase_date;
  private Integer useful_life;
  private String depreciation;
  private Boolean availability;
  private Boolean loanability;
  @NotNull
  @Size(max = 40)
  private String location;
  @DateTimeFormat(pattern = "yyyy/mm/dd")
  private Date expiration_date;
  
}
