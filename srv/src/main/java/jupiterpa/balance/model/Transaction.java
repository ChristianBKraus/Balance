package jupiterpa.balance.model;

import java.lang.Integer;
import javax.annotation.Generated;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Generated("com.sap.cds.csn2jpa")
@Table(
    name = "jupiterpa_accounting_Transaction"
)
@Entity
public class Transaction {
  @Column(
      nullable = false
  )
  @Id
  private String ID;

  @Basic
  private Integer amount;

  @Column(
      insertable = false,
      updatable = false
  )
  @Basic
  private Integer account_ID;

  @JoinColumn(
      name = "account_ID",
      referencedColumnName = "ID"
  )
  @ManyToOne
  private Account account;

  public Transaction() {
  }

  public String getID() {
    return this.ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public Integer getAmount() {
    return this.amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public Integer getAccount_ID() {
    return this.account_ID;
  }

  public Account getAccount() {
    return this.account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }
}
