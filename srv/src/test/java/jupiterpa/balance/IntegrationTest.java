package jupiterpa.balance;

import java.util.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.*;
import com.sap.cloud.sdk.hana.connectivity.cds.*;
import com.sap.cloud.sdk.service.prov.api.EntityData;

import jupiterpa.util.cds.CDSQueryExecution;

public class IntegrationTest {
	
  //  @Test
  //  public void cds() throws SQLException {
  //  	try {
  //  		CDSQueryExecution exe = new CDSQueryExecution();
		// 	CDSQuery cdsQuery = 
		// 			new CDSSelectQueryBuilder("BalanceService.Account")
		// 			    .where(new ConditionBuilder().columnName("Name").EQ("Exists"))
		// 				.build();                                       
		// 	List<EntityData> list = 
		// 			exe.execute(cdsQuery);
		// } catch (CDSException e) {
		// 	e.printStackTrace();
		// }
  //  }
 }