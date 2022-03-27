package modules;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import factories.DBConnectorFactory;

public class CustomerServiceReps {
	private  String CSID;
	private  String CID;
	private  String Firstname;
	private  String lastName;
	private String password;
	private Connection myconn;
	
	
	public CustomerServiceReps() {
		myconn = DBConnectorFactory.getDatabaseConnection();
		this.CSID = "";
		this.CID = "";
		this.Firstname = "";
		this.lastName = "";
		this.password = "";
	}

	public CustomerServiceReps(String cSID, String cID, String firstname, String lastName, String password) {
		super();
		CSID = cSID;
		CID = cID;
		Firstname = firstname;
		this.lastName = lastName;
		this.password = password;
		this.myconn = myconn;
	}
	

	public String getCSID() {
		return CSID;
	}

	public void setCSID(String cSID) {
		CSID = cSID;
	}

	public String getCID() {
		return CID;
	}

	public void setCID(String cID) {
		CID = cID;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
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
	
	public void create(String CSID, String CID, String firstName, String lastName, String password) {
		String sql = "INSERT INTO customer_service_rep (CSID, CID, FirstName, LastName, Password) VALUES (?, ? ,?, ?, ?)";
		PreparedStatement prest;
		System.out.println(myconn);
		try {
			prest = myconn.prepareStatement(sql);
			prest.setString(1, CSID); //# the position where the question marks are
			prest.setString(2, CID);
			prest.setString(3, firstName);
			prest.setString(4, lastName);
			prest.setString(5, password);
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
