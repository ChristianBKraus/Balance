package jupiterpa.balance.repository;

import java.sql.SQLException;
import javax.naming.NamingException;
import com.sap.cloud.sdk.hana.connectivity.cds.CDSException;
import com.sap.cloud.sdk.service.prov.api.DataSourceHandler;

import jupiterpa.balance.model.*;
import jupiterpa.util.cds.CDSQueryExecution;

public class Repository implements RepositoryInterface {
	
	CDSQueryExecution exe = new CDSQueryExecution();
	DataSourceHandler handler;
	String namespace;
	
	public Repository(DataSourceHandler handler, String namespace) {
		this.handler = handler;
		this.namespace = namespace;
	}
	
	@Override
	public Account getAccountByName(String name) throws CDSException, SQLException, NamingException  {
		return exe.selectSingleAs("BalanceService.Account","Name", name, Account.class) ; 
	}

	@Override
	public Account getAccountById(String id) throws CDSException, SQLException, NamingException {
		return exe.selectSingleAs("BalanceService.Account","Id",id,Account.class);
	}

	@Override
	public Balance getBalanceByAccountId(String id) throws CDSException, SQLException, NamingException {
		return exe.selectSingleAs("BalanceService.Balance", "account_id",id,Balance.class);
	}
}
 