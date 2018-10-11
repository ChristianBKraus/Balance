package jupiterpa.balance.model;

import java.lang.String;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Generated("com.sap.cds.csn2jpa")
@Table(
    name = "jupiterpa_balance_Account"
)
@Entity
public class Account {
  @Column(
      nullable = false,
      length = 36
  )
  @Id
  private String ID;

  @Basic
  @Temporal(javax.persistence.TemporalType.TIMESTAMP)
  private Date admin_CreatedAt;

  @Column(
      length = 128
  )
  @Basic
  private String admin_CreatedBy;

  @Basic
  private String name;

  @Basic
  @Temporal(javax.persistence.TemporalType.TIMESTAMP)
  private Date admin_ChangedAt;

  @Column(
      length = 128
  )
  @Basic
  private String admin_ChangedBy;

  public Account() {
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

  public String getAdmin_CreatedBy() {
    return this.admin_CreatedBy;
  }

  public void setAdmin_CreatedBy(String admin_CreatedBy) {
    this.admin_CreatedBy = admin_CreatedBy;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
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
}
