package com.student;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MenuDrivenEg {

		Scanner sc=new Scanner(System.in);
		int emp_id,age,sal;
		String emp_name,city;
		//saving employee details in database
		public void saveMenudriven() throws SQLException{
			System.out.println("enter id : ");
			emp_id=sc.nextInt();
			System.out.println("enter name : ");
			emp_name=sc.next();
			System.out.println("enter age : ");
			age=sc.nextInt();
			System.out.println("enter salary : ");
			sal=sc.nextInt();
			System.out.println("enter city : ");
			city=sc.next();
			Connection conn=Helper.con();
			PreparedStatement stmt=conn.prepareStatement("insert into menu_driven values(?,?,?,?,?)");
			stmt.setInt(1, emp_id);
			stmt.setString(2, emp_name);
			stmt.setInt(3,age);
			stmt.setString(4, city);
			stmt.setInt(5, sal);
			stmt.executeUpdate();
		}
		//fetching the details /display
		public void fetchMenudriven() throws SQLException{
			Connection conn=Helper.con();
			Statement stmt=conn.createStatement();
			//execute query fetch data from database
			ResultSet rs=stmt.executeQuery("select*from menu_driven");
			//iteration
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+
			rs.getString(4)+" "+rs.getInt(5));
			}
		}
		//updating employee details in the database
		public void updateMenydriven()throws SQLException{
			Connection conn=Helper.con();
			Statement stmt=conn.createStatement();
			System.out.println("enter city : ");
			city=sc.next();
			stmt.executeUpdate("update menu_driven set city=' "+city+" ' where emp_id= "+emp_id);
		}
		//deleting details
		public void deleteMenudriven() throws SQLException{
			Connection conn=Helper.con();
			Statement stmt=conn.createStatement();
			System.out.println("enter id : ");
			emp_id=sc.nextInt();
			stmt.executeUpdate("delete from menu_driven where emp_id="+emp_id);
		}
	}


