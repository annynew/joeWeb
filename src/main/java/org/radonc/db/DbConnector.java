package org.radonc.db;

import org.apache.tomcat.jdbc.pool.DataSource;

public class DbConnector {
	
	private static DbConnector instance;
	
	private DbConnector(){
	}
	
	/*public final static void init(){
		 // Get a context for the JNDI look up
	    Context ctx = new InitialContext();
	    Context envContext = (Context) ctx.lookup("java:/comp/env");
	      
	    // Look up a data source
	    javax.sql.DataSource ds
	      = (javax.sql.DataSource) envContext.lookup ("jdbc/fitDataSource"); 
	    
	    return ds;

	}*/

}
