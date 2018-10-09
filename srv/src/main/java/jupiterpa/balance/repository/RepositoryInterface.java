package jupiterpa.balance.repository;

import jupiterpa.balance.model.*;

public interface RepositoryInterface {
	public Account getAccountByName(String name);
	public Account getAccountById(Integer id);
	public Balance getBalanceByAccountId(Integer id);
}
