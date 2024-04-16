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
		   //experienced code
		   /*try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(QUERY);
	      ) {		      
	         while(rs.next()){
	            //Display values
	            System.out.print("Name: " + rs.getString("name"));
	            System.out.print(", Street: " + rs.getString("street"));
	            System.out.print(", District: " + rs.getString("district"));
	            System.out.print(", Ward: " + rs.getString("ward"));
	            System.out.println(", FloorArea: " + rs.getString("floorarea"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }*/
		   
		   // beginner code
		   try {
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		       Statement stmt = conn.createStatement();
		       ResultSet rs = stmt.executeQuery(QUERY);
		       while(rs.next()){
		            System.out.print("Name: " + rs.getString("name"));
		            System.out.print(", Street: " + rs.getString("street"));
		            System.out.print(", District: " + rs.getString("district"));
		            System.out.print(", Ward: " + rs.getString("ward"));
		            System.out.println(", FloorArea: " + rs.getString("floorarea"));
		       }
		       conn.close();
		       stmt.close();
		       rs.close();
		   } catch (ClassNotFoundException | SQLException e) {
			   System.out.println("Error: " + e.getMessage());
		   }
		   
	   }
}
