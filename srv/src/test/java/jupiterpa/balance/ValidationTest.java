package jupiterpa.balance;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import jupiterpa.balance.repository.RepositoryInterface;
import jupiterpa.balance.model.*;
import jupiterpa.balance.odata.*;

import jupiterpa.util.cds.CDSQueryExecution;
import jupiterpa.util.odata.ValidationException;

public class ValidationTest {
	
	RepositoryInterface repo;
	Validation validation;	
	@Before
	public void setup() {
		repo = mock(RepositoryInterface.class);

		when(repo.getAccountByName("NotExists")).thenReturn(null);
		Account acc = new Account();
		acc.setName("Exists");
		acc.setId(1);
		when(repo.getAccountByName("Exists")).thenReturn(acc);
		
		when(repo.getAccountById(0)).thenReturn(null);
		when(repo.getAccountById(1)).thenReturn(new Account(1,"Exists"));
		
		when(repo.getBalanceByAccountId(1)).thenReturn(new Balance(1,"Exists",10));
		
        validation = new Validation(repo);		
	}
	
	// Account
	@Test
	public void accountSuccess() throws ValidationException {			
		validation.validate(new Account(0,"NotExists"));
	}
	
	@Test(expected = ValidationException.class)
	public void accountInitialName() throws ValidationException {
		validation.validate(new Account(0,""));
	}
	
	@Test(expected = ValidationException.class)
	public void accountNameExists() throws ValidationException {
		validation.validate(new Account(1,"Exists"));
	}
	
	// Transaction
    @Test
    public void transactionSuccess() throws ValidationException {
        validation.validate(new Transaction(10,new Account(1,"Exists"),5));
    }
    
 }