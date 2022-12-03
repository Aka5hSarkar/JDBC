package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Helper {
	//register mysql driver
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//connection mysql driver
	public static Connection con()throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
	}
	public static void main(String[] args) throws SQLException {
		MenuDrivenEg obj=new MenuDrivenEg();
		obj.saveMenudriven();
		obj.updateMenydriven();
		obj.deleteMenudriven();
		obj.fetchMenudriven();
	}
}
