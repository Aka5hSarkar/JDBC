package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Update_JDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//1.registering
			//2.connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
			//3.create statement
			Statement stmt=con.createStatement();
			//updating an existing record
			stmt.executeUpdate("update student_manage set city='West Bengal' where s_id=2");
			//delete record
			stmt.executeUpdate("delete from student_manage where s_id=5");
			//execute query fetch data from database
			ResultSet rs=stmt.executeQuery("select * from student_manage");
			//iterating through columns
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
			}
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
