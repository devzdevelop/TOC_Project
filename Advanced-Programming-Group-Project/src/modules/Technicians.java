package modules;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import factories.DBConnectorFactory;


public class Technicians {
	private String TID; // Primary Key 
	private String COMID; // Foreign Key
	private String CID; //Foreign Key
	private String firstName; //
	private String lastName;
	
	private Connection myconn;
	
	public Technicians() {
		myconn = DBConnectorFactory.getDatabaseConnection();
		this.TID = " "; 
		this.COMID = " "; 
		this.CID = " ";
		this.firstName = " ";
		this.lastName = " ";
	}
	
	
	
	public Technicians(String tID, String cOMID, String cID, String firstName, String lastName) {
		super();
		TID = tID;
		COMID = cOMID;
		CID = cID;
		this.firstName = firstName;
		this.lastName = lastName;
	}



	public String getTID() {
		return TID;
	}



	public void setTID(String tID) {
		TID = tID;
	}



	public String getCOMID() {
		return COMID;
	}



	public void setCOMID(String cOMID) {
		COMID = cOMID;
	}



	public String getCID() {
		return CID;
	}



	public void setCID(String cID) {
		CID = cID;
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



	public Connection getMyconn() {
		return myconn;
	}



	public void setMyconn(Connection myconn) {
		this.myconn = myconn;
	}



	public void create(String TID, String COMID, String CID, String firstName, String lastName) {
		String sql = "INSERT INTO Technicians (TID, COMID, CID, FirstName, LastName) VALUES (?, ?, ? ,?, ?)";
		PreparedStatement prest;
		System.out.println(myconn);
		try {
			prest = myconn.prepareStatement(sql);
			prest.setString(1, TID); //# the position where the question marks are
			prest.setString(2, COMID);
			prest.setString(3, CID);
			prest.setString(4, firstName);
			prest.setString(5, lastName);
			
			System.out.println(prest);
			
			prest.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void readAll() {
		String sql = "SELECT * FROM Technicians";
		PreparedStatement prest;
		
		try {
			prest = myconn.prepareStatement(sql);
			System.out.println(prest);
			
			ResultSet rs = prest.executeQuery();
			 
			while(rs.next()) {
//				String id = rs.getString("tID");
//				String name = rs.getString("comID");
//				String name = rs.getString("cID");
//				String name = rs.getString("firstName");
//				String name = rs.getString("lastName");
//				System.out.println("Technician ID: " + tId + " | " + "Complaint ID: " + comID + " | " + " Customer's ID: " + cID + " | " + "Technician's First and Last Name" + firstName + " "  + lastName);
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void update(String id, String name) {
		String sql = "UPDATE Technicians SET firstName = ? WHERE TID = ?";
		PreparedStatement prest;
		
		
		try {
			prest = myconn.prepareStatement(sql);
//			prest.setString(1, firstName);
//			prest.setString(2, tId);
			System.out.println(prest);
			
			prest.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void delete(String id) {
		String sql = "DELETE FROM Technicians WHERE TID = ?;";
		PreparedStatement prest;
		
		try {
			prest = myconn.prepareStatement(sql);
			prest.setString(1, id);
			System.out.println(prest);
			
			int result = prest.executeUpdate();
			System.out.println("Number of records affected :: " + result);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
