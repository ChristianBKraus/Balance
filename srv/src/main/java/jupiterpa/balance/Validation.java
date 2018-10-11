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
		if (account.getName() == null || account.getName().isEmpty()) {
			throw new ValidationException("ACCOUNT_INITIAL_NAME");
		}
		if ( repo.getAccountByName( account.getName() ) != null ) {
			throw new ValidationException("ACCOUNT_NAME_EXISTS",account.getName());
		}
	}
	
	public void validate(Transaction transaction) throws ValidationException {
		if ( transaction.getAccount() == null ) {
			throw new ValidationException("TRANSACTION_ACCOUNT_INITIAL");
		}
		Account acc = transaction.getAccount();  
		
		 if ( repo.getAccountById(transaction.getAccount().getID()) == null ) {
		 	throw new ValidationException("TRANSACTION_ACCOUNT_NOT_EXISTS",transaction.getAccount_ID().toString());			
		 }
		 if (transaction.getAmount() < 0.0) {
		 	Balance balance = repo.getBalanceByAccountId(transaction.getAccount().getID());
		 	if ( Math.abs( transaction.getAmount() ) > balance.getAmount() ) {
		 		throw new ValidationException("TRANSACTION_BALANCE_LOW",transaction.getAccount().getID().toString(),balance.getAmount().toString());				
		 	}
		 }
	}
}
