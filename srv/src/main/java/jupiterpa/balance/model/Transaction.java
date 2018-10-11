package jupiterpa.balance.model;

import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Generated("com.sap.cds.csn2jpa")
@Table(
    name = "jupiterpa_balance_Transaction"
)
@Entity
public class Transaction {
  @Column(
      nullable = false,
      length = 36
  )
  @Id
  private String ID;

  @Basic
  @Temporal(javax.persistence.TemporalType.TIMESTAMP)
  private Date admin_CreatedAt;

  @Basic
  private Integer amount_value;

  @Column(
      length = 128
  )
  @Basic
  private String admin_CreatedBy;

  @Column(
      length = 10
  )
  @Basic
  private String amount_unit;

  @Basic
  @Temporal(javax.persistence.TemporalType.TIMESTAMP)
  private Date admin_ChangedAt;

  @Column(
      length = 128
  )
  @Basic
  private String admin_ChangedBy;

  @Column(
      insertable = false,
      updatable = false,
      length = 36
  )
  @Basic
  private String account_ID;

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

  public Date getAdmin_CreatedAt() {
    return this.admin_CreatedAt;
  }

  public void setAdmin_CreatedAt(Date admin_CreatedAt) {
    this.admin_CreatedAt = admin_CreatedAt;
  }

  public Integer getAmount_value() {
    return this.amount_value;
  }

  public void setAmount_value(Integer amount_value) {
    this.amount_value = amount_value;
  }

  public String getAdmin_CreatedBy() {
    return this.admin_CreatedBy;
  }

  public void setAdmin_CreatedBy(String admin_CreatedBy) {
    this.admin_CreatedBy = admin_CreatedBy;
  }

  public String getAmount_unit() {
    return this.amount_unit;
  }

  public void setAmount_unit(String amount_unit) {
    this.amount_unit = amount_unit;
  }

  public Date getAdmin_ChangedAt() {
    return this.admin_ChangedAt;
  }

  public void setAdmin_ChangedAt(Date admin_ChangedAt) {
    this.admin_ChangedAt = admin_ChangedAt;
  }

  public String getAdmin_ChangedBy() {
    return this.admin_ChangedBy;
  }

  public void setAdmin_ChangedBy(String admin_ChangedBy) {
    this.admin_ChangedBy = admin_ChangedBy;
  }

  public String getAccount_ID() {
    return this.account_ID;
  }

  public Account getAccount() {
    return this.account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }
}
