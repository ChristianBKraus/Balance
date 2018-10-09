package jupiterpa.balance.model;

import java.lang.Integer;
import java.lang.String;

public class Balance {
  private Integer id;
  private String name;
  private Integer amount;

  public Balance() {
  }

  public Balance(Integer id, String name, Integer amount) {
	super();
	this.id = id;
	this.name = name;
	this.amount = amount;
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getAmount() {
	return amount;
}
public void setAmount(Integer amount) {
	this.amount = amount;
}
@Override
public String toString() {
	return "Balance [id=" + id + ", name=" + name + ", amount=" + amount + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((amount == null) ? 0 : amount.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Balance other = (Balance) obj;
	if (amount == null) {
		if (other.amount != null)
			return false;
	} else if (!amount.equals(other.amount))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}

}
