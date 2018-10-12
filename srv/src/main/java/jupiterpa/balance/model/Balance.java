package jupiterpa.balance.model;

import lombok.Data;

@Data
public class Balance {
  private Integer id;
  private String name;
  private Integer amount;
  private String unit;
}
