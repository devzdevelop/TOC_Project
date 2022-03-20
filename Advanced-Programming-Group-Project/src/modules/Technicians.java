package modules;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import factories.DBConnectorFactory;



public class Technicians {
	private static final Logger logger = LogManager.getLogger(Technicians.class);
	private String TID; // Primary Key 
	private String COMID; // Foreign Key
	private String CID; //Foreign Key
	private String firstName; //
	private String lastName;
	
	private Connection myconn;
	
	public Technicians() {
		logger.trace("Entered Technician Class");
		myconn = DBConnectorFactory.getDatabaseConnection();
		this.TID = " "; 
		this.COMID = " "; 
		this.CID = " ";
		this.firstName = " ";
		this.lastName = " ";
	}
	
	
	public Technicians(String tID, String cOMID, String cID, String firstName, String lastName) {
		super();
		logger.trace("Entered Technician Class");
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
		logger.trace("Create method was run");
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
			
			logger.info(prest);
			System.out.println(prest);
			
			prest.executeUpdate();
			logger.info("A record with these information was created:  \n"+ "TID: " + TID + "| COMID: " + COMID + "| CID: " + CID + "| First Name: " + firstName + "| Last Name" + lastName);
			
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
			
			while(rs.next()) {
				String tID = rs.getString("tID");
				String comID = rs.getString("comID");
				String cID = rs.getString("cID");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				System.out.println("Technician ID: " + tID + " | " + "Complaint ID: " + comID + " | " + " Customer's ID: " + cID + " | " + "Technician's First and Last Name: " + firstName + " "  + lastName);
			}
			
			
		}catch (Exception e) {
			System.out.println(e);
			logger.trace("Error: " + e);
		}
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
