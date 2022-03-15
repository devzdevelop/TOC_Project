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
	
	//* Test all the method and make sure they work with the database correctly (The database was sent in the group).
	//* Find out how you would write the methods responseDate and dateOfVisit from the Date class.
	//* Any changes you make in one method may require you to make changes to the other methods and in the database.
	
	
	
	public Complaints(Connection myconn, String cid, String csid, String tid, String complaintType, String issue,
			Date response, String serviceType, Date dateOfVisit, String complainStatus) {
		super();
		this.myconn = myconn;
		this.cid = cid;
		this.csid = csid;
		this.tid = tid;
		this.complaintType = complaintType;
		this.issue = issue;
		this.response = response;
		this.serviceType = serviceType;
		this.dateOfVisit = dateOfVisit;
		this.complainStatus = complainStatus;
	}



	public String getComid() {
		return comid;
	}



	public void setComid(String comid) {
		this.comid = comid;
	}



	public String getCid() {
		return cid;
	}



	public void setCid(String cid) {
		this.cid = cid;
	}



	public String getCsid() {
		return csid;
	}



	public void setCsid(String csid) {
		this.csid = csid;
	}



	public String getTid() {
		return tid;
	}



	public void setTid(String tid) {
		this.tid = tid;
	}



	public String getComplaintType() {
		return complaintType;
	}



	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}



	public String getIssue() {
		return issue;
	}



	public void setIssue(String issue) {
		this.issue = issue;
	}



	public Date getResponse() {
		return response;
	}



	public void setResponse(Date response) {
		this.response = response;
	}



	public String getServiceType() {
		return serviceType;
	}



	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}



	public Date getDateOfVisit() {
		return dateOfVisit;
	}



	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}



	public String getComplainStatus() {
		return complainStatus;
	}



	public void setComplainStatus(String complainStatus) {
		this.complainStatus = complainStatus;
	}



	public void create(String comid, String cid, String csid, String tid , String complaintType, String issue, Date responseDate, String serviceType, Date dateOfVisit, String complainStatus ) {
		String sql = "INSERT INTO complaints(COMID, CID, CSID, TID, ComplaintType, Issue, Response, ServiceType, DateOfVisit, ComplaintStatus) VALUES (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement prest;
		System.out.println(myconn);
		try {
			prest = myconn.prepareStatement(sql);
			prest.setString(1, comid); 
			prest.setString(2, cid);
			prest.setString(3, csid);
			prest.setString(4, tid);
			prest.setString(5, complaintType);
			prest.setString(6, issue);
			//* Find out if you would send use setString for setDate for responseDate and dateOfVisit
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
		//* check if this function is reading all data correctly from the database. The Database was already sent in the group.
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
		//* Check if this function is working properly with the database. The Database was already sent in the group.
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
		//* Check if this function is working with the database. The Database was already sent in the group.
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
