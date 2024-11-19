package com.abhiyantrikitech.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Service;

@Service
public class JdbcConnection {
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			if (con != null)
				System.out.println("Connection success ");
			else
				System.out.print("Connection fail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
