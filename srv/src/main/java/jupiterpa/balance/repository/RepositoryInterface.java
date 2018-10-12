package jupiterpa.balance.repository;

import java.sql.SQLException;

import javax.naming.NamingException;

import com.sap.cloud.sdk.hana.connectivity.cds.CDSException;

import jupiterpa.balance.model.*;

public interface RepositoryInterface {
	public Account getAccountByName(String name) throws SQLException, NamingException, CDSException;
	public Account getAccountById(String id) throws SQLException, NamingException, CDSException;
	public Balance getBalanceByAccountId(String id) throws SQLException, NamingException, CDSException;
}
