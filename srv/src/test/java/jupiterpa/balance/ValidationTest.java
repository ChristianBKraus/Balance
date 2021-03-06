package jupiterpa.balance;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import com.sap.cloud.sdk.hana.connectivity.cds.CDSException;
import java.sql.SQLException;
import javax.naming.NamingException;

import jupiterpa.balance.repository.RepositoryInterface;
import jupiterpa.balance.model.*;
import jupiterpa.util.odata.ValidationException;

public class ValidationTest {
	
	RepositoryInterface repo;
	Validation validation;	
	Account exists = new Account();
	
	@Before
	public void setup() throws CDSException, SQLException, NamingException {
		repo = mock(RepositoryInterface.class);

		exists.setName("Exists");
		exists.setID("1");

		when(repo.getAccountByName("NotExists")).thenReturn(null);
		when(repo.getAccountByName("Exists")).thenReturn(exists);
		
		when(repo.getAccountById("0")).thenReturn(null);
		when(repo.getAccountById("1")).thenReturn(exists);
		
		Balance bal = new Balance();
		bal.setId(1);
		bal.setName("Exists");
		bal.setAmount(10);
		
		when(repo.getBalanceByAccountId("1")).thenReturn(bal);
		
        validation = new Validation(repo);		
	}
	
	// Account
	@Test
	public void accountSuccess() throws ValidationException, CDSException, SQLException, NamingException {			
		Account acc = new Account();
		acc.setName("NotExists");

		validation.validate(acc);
	}
	
	@Test(expected = ValidationException.class)
	public void accountInitialName() throws ValidationException, CDSException, SQLException, NamingException {
		Account acc = new Account();
		
		validation.validate(acc);
	}
	
	@Test(expected = ValidationException.class)
	public void accountNameExists() throws ValidationException, CDSException, SQLException, NamingException {
		validation.validate(exists);
	}
	
	// Transaction
    @Test
    public void transactionSuccess() throws ValidationException, CDSException, SQLException, NamingException {
    	Transaction t = new Transaction();
    	t.setID("10");
    	t.setAccount(exists);
    	t.setAmount_value(5);
    	t.setAmount_unit("h");
    	
        validation.validate(t);
    }
    @Test(expected = ValidationException.class)
    public void transactionAccountInitial() throws ValidationException, CDSException, SQLException, NamingException {
    	Transaction t = new Transaction();
    	t.setID("10");
//    	t.setAccount(exists);
    	t.setAmount_value(5);
    	t.setAmount_unit("h");
    	
        validation.validate(t);
    }
    @Test(expected = ValidationException.class)
    public void transactionAccountNotExists() throws ValidationException, CDSException, SQLException, NamingException {
		Account acc = new Account();
		acc.setName("NotExists");
		acc.setID("1000");

		Transaction t = new Transaction();
    	t.setID("10");
    	t.setAccount(null);
    	t.setAmount_value(5);
    	t.setAmount_unit("h");
    	
        validation.validate(t);
    }
    @Test(expected = ValidationException.class)
    public void transactionBalanceLow() throws ValidationException, CDSException, SQLException, NamingException {
    	Transaction t = new Transaction();
    	t.setID("10");
    	t.setAccount(exists);
    	t.setAmount_value(-1000);
    	t.setAmount_unit("h");
    	
        validation.validate(t);
    }
    
    @Test
    public void balance() throws ValidationException, CDSException, SQLException, NamingException {
    	Balance balance = repo.getBalanceByAccountId("1");
    	org.junit.Assert.assertTrue(balance.getName().equals("Exists"));
    }
 }