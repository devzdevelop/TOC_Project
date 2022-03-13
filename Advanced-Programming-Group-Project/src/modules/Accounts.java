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
			stmt.setString(4, P_DDate.toString()); //stmt.setDate
			
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
		String selectSql = "SELECT * FROM Accounts";
		PreparedStatement stmt;
		
		try
		{
			stmt = conn.prepareStatement(selectSql);
			System.out.println(stmt);
			
			ResultSet result = stmt.executeQuery(selectSql);
			while(result.next())
			{
				String Acc_Num = result.getString("AccountNumber");
				String P_Status = result.getString("PaymentsStatus");
				int Amt_Due = result.getInt("AmountDue");
				String P_DDate = result.getString("PaymentDueDate"); //figure out how result.getDate works

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
