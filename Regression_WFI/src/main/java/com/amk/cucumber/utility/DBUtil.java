package com.amk.cucumber.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class DBUtil {
	
	protected SeleniumCore seleniumCore;
    protected Logger logger;

	private static final String USER = "user=";
	private static final String PWD = "password=";
	private static final String SECURITY = "integratedSecurity=true";
	private static final String SECURITYAZ = "integratedSecurity=false";
	private static final String SEPARATOR = ";";
	private static final String SERVER = "jdbc:sqlserver://";
//	private static final String DATABASE = "database=Transfer";
	private static final String DATABASE = "database=AccountDistributions";

	private static final String Encrypt = "encrypt=true";
	private static final String trustServerCertificate = "trustServerCertificate=true";
	private static final String AUTHENTICATION = "authentication=ActiveDirectoryPassword";

	private String db_connect_string;
	private Statement statement;
	private static ConfigReader configReader;
	
	 public DBUtil(SeleniumCore seleniumCore) {
	        this.seleniumCore = seleniumCore;
	        this.logger = seleniumCore.getLogger();   
	 }

	/**
	 * To execute the give sql query and get the given column values in a List.
	 *
	 * @param selectQuery  - The sql query
	 * @param columnName   - The column name
	 * @param recordsCount - The number of records to fetch from the result
	 * @return - List of values from the DB
	 */

	public void setupDBConnection(String db) {
		if (db_connect_string == null) {
			registerDBDriver();
			db_connect_string = getDbConnectString(db);
			logger.info("--------*******  : " + db_connect_string);
		}
		try {
			Connection connection = DriverManager.getConnection(db_connect_string);
			statement = connection.createStatement();
		} catch (SQLException e) {
			logger.info("====   ==== Throwing error");
			logger.info(e.getLocalizedMessage());			
		}
	}

	public void setupAzureDBConnection(String serverHost, String username, String password, String name) {
		if (db_connect_string == null) {
			registerDBDriver();
			db_connect_string = getConnectStringAZ(serverHost, username, password, name);
	//		db_connect_string = getConnectStringAZ(serverHost, username, password);
			logger.info("--------*******  : " + db_connect_string);			
		}
		try {
			Connection connection = DriverManager.getConnection(db_connect_string);			
			statement = connection.createStatement();
			} catch (SQLException e) {
			logger.info("====   ==== Throwing error");			
			logger.info(e.getLocalizedMessage());				
		}
	}

	public List<String> executeSelectQueryAndGetStringList(String selectQuery, String columnName,Integer recordsCount) {
		List<String> listOfValues = new ArrayList<>();
		int counter = 0;
		try (ResultSet rs = statement.executeQuery(selectQuery)) {
			logger.info("Query completed on " + columnName);
			while (rs.next()) {  
				String value = rs.getString(columnName);
				listOfValues.add(value);
				counter++;
				if (recordsCount != null && counter == recordsCount) {
					break;
				}
			}
		} catch (SQLException e) {
			logger.info("====   ==== Throwing error");
			logger.info(e.getLocalizedMessage());
		}
		return listOfValues;
	}
	
	public List<String[]> executeSelectQueryAndGetStringList(String selectQuery) {
		List<String[]> records = new ArrayList<>();	
		try (ResultSet rs = statement.executeQuery(selectQuery)) {
			
			// Get the result set metadata
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();    
            
			while (rs.next()) { 				
			// Create an array to store the row data
                String[] rowData = new String[columnCount];
                
             // Fetch each column value and add it to the row data array
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getString(i);
                }
                records.add(rowData);
			}			
		} catch (SQLException e) {
			logger.info("====   ==== Throwing error");
			logger.error(e.getMessage());
		}
		return records;
	}
	
	public void executeUpdateQuery(String selectQuery) throws SQLException {		
		int rs = statement.executeUpdate(selectQuery);
			logger.info("Query has been executed "+ rs);	
	}

	/**
	 * To execute the give sql query and get the given column values in a List.
	 *
	 * @param selectQuery - The sql query
	 * @param columnName  - The column name
	 * @return - List of values from the DB
	 */
	public List<String> executeSelectQueryAndGetStringList(String selectQuery, String columnName) {
		return executeSelectQueryAndGetStringList(selectQuery, columnName, null);
	}

	/**
	 * To execute the given query and get the first result column value
	 *
	 * @param selectQuery - The select query
	 * @param columnName  - The columnName to fetch
	 * @return - The first result column value
	 */
	public String executeQueryAndGetFirstValue(String selectQuery, String columnName) {
		List<String> list = executeSelectQueryAndGetStringList(selectQuery, columnName, 1);
		return list != null ? list.get(0) : null;
	}

	/**
	 * To get the connect string using the given server host and user name
	 *
	 * @param serverHost
	 * @param username
	 * @return
	 */	
	public static String getConnectString(String serverHost, String username) {
		return SERVER + serverHost + SEPARATOR + SECURITY + SEPARATOR + USER + username + SEPARATOR + Encrypt
				+ SEPARATOR + trustServerCertificate + SEPARATOR;
	}	
	
	public static String getConnectString(String serverHost, String username, String password) {
		return SERVER + serverHost + SEPARATOR + Encrypt + SEPARATOR + USER + username + SEPARATOR + PWD + password
				+ SEPARATOR + trustServerCertificate + SEPARATOR;
	}

	public static String getConnectStringAZ(String serverHost, String username, String password) {
		return SERVER + serverHost + SEPARATOR + DATABASE + SEPARATOR + AUTHENTICATION + SEPARATOR + SECURITYAZ
				+ SEPARATOR + USER + username + SEPARATOR + PWD + password + SEPARATOR + Encrypt + SEPARATOR
				+ trustServerCertificate + SEPARATOR;
		
	}
		
	public static String getConnectStringAZ(String serverHost, String username, String password, String dbName) {	
		return SERVER + serverHost + SEPARATOR + dbName + SEPARATOR + AUTHENTICATION + SEPARATOR + SECURITYAZ
				+ SEPARATOR + USER + username + SEPARATOR + PWD + password + SEPARATOR + Encrypt + SEPARATOR
				+ trustServerCertificate + SEPARATOR;
		 
	}	

	/**
	 * To get the connect string using the DB details from config.json
	 *
	 * @return
	 */
	public static String getDbConnectString(String db) {
		configReader = new ConfigReader();
		String serverHost = "";
		String username = "";
		String password = "";
		if (db.equals("ewm")) {
			serverHost = configReader.get_DB_EWM_HostName();
			 username = configReader.get_DB_EWM_UserName();
			 password = configReader.get_DB_EWM_Password();
		} else if (db.equals("bpm")) {
			serverHost = configReader.get_DB_BPM_HostName();
			username = configReader.get_DB_BPM_UserName();
			password = configReader.get_DB_BPM_Password();
		}
		return getConnectString(serverHost, username, password);
	}

	/**
	 * Register DB Driver
	 */
	private void registerDBDriver() {
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			logger.info("dbDriver registration successful");
		} catch (SQLException ex) {
			logger.error("Error registration dbDriver "+ ex.getMessage());
		}
	}

}
