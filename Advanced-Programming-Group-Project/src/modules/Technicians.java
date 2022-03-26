package modules;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import factories.DBConnectorFactory;


public class Technicians extends JFrame {
	private static final Logger logger = LogManager.getLogger(Technicians.class);
	private String TID; // Primary Key 
	private String firstName; //
	private String lastName;
	private String password;
	
	private Connection myconn;
	
	private JPanel contentPane;
	private JTable table;
	
	
	public Technicians() {
		logger.trace("Entered Technician Class");
		myconn = DBConnectorFactory.getDatabaseConnection();
		this.TID = " "; 
		this.firstName = " ";
		this.lastName = " ";
		this.password = " ";
	}
	
	
	public Technicians(String tID, String firstName, String lastName, String passowrd) {
		super();
		logger.trace("Entered Technician Class");
		TID = tID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = passowrd;
	}



	public String getTID() {
		return TID;
	}



	public void setTID(String tID) {
		TID = tID;
	}
	
	

	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Connection getMyconn() {
		return myconn;
	}



	public void setMyconn(Connection myconn) {
		this.myconn = myconn;
	}



	public void create(String TID, String firstName, String lastName, String password) {
		logger.trace("Create method was run");
		String sql = "INSERT INTO Technicians (TID , FirstName, LastName, Password) VALUES (? ,? , ?, ?)";
		PreparedStatement prest;
		System.out.println(myconn);
		try {
			prest = myconn.prepareStatement(sql);
			prest.setString(1, TID); //# the position where the question marks are
			prest.setString(2, firstName);
			prest.setString(3, lastName);
			prest.setString(4, password);
			
			logger.info(prest);
			System.out.println(prest);
			
			prest.executeUpdate();
			logger.info("A record with these information was created:  \n"+ "TID: " + TID + "| First Name: " + firstName + "| Last Name" + lastName + "Password: " + password);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error: " + e);
		} 
	}
	
	
	public void readAll() {

		logger.info("readAll method was run");
		String sql = "SELECT * FROM Technicians";
		PreparedStatement prest;
		
		try {
			prest = myconn.prepareStatement(sql);
			logger.info(prest);
			System.out.println(prest);
			
			ResultSet rs = prest.executeQuery();
			logger.info("All records were shown");
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			int cols = rsmd.getColumnCount();
			String[] colName = new String[cols];
			
			for(int i = 0; i < cols; i++) {
				colName[i] = rsmd.getColumnName(i+1);
				model.setColumnIdentifiers(colName);
			}
			while(rs.next()) {
				String tID = rs.getString("TID");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String password = rs.getString("Password");
				System.out.println("Technician ID: " + tID + " | "+ "Technician's First and Last Name: " + firstName + " "  + lastName + " | " + "Password: " + password);
				
				String[] row = {tID, firstName, lastName, password};	
				model.addRow(row);
			}
		
		}catch (Exception e) {
			System.out.println(e);
			logger.trace("Error: " + e);
		}
	}
	
	public void jFrameProperties() {
		setTitle("Technician Table");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 946, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(219, 95, 487, 341);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	
	public void update(String tID, String input, String select) {
		logger.trace("update method was run");
		if(select.equals("FirstName")) { // First Name
			logger.info("FirstName was changed to: " + input);
			
			String sql = "UPDATE Technicians SET FirstName = ? WHERE TID = ?";
			PreparedStatement prest;
			
			try {
				prest = myconn.prepareStatement(sql);
				prest.setString(1, input);
				prest.setString(2, tID);
				
				System.out.println(prest);
				logger.info(prest);
				
				prest.executeUpdate();
				
			}catch (Exception e) {
				System.out.println(e);
				logger.error("Error: " + e);
			}
		} else 	if(select.equals("LastName")) { //Last Name
			logger.info("LastName was changed to: " + input);
			
			String sql = "UPDATE Technicians SET LastName = ? WHERE TID = ?";
			
			PreparedStatement prest;
			
			try {
				prest = myconn.prepareStatement(sql);
				prest.setString(1, input);
				prest.setString(2, tID);
				
				System.out.println(prest);
				logger.info(prest);
				
				prest.executeUpdate();
				
				}catch (Exception e) {
					System.out.println(e);
					logger.error("Error: " + e);
				}
			}  else if(select.equals("TID")) { //TID
				logger.info("TID was changed to: " + input);
				
				String sql = "UPDATE Technicians SET TID = ? WHERE TID = ?";
				PreparedStatement prest;
			
			try {
				prest = myconn.prepareStatement(sql);
				prest.setString(1, input);
				prest.setString(2, tID);
				
				System.out.println(prest);
				logger.info(prest);
				
				prest.executeUpdate();
				}catch (Exception e) {
					System.out.println(e);
					logger.error(e);
				}
			} else if(select.equals("CID")) { //CID
				logger.info("CID was changed to: " + input);
				
				String sql = "UPDATE Technicians SET CID = ? WHERE TID = ?";
				PreparedStatement prest;
			
			try {
				prest = myconn.prepareStatement(sql);
				prest.setString(1, input);
				prest.setString(2, tID);
				
				System.out.println(prest);
				logger.info(prest);
				
				prest.executeUpdate();
				}catch (Exception e) {
					System.out.println(e);
					logger.error(e);
				}
			} else if(select.equals("CID")) { //COMID
				logger.info("COMID was changed to: " + input);
				
				String sql = "UPDATE Technicians SET COMID = ? WHERE TID = ?";
				PreparedStatement prest;
			
			try {
				prest = myconn.prepareStatement(sql);
				prest.setString(1, input);
				prest.setString(2, tID);
				
				System.out.println(prest);
				logger.info(prest);
				
				prest.executeUpdate();
				}catch (Exception e) {
					System.out.println(e);
					logger.error(e);
				}
			}
	}
	
	public void delete(String id) {
		logger.trace("delete method was run");
		
		String sql = "DELETE FROM Technicians WHERE TID = ?;";
		PreparedStatement prest;
		
		try {
			prest = myconn.prepareStatement(sql);
			prest.setString(1, id);
			
			System.out.println(prest);
			logger.info(prest);
			
			int result = prest.executeUpdate();
			System.out.println("Number of records affected :: " + result);
			
			logger.info("Record with TID#" + id + " was deleted");
		}catch (Exception e){
			e.printStackTrace();
			logger.error("Error: " + e);
		}
	}

}
