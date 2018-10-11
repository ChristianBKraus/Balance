package jupiterpa.balance.repository;

import java.sql.SQLException;
import java.util.List;

import com.sap.cloud.sdk.hana.connectivity.cds.CDSException;
import com.sap.cloud.sdk.hana.connectivity.cds.CDSQuery;
import com.sap.cloud.sdk.hana.connectivity.cds.CDSSelectQueryBuilder;
import com.sap.cloud.sdk.hana.connectivity.cds.ConditionBuilder;
import com.sap.cloud.sdk.service.prov.api.DataSourceHandler;
import com.sap.cloud.sdk.service.prov.api.EntityData;

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
	public Account getAccountByName(String name) {
		return exe.selectSingleAs("BalanceService.Account","Name", name, Account.class) ; 
	}

	@Override
	public Account getAccountById(String id) {
		return exe.selectSingleAs("BalanceService.Account","Id",id,Account.class);
	}

	@Override
	public Balance getBalanceByAccountId(String id) {
		return exe.selectSingleAs("BalanceService.Balance", "account_id",id,Balance.class);
	}
}
 