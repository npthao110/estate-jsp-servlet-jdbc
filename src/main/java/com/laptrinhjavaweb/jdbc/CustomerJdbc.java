package com.laptrinhjavaweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.laptrinhjavaweb.utils.StringUtils;

public class CustomerJdbc {
	static final String DB_URL = "jdbc:mysql://localhost:3306/javacore42024";
	static final String USER = "root";
	static final String PASS = "Caonguyenk1@";
	static final String QUERY = "SELECT * FROM building";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String fullName = null;
		
		try {
			StringBuilder query = new StringBuilder ("SELECT * FROM customer where 1 = 1");
			if(!StringUtils.isNullOrEmpty(fullName)) {
				query.append(" and name like '%"+fullName+"%'");
			}
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query.toString());
			ResultSetMetaData rsmd = rs.getMetaData();
			
			while(rs.next()){
				/*System.out.print("Id: " + rs.getLong("id") + ", Type: " + rsmd.getColumnType(1));
				System.out.print("Name: " + rs.getString("name"));
				System.out.print(", Street: " + rs.getString("street"));
				System.out.print(", District: " + rs.getString("district"));
				System.out.print(", Ward: " + rs.getString("ward"));
				System.out.println(", FloorArea: " + rs.getString("floorarea"));*/
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
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
