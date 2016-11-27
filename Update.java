package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Update {
	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test?UseSSL=true", "root", "root");
		PreparedStatement statement = con.prepareStatement("update course SET ccode=?, cname=?, WHERE cid=?");
		// statement.setInt(1, 2);
		statement.setString(2, "11hs201");
		statement.setString(3, "signal");
		statement.setInt(1, 2);
		// statement.setString(5, "eligible");

		int update = statement.executeUpdate();
		if (update > 0)
			System.out.println("row is updated successfully!");
		con.close();
	}
}