package com.bobAPI;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.ResultSet;

import java.sql.Statement;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.junit.Test;

public class storeDbTest {
	Store test = new Store();
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/api?serverTimezone=America/New_York";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "21022102";

	@Test
	public void HttpTest() throws Exception {
		String url = "http://localhost:8080/storeToDb?id=123&info=456";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost request = new HttpPost(url);
		httpclient.execute(request);
		Connection conn = null;
		Statement stmt = null;
		String var1 = "123";
		String var2 = "456";
		String result = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT" + " " + var1 + "," + var2 + " " + "FROM test";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// Retrieve by column name
				String var3 = rs.getString(var1);
				String var4 = rs.getString(var2);
				result = "ID:" + var3 + "," + "Info:" + var4;
			}
			assertEquals("ID:123,Info:456", result);
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
	}

}
