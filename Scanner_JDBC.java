package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Scanner_JDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter student name : ");
		String s_name=sc.next();
		System.out.println("enter city :");
		String city=sc.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//1.registering
			//2.connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
			//3.create statement
			PreparedStatement pstmt;
			//inserting data in database table
			String sql="insert into student_manage values(?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(2, s_name);
			pstmt.setString(4, city);
			pstmt.execute();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

}}
