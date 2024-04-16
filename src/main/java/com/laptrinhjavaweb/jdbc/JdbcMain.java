package com.laptrinhjavaweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcMain {
	static final String DB_URL = "jdbc:mysql://localhost:3306/javacore42024";
	static final String USER = "root";
	static final String PASS = "Caonguyenk1@";
	static final String QUERY = "SELECT * FROM building";

	public static void main(String[] args) {
		// beginner code
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		// input
		String name = null;
		String street = null;
		String ward = null;
		String district = null;
		Integer floorArea = null;
		Integer numberOfBasement = null;

		try {
			// build SQL query
			String query = "SELECT * FROM building where 1 = 1";
			if(name != null && name != "") {
				query += " and name like '%"+name+"%'";
			}
			if(street != null && street != "") {
				query += " and street like '%"+street+"%'";
			}
			if(ward != null && ward != "") {
				query += " and ward like '%"+ward+"%'";
			}
			if(district != null && district != "") {
				query += " and district like '%"+district+"%'";
			}
			if(floorArea != null) {
				query += " and floorArea like "+floorArea+"";
			}
			if(numberOfBasement != null) {
				query += "and numberOfBasement like "+numberOfBasement+"";
			}
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(QUERY);
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()){
				System.out.print("Id: " + rs.getLong("id") + ", Type: " + rsmd.getColumnType(1));
				System.out.print("Name: " + rs.getString("name"));
				System.out.print(", Street: " + rs.getString("street"));
				System.out.print(", District: " + rs.getString("district"));
				System.out.print(", Ward: " + rs.getString("ward"));
				System.out.println(", FloorArea: " + rs.getString("floorarea"));
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if(conn != null) conn.close();
				if(stmt != null) stmt.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}
