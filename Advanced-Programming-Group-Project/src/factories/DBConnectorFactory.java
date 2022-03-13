/*
 * Name: Devin Brown
 * ID#: 1804363
 */
package factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class DBConnectorFactory {
	private static Connection myConn = null;
	
	public static Connection getDatabaseConnection(){
		String url = "jdbc:mysql://localhost:3306/mscv";
		try {
			
			
			if(myConn != null) {
				return myConn;
			}else if(myConn == null){
				myConn = DriverManager.getConnection(url, "root", "");
				JOptionPane.showMessageDialog(null, "Connected To Local", "JDBC Connection Satus", JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return myConn;
	}
	
	public static void main(String[] arg) {
		DBConnectorFactory con = new DBConnectorFactory();
		con.myConn = con.getDatabaseConnection();
	}
}
