package view;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import modules.Technicians;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateSelection extends JInternalFrame{
	private static final long serialVersionUID = 1L;
	private JLabel idLabel;
	private JTextField idTextField;
	private JLabel questLabel;
	@SuppressWarnings("rawtypes")
	private JComboBox choiceJCBox;
	private JButton updateBtn;
	private String dbSelected;
	private JLabel updateToLabel;
	private JTextField updateToTextField;
	
	public UpdateSelection() {
		super("Update", true, true, true, true);
		getContentPane().setLayout(null);

		intializeComponents();
		addComponentsToWindow();
		setWindowsProperties();
	}
	
	public UpdateSelection(String dbSelected) {
		super("Update", true, true, true, true);
		getContentPane().setLayout(null);
		this.dbSelected = dbSelected;
		

		intializeComponents();
		addComponentsToWindow();
		setWindowsProperties();
	}

	private void intializeComponents() {
		idLabel = new JLabel("Enter ID: ");
		idTextField = new JTextField();
		questLabel = new JLabel("What do you want to update?");
		choiceJCBox = new JComboBox<String>();
		updateToLabel = new JLabel();
		updateToTextField = new JTextField();
		updateBtn = new JButton("Update");
	}

	
	private void addComponentsToWindow() {
		//idLabel
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idLabel.setBounds(10, 41, 79, 13);
		getContentPane().add(idLabel);
		
		//textField
		idTextField.setBounds(82, 38, 96, 19);
		getContentPane().add(idTextField);
		idTextField.setColumns(10);
		
		//questLabel
		questLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		questLabel.setBounds(10, 64, 239, 13);
		getContentPane().add(questLabel);
		
		//choiceJCBox
		choiceBoxItems();
		choiceJCBox.setBounds(215, 60, 72, 21);
		getContentPane().add(choiceJCBox);
		
		//updateBtn
		updateBtn.setBounds(144, 121, 85, 21);
		getContentPane().add(updateBtn);
		
		//updateToLabel
		updateToLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		updateToLabel.setBounds(10, 98, 219, 13);
		getContentPane().add(updateToLabel);
		updateToLabel.setText("Update " + choiceJCBox.getSelectedItem() + " to: ");
		
		//updateToTextField
		updateToTextField.setBounds(10, 122, 96, 19);
		getContentPane().add(updateToTextField);
		updateToTextField.setColumns(10);
		
		
		//Action Listeners
		//choiceJCBox
		choiceJCBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateToLabel.setText("Update " + choiceJCBox.getSelectedItem() + " to: ");
			}
		});
		
		//updateBtn
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dbSelected == "Customers") {
					
				}else if(dbSelected == "Technicians"){
					Technicians technicians = new Technicians();
					String input = (String) choiceJCBox.getSelectedItem();
					System.out.println(input);
					technicians.update(idTextField.getText(), updateToTextField.getText(), input);
				}
			}
		});
		
	}
	
	@SuppressWarnings("unchecked")
	private void choiceBoxItems() {
		//dbSelected will have different items based on the database that was selected to make updates.
				if(this.dbSelected == "Customers") {
					choiceJCBox.addItem("CID");
					choiceJCBox.addItem("Password");
					choiceJCBox.addItem("DOB");
					choiceJCBox.addItem("FirstName");
					choiceJCBox.addItem("LastName");
					choiceJCBox.addItem("Email");
					choiceJCBox.addItem("ServiceAddress");
					choiceJCBox.addItem("ContactNumber");
					choiceJCBox.addItem("ServiceType");
					choiceJCBox.addItem("Query");
				}else if(this.dbSelected == "Technicians"){
					choiceJCBox.addItem("TID");
					choiceJCBox.addItem("FirstName");
					choiceJCBox.addItem("LastName");
					choiceJCBox.addItem("Password");
				}else if(this.dbSelected == "Customer Service Rep") {
					choiceJCBox.addItem("CSID");
					choiceJCBox.addItem("CID");
					choiceJCBox.addItem("FirstName");
					choiceJCBox.addItem("LastName");
					choiceJCBox.addItem("Password");
				}else if(this.dbSelected == "Complaints") {
					choiceJCBox.addItem("COMID");
					choiceJCBox.addItem("CID");
					choiceJCBox.addItem("CSID");
					choiceJCBox.addItem("TID");
					choiceJCBox.addItem("ComplaintType");
					choiceJCBox.addItem("Issue");
					choiceJCBox.addItem("ResponseDate");
					choiceJCBox.addItem("ServiceType");
					choiceJCBox.addItem("DateOfVisit");
					choiceJCBox.addItem("ComplaintStatus");
				}else if(this.dbSelected == "Accounts") {
					choiceJCBox.addItem("ACC_NUM");
					choiceJCBox.addItem("P_STATUS");
					choiceJCBox.addItem("AMT_DUE");
					choiceJCBox.addItem("P_DDATE");
				}
	}

	private void setWindowsProperties() {
		this.setSize(321, 325);
		this.setVisible(true);
	}
}
