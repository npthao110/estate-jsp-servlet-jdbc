package com.laptrinhjavaweb.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.utils.ConnectionUtils;
import com.laptrinhjavaweb.utils.StringUtils;

public class BuildingJdbc {

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
		Integer floorArea = 100;

		try {
			// build SQL query
			StringBuilder query = new StringBuilder ("SELECT * FROM building " + SystemConstant.ONE_EQUAL_ONE +"");

			if(!StringUtils.isNullOrEmpty(name)) {
				query.append(" and name like '%" + name + "%'");
			}
			if(!StringUtils.isNullOrEmpty(street)) {
				query.append(" and street like '%" + street + "%'");
			}
			if(!StringUtils.isNullOrEmpty(ward)) {
				query.append(" and ward like '%" + ward + "%'");
			}
			if(!StringUtils.isNullOrEmpty(district)) {
				query.append(" and district like '%" + district + "%'");
			}
			if(floorArea != null) {
				query.append(" and floorArea like " + floorArea + "");
			}
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = ConnectionUtils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query.toString());
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
