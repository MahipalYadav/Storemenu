package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionmenu {
		private static Connection con;
		
		public static Connection getConnection() throws SQLException {
			
			String url ="jdbc:postgresql://database-1.cwcnxw82qp5m.us-east-1.rds.amazonaws.com:5432/postgres";
			String username ="postgres";
			String password ="mahipalyadav";
			
			if(con == null || con.isClosed()) {
				con = DriverManager.getConnection(url, username, password);
			}
			return con;
		}

}
