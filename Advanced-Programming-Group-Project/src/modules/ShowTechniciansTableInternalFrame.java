package modules;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import factories.DBConnectorFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class ShowTechniciansTableInternalFrame  extends JInternalFrame{
	private static final long serialVersionUID = 1L;
	
	
	private Connection myconn = DBConnectorFactory.getDatabaseConnection();
	private JTable table_1;
	private JScrollPane scrollPane;
	
	public ShowTechniciansTableInternalFrame() {
		super("Technician Table", true, true, true, true);
		getContentPane().setLayout(null);
		
		intializeComponents();
		addComponentsToWindow();
		setWindowProperties();
		readAll();
	}


	private void intializeComponents() {
		table_1 = new JTable();
		//table_1.setBounds(0, 0, 600, 600);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 600, 600);
	}


	private void addComponentsToWindow() {
		//Add scrollPane to getContentPane and add table_1 to scrollPane
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(table_1);
	}


	private void setWindowProperties() {
		this.setSize(600, 600);
		this.setVisible(true);
	}
	
	
	public void readAll() {
		String sql = "SELECT * FROM Technicians";
		PreparedStatement prest;
		
		try {
			prest = myconn.prepareStatement(sql);
			System.out.println(prest);
			
			ResultSet rs = prest.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			DefaultTableModel model = (DefaultTableModel) table_1.getModel();
			
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
		}
	}
}
