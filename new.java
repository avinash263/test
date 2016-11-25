package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbUpdate {

	public static void main(String[] args) throws Exception {
		Connection dbConnection = null;
		PreparedStatement PSInsert = null;
		PreparedStatement PSUpdate = null;
		PreparedStatement PSDelete = null;

		String insertTable = "INSERT INTO course"
				+ "(cid,ccode,cname, duration,eligibility)VALUES"
				+ "(? , ? , ? , ?,?)";
		String updateTable = "UPDATE course SET cname = ?" + "WHERE cid = ?";
		String deleteTable = "DELETE FROM course " + "WHERE cid = ?";
		try {
			dbConnection = getDBConnection();
			dbConnection.setAutoCommit(false);
			// for insert
			PSInsert = dbConnection.prepareStatement(insertTable);
			PSInsert.setString(1, "1");
			PSInsert.setString(2, "j-001");
			PSInsert.setString(3, "java");
			PSInsert.setString(4, "14");
			PSInsert.setString(5, "16");
			PSInsert.executeUpdate();
			dbConnection.commit();
			// for update
			PSUpdate = dbConnection.prepareStatement(updateTable);
			PSUpdate.setString(2, "N-001");
			PSUpdate.setString(3, ".net");
			PSUpdate.executeUpdate();
			dbConnection.commit();

			// for delete
			PSDelete = dbConnection.prepareStatement(deleteTable);
			PSDelete.setString(1, "04");
			PSDelete.executeUpdate();
			dbConnection.commit();

			System.out.println("Done..!!!");
		} catch (SQLException e) {
			System.out.println("Error occured " + e.toString());
			dbConnection.rollback();
		} finally {
			if (PSInsert != null) {
				PSInsert.close();
			}
			if (PSUpdate != null) {
				PSUpdate.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	private static Connection getDBConnection() {
		Connection con = null;

		try {
			Class.forName("new com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error 1 : " + e.getMessage());
		}
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/test?useSSL=false", "root", "root");
		} catch (SQLException e) {
			System.out.println("Error 2 : " + e.getMessage());
		}
		return con;
	}

}
