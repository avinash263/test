
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class MainFn {
	public static void main(String[] args) throws SQLException, IOException {

		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/raushan?useSSL=false", "raushan",
				"rosh");

		int ch;
		do {

			System.out.println("\n" + "Select one among following options"
					+ "\n");
			System.out
					.println("1.Display all data from the *Course Table*"
							+ "\n"
							+ "2.Add data in the *Course Table*"
							+ "\n"
							+ "3.Update the data in the *Course Table* based on column name"
							+ "\n"
							+ "4.Delete the data from *Course Table* based on column name "
							+ "\n" + "5.Exit");

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice" + "\n");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				System.out.println("Displaying data from COURSE TABLE" + "\n");
				Display dt = new Display();
				dt.makeConnection(con);

				break;

			case 2:
				System.out.println("Inserting rows in COURSE TABLE");
				Insert in = new Insert();
				in.insert_me(con);
				break;

			case 3:
				System.out.println("Updating rows");
				Update up = new Update();
				up.update_me(con);
				break;

			case 4:
				System.out.println("Deleting Rows");
				Delete dl = new Delete();
				dl.delete_me(con);
				break;

			case 5:
				System.exit(0);

			default:
				System.out.println("Please select one option");

			}
		} while (ch != 5);

	}
}
