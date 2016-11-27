package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;;

public class Add {
	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test?UseSSL=true", "root", "root");
		PreparedStatement statement = con.prepareStatement("INSERT into course (cid, ccode, cname, duration, eligibility) VALUES (?, ?, ?, ?, ?)");
		statement.setInt(1, 1);
		statement.setString(2, "11hs201");
		statement.setString(3, "signal");
		statement.setInt(4, 2);
		statement.setString(5, "eligible");

		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0)
			System.out.println("A new row is inserted successfully!");
		con.close();
	}
}
