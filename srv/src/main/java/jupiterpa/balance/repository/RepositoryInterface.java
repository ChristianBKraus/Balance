package jupiterpa.balance.repository;

import jupiterpa.balance.model.*;

public interface RepositoryInterface {
	public Account getAccountByName(String name);
	public Account getAccountById(String id);
	public Balance getBalanceByAccountId(String id);
}
