package modules;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import factories.DBConnectorFactory;

public class Complaints {
	private Connection myconn;
	private String comid;
	private String cid; 
	private String csid; 
	private String tid; 
	private String complaintType; 
	private String issue; 
	private Date response; 
	private String serviceType; 
	private Date dateOfVisit; 
	private String complainStatus;
	
	public Complaints() {
		myconn = DBConnectorFactory.getDatabaseConnection();
	}
	//complaints
	public void create(String comid, String cid, String csid, String tid , String complaintType, String issue, Date responseDate, String serviceType, Date dateOfVisit, String complainStatus ) {
		String sql = "INSERT INTO complaints(COMID, CID, CSID, TID, ComplaintType, Issue, Response, ServiceType, DateOfVisit, ComplaintStatus) VALUES (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement prest;
		System.out.println(myconn);
		try {
			prest = myconn.prepareStatement(sql);
			prest.setString(1, comid); //# the position where the question marks are
			prest.setString(2, cid);
			prest.setString(3, csid);
			prest.setString(4, tid);
			prest.setString(5, complaintType);
			prest.setString(6, issue);
			prest.setString(7, responseDate.toString());
			prest.setString(8, serviceType);
			prest.setString(9, dateOfVisit.toString());
			prest.setString(10,complainStatus);
			
			System.out.println(prest);
			
			prest.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void readAll() {
		String sql = "SELECT * FROM compliants";
		PreparedStatement prest;
		
		try {
			prest = myconn.prepareStatement(sql);
			System.out.println(prest);
			
			ResultSet rs = prest.executeQuery();
			 
			while(rs.next()) {
				String comid = rs.getString("comid");
				String cid = rs.getString("cid");
				String csid = rs.getString("csid");
				String tid = rs.getString("tid");
				String complainType = rs.getString("complainType");
				String issue = rs.getString("issue");
				String response = rs.getString("response");
				String serviceType = rs.getString("serviceType");
				String dateOfVisit = rs.getString("dateOfVisit");
				String complainStatus = rs.getString("complainStatus");
				System.out.println("COMID: " + comid + " | " + "CID: " + cid + "|" + "CSID: " + csid + " | " + "TID: " + tid + "|" + 
				"Complain Type: " + complainType + "|" + "Issue: " + issue + " | " + "Response: " + response + "|"+ "Service Type: " + serviceType 
				+ "|" + "Date Of Visit: " + dateOfVisit + " | " + "Complain Status: " + complainStatus + "|");}
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void update(String comid, String complainStatus) {
		String sql = "UPDATE compliants SET complainStatus = ? WHERE comid = ?";
		PreparedStatement prest;
		
		
		try {
			prest = myconn.prepareStatement(sql);
			prest.setString(1, comid); //# the position where the question marks are
			prest.setString(2, complainStatus);
			System.out.println(prest);
			
			prest.executeUpdate();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void delete(String comid) {
		String sql = "DELETE FROM compliants WHERE comid = ?;";
		PreparedStatement prest;
		
		try {
			prest = myconn.prepareStatement(sql);
			prest.setString(1, comid);
			System.out.println(prest);
			
			int result = prest.executeUpdate();
			System.out.println("Number of records affected :: " + result);// Display the number of complain that have been dealt with
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
