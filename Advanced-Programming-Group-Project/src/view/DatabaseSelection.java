package view;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import modules.ShowTechniciansTableInternalFrame;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;



public class DatabaseSelection extends JInternalFrame  {
	private static final long serialVersionUID = 3341408380687476706L;
	public String function;
	private JLabel selectDBLabel;
	@SuppressWarnings("rawtypes")
	private JComboBox dbOptionsCBox;
	private JButton goBtn;
	private JLayeredPane desktop; 
	
	public DatabaseSelection() {
		super("Database Selection", true, true, true, true);
		getContentPane().setLayout(null);
		initializeComponents();
		addComponentsToWindow();
		setWindowsProperties();
	}
	
	public DatabaseSelection(String function, JLayeredPane desktop) {
		super("Database Selection", true, true, true, true);
		getContentPane().setLayout(null);
		initializeComponents();
		addComponentsToWindow();
		setWindowsProperties();
		this.function = function;
		this.desktop =  desktop;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initializeComponents() {
		selectDBLabel = new JLabel("Select Database: ");
		String [] itemsArray = {"Customers", "Technicians", "Customer Service Rep", "Complaints", "Accounts"};
		dbOptionsCBox = new JComboBox(itemsArray);
		goBtn = new JButton("Go");
	}
	
	public void addComponentsToWindow() {
		//selectDBLabel
		selectDBLabel.setBounds(10, 114, 99, 13);
		getContentPane().add(selectDBLabel);
		
		//dbOptionsCBox 
		dbOptionsCBox.setBounds(100, 110, 104, 21);
		getContentPane().add(dbOptionsCBox);
		
		//goBtn
		goBtn.setBounds(214, 110, 85, 21);
		getContentPane().add(goBtn);
		
		//action listener
		goBtn.setToolTipText("submit the selected database.");
		goBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(dbOptionsCBox.getSelectedItem() == "Customers") { //Customers Selected
					System.out.println("Customers");
					if(function == "Add") {
						System.out.println("Add");
							try {
								setClosed(true);
							} catch (PropertyVetoException e1) {
								e1.printStackTrace();
							}
							desktop.add(new AddCustomerForm());				
					}
					else if(function == "Update") {
						System.out.println("Update");
						try {
							setClosed(true);
						} catch (PropertyVetoException e1) {
							e1.printStackTrace();
						}
						desktop.add(new UpdateSelection("Customers"));
					}
				}else if(dbOptionsCBox.getSelectedItem() == "Technicians") {//Technicians Selected
					System.out.println("Technicians");
					if(function == "Add") {
						System.out.println("Add");
							try {
								setClosed(true);
							} catch (PropertyVetoException e1) {
								e1.printStackTrace();
							}
							desktop.add(new AddTechnicianForm());				
					}
					else if(function == "Update") {
						System.out.println("Update");
						try {
							setClosed(true);
						} catch (PropertyVetoException e1) {
							e1.printStackTrace();
						}
						desktop.add(new UpdateSelection("Technicians"));
					}else if(function == "ViewAll") {
						try {
							setClosed(true);
						} catch (PropertyVetoException e1) {
							e1.printStackTrace();
						}
						System.out.println("ViewAll");
						desktop.add(new ShowTechniciansTableInternalFrame());
					}
				}else if(dbOptionsCBox.getSelectedItem() == "Customer Service Rep") {//Customer Service Rep Selected
					System.out.println("Customer Service Rep");
					if(function == "Add") {
						System.out.println("Add");
							try {
								setClosed(true);
							} catch (PropertyVetoException e1) {
								e1.printStackTrace();
							}
							desktop.add(new AddCustomerServiceRepForm());				
					}
					else if(function == "Update") {
						System.out.println("Update");
						try {
							setClosed(true);
						} catch (PropertyVetoException e1) {
							e1.printStackTrace();
						}
						desktop.add(new UpdateSelection("Customer Service Rep"));
					}
				}else if(dbOptionsCBox.getSelectedItem() == "Complaints") {//Complaints Selected
					System.out.println("Complaints");
					if(function == "Add") {
						System.out.println("Add");
							try {
								setClosed(true);
							} catch (PropertyVetoException e1) {
								e1.printStackTrace();
							}
							desktop.add(new AddComplaintForm());				
					}
					else if(function == "Update") {
						System.out.println("Update");
						try {
							setClosed(true);
						} catch (PropertyVetoException e1) {
							e1.printStackTrace();
						}
						desktop.add(new UpdateSelection("Complaints"));
					}
				}else if(dbOptionsCBox.getSelectedItem() == "Accounts") {//Accounts Selected
					System.out.println("Accounts");
					if(function == "Add") {//Add
						System.out.println("Add");
							try {
								setClosed(true);
							} catch (PropertyVetoException e1) {
								e1.printStackTrace();
							}
							desktop.add(new AddAccountForm());				
					}
					else if(function == "Update") {//Update
						System.out.println("Update");
						try {
							setClosed(true);
						} catch (PropertyVetoException e1) {
							e1.printStackTrace();
						}
						desktop.add(new UpdateSelection("Accounts"));
					}
				}
			}
		});
	}
	
	public void setWindowsProperties() {
		this.setSize(321, 325);
		this.setVisible(true);
	}
}
