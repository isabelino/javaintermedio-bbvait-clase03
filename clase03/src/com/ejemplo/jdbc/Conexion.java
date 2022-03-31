package com.ejemplo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	public static Connection conectar() {
		String db_name = "db_jdbc";
		String url = "jdbc:mysql://localhost:3306/"+db_name;
		String username = "root";
		String password = "";
		Connection conn=null;
		
		try {
			
			 conn= DriverManager.getConnection(url, username, password);
			if(conn != null) {
				System.out.println("Conexión exitosa");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
