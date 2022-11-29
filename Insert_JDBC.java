package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Insert_JDBC {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//1.registering
			//2.connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
			//3.create statement
			Statement stmt=con.createStatement();
			//4.inserting data into database table
			stmt.executeUpdate("insert into student_manage values(5,'Abhisek',97472873,'Kolkata')");
			stmt.executeUpdate("insert into student_manage values(2,'Dev',9747235,'Kolkata')");
			stmt.executeUpdate("insert into student_manage values(3,'Arnab',97444873,'Kolkata')");
			stmt.executeUpdate("insert into student_manage values(4,'Deep',97472473,'Kolkata')");
					
			System.out.println("inserted successfully.");
			//5.closing connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
