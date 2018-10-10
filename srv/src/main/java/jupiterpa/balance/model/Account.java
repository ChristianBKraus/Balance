package jupiterpa.balance.model;

import java.lang.Integer;
import java.lang.String;
import javax.annotation.Generated;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Generated("com.sap.cds.csn2jpa")
@Table(
    name = "jupiterpa_accounting_Account"
)
@Entity
public class Account {
  @Column(
      nullable = false
  )
  @Id
  private Integer ID;

  @Basic
  private String name;

  public Account() {
  }

  public Integer getID() {
    return this.ID;
  }

  public void setID(Integer ID) {
    this.ID = ID;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
