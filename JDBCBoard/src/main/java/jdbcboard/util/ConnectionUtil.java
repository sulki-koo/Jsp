package jdbcboard.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionUtil {
	
	private static ConnectionUtil connectionUtil = new ConnectionUtil();
	private static Properties databaseProperties;
	
	private ConnectionUtil() {	
		try {
			databaseProperties = new Properties();
			databaseProperties.load(
					new FileReader("D:/embededk/jee_workspace/JDBCBoard/src/main/webapp/WEB-INF/props/database.properties"));
			Class.forName(databaseProperties.getProperty("JDBC_DRIVER"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static ConnectionUtil getConnectionUtil() {
		return connectionUtil;
	}
	public Connection getConnection() throws Exception {
		return DriverManager.getConnection(
				databaseProperties.getProperty("JDBC_URL"), 
				databaseProperties.getProperty("JDBC_USER"), 
				databaseProperties.getProperty("JDBC_PASS")
		);
	}
	
	public void closeConnection(ResultSet rs, Statement stmt, Connection conn) throws Exception{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
	}

}
