package dbtesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.testng.annotations.Test;

/*
 * These are the simple steps which we will follow in our program

Step 1- First Load the driver

Step 2-Then Create a connection

Step 3- Then Create a statement

Step 4-  Then Execute your SQL query

Step 5-  And Store the data in Result set

Step 6- Finally verify whether data (table) is updated or not

Let’s implement the same using Java and DB as MS Access

Precondition- Set the DSN (Data Source Name)
Step to setup DSN-

1- Open Control Panel > Then go to Administrative tool > Then Click on ODBC

2- Go to User DSN tab and Click Add button

3- Now Select the respective database which you want to connect in this case I have selected MS Access

4- Specify the name of DSN and Click on Save button
 * */

public class DatabaseTesting {

	@Test
	public void testingDB() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Loaded");

		/*
		 * // This will connect with Database , getConnection taking three argument //
		 * first argument Test_Oracle is the dsn which you can change as per your //
		 * system, // second argument is username and third argument is password
		 * 
		 * Connection con = DriverManager.getConnection("jdbc:odbc:Test_Oracle",
		 * "system", "selenium");
		 */

		// This will connect with Database , getConnection taking three argument
		Connection con = DriverManager.getConnection("jdbc.mysql://localhost:3306/selenium", "root", "Selenium");
		System.out.println("Connection created");

		// This will create statement
		Statement smt = con.createStatement();

		System.out.println("Statement created");

		// Now execute the query, here facebook is the table which I have created in DB

		ResultSet rs = smt.executeQuery("Select * from Facebook");

		System.out.println("Query Executed");

		// Iterate the resultset now

		while (rs.next()) {

			String uname = rs.getString("username");
			String pass = rs.getString("password");
			String email = rs.getString("email");

			System.out.println("Uname is " + uname + " password is " + pass + " email id is " + email);

		}
	}

}
