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
		try {
			CDSQuery cdsQuery = 
					new CDSSelectQueryBuilder("BalanceService.Account")
					    .where(new ConditionBuilder().columnName("Name").EQ(name))
						.build();                                       
			List<EntityData> list = 
					exe.execute(cdsQuery);
			if (list.size() > 0) {
				return list.get(0).as(Account.class);
			} else 
				return null;
		} catch (CDSException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Account getAccountById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Balance getBalanceByAccountId(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
