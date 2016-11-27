package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Delete {
	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test?UseSSL=true", "root", "root");
		PreparedStatement statement = con.prepareStatement("delete from course where cid=?");
		statement.setInt(1, 2);
		statement.executeUpdate();
		con.close();
	}
}