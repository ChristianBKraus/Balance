package jupiterpa.util.cds;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sap.cloud.sdk.hana.connectivity.cds.CDSException;
import com.sap.cloud.sdk.hana.connectivity.cds.CDSQuery;
import com.sap.cloud.sdk.hana.connectivity.handler.CDSDataSourceHandler;
import com.sap.cloud.sdk.hana.connectivity.handler.DataSourceHandlerFactory;
import com.sap.cloud.sdk.service.prov.api.EntityData;

public class CDSQueryExecution {
	private static final Logger logger = LoggerFactory.getLogger(CDSQueryExecution.class);
	
	String namespace;
	public CDSQueryExecution() {}
	public CDSQueryExecution(String namespace) {
		this.namespace = namespace;
	}
	private static Connection getConnection() throws SQLException {
		Connection conn = null;
		Context ctx;
		try {
			ctx = new InitialContext();
			logger.error("Context: ",ctx);
			if (ctx == null) logger.error("Context initial");
			conn = ((DataSource) ctx.lookup("java:comp/env/jdbc/java-hdi-container")).getConnection();	
			logger.error("Connection to HANA successfull",ctx,conn);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception");
		}
		return conn;
	}
	private CDSDataSourceHandler getCDSHandler() throws SQLException {
		CDSDataSourceHandler dsHandler = 
				DataSourceHandlerFactory.getInstance()
					.getCDSHandler(getConnection(), namespace);
		return dsHandler;
	}
	public List<EntityData> execute(CDSQuery cdsQuery) throws CDSException, SQLException {
		logger.error("Start Query");
		List<EntityData> list = 
				getCDSHandler().executeQuery(cdsQuery)
					.getResult();
	    logger.info("Query successful");
		return list;
	}

}
