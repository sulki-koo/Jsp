package jspmvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String JDBC_USER = "mvc";
	private static String JDBC_PASS = "mvc";

	static {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	public Connection getConnection() throws Exception {
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
	}

	public void closeConnection(Connection conn) throws Exception {
		if (conn != null) {
			conn.close();
		}
	}

}
