package com.bobAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Store {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/api?serverTimezone=America/New_York";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "21022102";

	@RequestMapping("/storeToDb")
	public String storeToDb(String id, String info) {
		Connection conn = null;
		Statement stmt = null;
		String result = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connecting to database successfully");
			System.out.println("inserting the record to the table...");
			stmt = conn.createStatement();
			String sql1;
			sql1 = "INSERT INTO TEST" + "(id, name)" + "VALUES ('"+id +"'"+",'" + info +"')";
			stmt.executeUpdate(sql1);
			System.out.println("Inserted records into the table...");
			String sql2;
			sql2 = "SELECT" + " " + id + "," + info + " " + "FROM test";
			ResultSet rs = stmt.executeQuery(sql2);
			System.out.println("Inquery records from the table...");
			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				String var1 = rs.getString(id);
				String var2 = rs.getString(info);
				result = "ID:" + var1 + "," + "Info:" + var2;
			}
		}

		catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		return result;

	}

}
