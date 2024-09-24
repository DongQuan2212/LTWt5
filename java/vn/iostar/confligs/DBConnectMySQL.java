package vn.iostar.confligs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectMySQL {
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String USERNAME = "root";
	private static String PASSWORD = "12345678";
	private static String URL = "jdbc:mysql://localhost:3306/laptrinhwebt5";

	public static Connection getConnection() throws SQLException, Exception {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		try (Connection conn = getConnection()) {
			if (conn != null) {
				System.out.println("Successfully connected to the database.");
			} else {
				System.out.println("ok.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
