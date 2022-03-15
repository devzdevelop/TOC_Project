package modules;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import factories.DBConnectorFactory;



public class Accounts 
{
	private Connection conn;
	private int numOfRowsAffected = 0;
	
	public Accounts()
	{
		conn = DBConnectorFactory.getDatabaseConnection();
	}
	
	//* Test all the method and make sure they work with the database correctly (The database was sent in the group).
	//* Find out how you would write the method for P_DDate in the Date class
	//* Any changes you make in one method may require you to make changes to the other methods and in the database.
	
	public void create(int Acc_num, String P_Status, int Amt_Due, Date P_DDate)
	{
		String insertsql= "INSERT INTO Accounts (ACC_NUM, P_STATUS, AMT_DUE, P_DDATE) VALUES(?,?,?,?)";
		
		System.out.println(conn);
		try 
		{
			PreparedStatement stmt;
			stmt = conn.prepareStatement(insertsql);
			stmt.setInt(1, Acc_num); //# the position where the question marks are
			stmt.setString(2, P_Status);
			stmt.setInt(3, Amt_Due);
			stmt.setString(4, P_DDate.toString()); //Look into stmt.setDate and decide if you would use it or stmt.setString. You also, have to make changes to the data type in the database if you use stmt.Date since that field only accept strings.
			
			System.out.println(stmt);
			
			stmt.executeUpdate();
			
		}
		
		catch (SQLException e)
		{
			System.out.println("SQL Exception thrown" + e.getMessage());
		}
		
	}
	
	public void readAll()
	{
		//* Test and ensure that this function is working with the database that was sent in the group.
		String selectSql = "SELECT * FROM Accounts";
		PreparedStatement stmt;
		
		try
		{
			stmt = conn.prepareStatement(selectSql);
			System.out.println(stmt);
			
			ResultSet result = stmt.executeQuery(selectSql);
			while(result.next())
			{
				String Acc_Num = result.getString("ACC_NUM");
				String P_Status = result.getString("P_STATUS");
				int Amt_Due = result.getInt("AMT_DUE");
				String P_DDate = result.getString("P_DDATE"); //* figure out how result.getDate works

				System.out.println("Account Number: "+ Acc_Num + "\tPayment Status:" + P_Status + "\tAmount Due: " + Amt_Due + "\tPayment Due Date" + P_DDate);
			}
		}
		
		catch (SQLException e)
		{
			System.out.println("SQL Exception thrown" + e.getMessage());
		}
	}
	
	public void update (String Acc_Num, String P_Status, int Amt_Due, Date P_DDate)
	{
		//* Test and ensure that this function is working with the database that was sent in the group.
		String updateSql = "UPDATE Accounts SET PaymentStatus = ? + P_Status + ? WHERE AccountNumber = ? ";
		PreparedStatement stmt;
		try
		{
			stmt = conn.prepareStatement(updateSql);
			
			numOfRowsAffected = stmt.executeUpdate(updateSql);
			if (numOfRowsAffected ==1)
			{
				JOptionPane.showMessageDialog(null, "Account Record Updated","Account Record Update",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		catch(SQLException e)
		{
			System.out.println("SQL Exception thrown" + e.getMessage());
		}
		
	}
	public void delete(String Acc_Num)
	{
		//* Test and ensure that this function is working with the database that was sent in the group.
		String deleteSql = "DELETE Accounts = WHERE Account Number ='" + Acc_Num +"'";
		PreparedStatement stmt;
		try
		{
			stmt = conn.prepareStatement(deleteSql);
			
			numOfRowsAffected = stmt.executeUpdate(deleteSql);
			if (numOfRowsAffected ==1)
			{
				JOptionPane.showMessageDialog(null, "Account Record Deleted","Account Record Deletion",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		catch(SQLException e)
		{
			System.out.println("SQL Exception thrown" + e.getMessage());
		}
		
	}


}
