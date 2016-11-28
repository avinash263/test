import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {
	public void update_me(Connection con) throws SQLException, IOException {

		Scanner sc = new Scanner(System.in);

		System.out
				.println("Select the column number of column which u want to update");
		System.out.println("Column:1 c_code");
		System.out.println("Column:2 c_name");
		System.out.println("Column:3 c_duration");
		System.out.println("Column:4 c_eligibility");
		int option = sc.nextInt();
		sc.nextLine();
		String sql = null;
		if (option == 1) {
			System.out
					.println("Enter the new c_code and c_id[for which you want to change the c_code for]");
			sql = "update course set c_code= ? where c_id = ?";
		} else if (option == 2) {
			System.out
					.println("Enter the new c_name and c_id[for which you want to change the c_code for]");
			sql = "update course set c_name= ? where c_id = ?";
		} else if (option == 3) {
			System.out
					.println("Enter the new c_duration and c_id[for which you want to change the c_code for]");
			sql = "update course set c_duration= ? where c_id = ?";
		} else if (option == 4) {
			System.out
					.println("Enter the new c_eligibility and c_id[for which you want to change the c_code for]");
			sql = "update course set c_eligibility= ? where c_id = ?";
		}
		else
		{
			System.out.println("Enter the correct column number");
			System.out.println("Sorry Enter Your Choice Again");
			String[] args={};
	        MainFn.main(args);
			//System.exit(0);
		}

		String b = sc.nextLine();
		int c = sc.nextInt();

		con.setAutoCommit(false);

		PreparedStatement preparedStatement = con.prepareStatement(sql);

		preparedStatement.setString(1, b);
		preparedStatement.setInt(2, c);

		preparedStatement.addBatch();

		preparedStatement.executeBatch();

		con.commit();
		//sc.close();

	}
}
