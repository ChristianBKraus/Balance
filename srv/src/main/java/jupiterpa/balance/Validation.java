package jupiterpa.balance;

import jupiterpa.util.odata.*;
import jupiterpa.balance.model.*;
//import jupiterpa.cds.*;
import jupiterpa.balance.repository.RepositoryInterface;

public class Validation {
	
	RepositoryInterface repo;
	public Validation(RepositoryInterface repo) {
		this.repo = repo;
	}
	
	public void validate(Account account) throws ValidationException {
		if (account.getName() == "") {
			throw new ValidationException("ACCOUNT_INITIAL_NAME");
		}
		if ( repo.getAccountByName( account.getName() ) != null ) {
			throw new ValidationException("ACCOUNT_NAME_EXISTS",account.getName());
		}
	}
	
	public void validate(Transaction transaction) throws ValidationException {
		if ( transaction.getAccount() == null ) {
			throw new ValidationException("Account of Transaction not specified");
		}
		 if ( repo.getAccountById(transaction.getAccount_ID()) == null ) {
		 	throw new ValidationException("Account with ID does not exist");			
		 }
		 if (transaction.getAmount() < 0.0) {
		 	Balance balance = repo.getBalanceByAccountId(transaction.getAccount_ID());
		 	if ( Math.abs( transaction.getAmount() ) > balance.getAmount() ) {
		 		throw new ValidationException("Not enough balance remaining");				
		 	}
		 }
	}
}
