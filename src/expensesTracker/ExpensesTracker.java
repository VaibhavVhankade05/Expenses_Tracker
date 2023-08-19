package expensesTracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ExpensesTracker 
{
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception
	{
		ExpensesTracker et = new ExpensesTracker();
		
		et.User();
		et.Authentication();
	}
	
	
	
//	INSERTING USERNAME AND PASSWORD
	void User() throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ExpensesTracker" , "root" , "Vaibhav@27");
		Statement stmt = con.createStatement();
		
		try
		{
			System.out.println("Enter Your Username: ");
			String username = sc.next();
			System.out.println("Enter Your Password: ");
			String password = sc.next();
			
			stmt.execute("INSERT INTO User(Username,Password) VALUES(' "+username+" ',' "+password+" ')");
			System.out.println(" ");
			System.out.println("***Successfully Insert User Details***");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
	
//	USER AUTHETICATION
	void Authentication() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://locakhost:3306/ExpensesTracker" , "root" , "Vaibhav@27");
		Statement stmt = con.createStatement();
		
		try
		{
			System.out.println("***** WELCOME *****");
			System.out.println("Enter your Username:");
			String un = sc.next();
			System.out.println("Enter Your Password:");
			String p = sc.next();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM User");
			while(rs.next())
			{
				System.out.println("*** Valid Username & Password ***");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
