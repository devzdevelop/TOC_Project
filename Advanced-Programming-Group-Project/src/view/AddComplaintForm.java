package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddComplaintForm extends JInternalFrame{
	private static final long serialVersionUID = 1L;
	
	private JLabel comIdLabel;
	private JLabel cIdLabel;
	private JLabel csIdLabel ;
	private JLabel tIdLabel;
	private JLabel compTypLabel;
	private JLabel issueLabel;
	private JLabel RspDateLabel;
	private JLabel srvTypeLabel;
	private JLabel dateOfVisitLabel;
	private JLabel complaintStatusLabel;
	private JTextField comIdTextField;
	private JTextField cIdTextField;
	private JTextField csIdTextField;
	private JTextField tIdTextField;
	private JTextField compTypTextField;
	private JTextField issueTextField;
	private JTextField rspDateTextField;
	private JTextField srvTypeTextField;
	private JTextField dateOfVisitTextField;
	private JTextField complaintStatusTextField;
	private JButton addBtn;
	private JLabel msgLabel;
	
	public AddComplaintForm() {
		super("Add Complaints", true, true, true, true);
		getContentPane().setLayout(null);
		intializedComponents();
		addComponentsToWindow();
		setWindowsProperties();
	}

	private void intializedComponents() {
		comIdLabel = new JLabel("comId: ");
		cIdLabel = new JLabel("CID: ");
		csIdLabel  = new JLabel("CSID: ");
		tIdLabel = new JLabel("TID: ");
		compTypLabel = new JLabel("Complaint Type: ");
		issueLabel = new JLabel("Issue: ");
		RspDateLabel = new JLabel("Response Date: ");
		srvTypeLabel = new JLabel("Service Type: ");
		dateOfVisitLabel = new JLabel("Date Of Visit: ");
		complaintStatusLabel = new JLabel("Complaints Status: ");
		addBtn = new JButton("ADD");
	}

	private void addComponentsToWindow() {
		//comId Label
		comIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(comIdLabel);
		comIdLabel.setBounds(8, 20, 82, 13);
				
				//cID Label
				cIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				cIdLabel.setBounds(8, 43, 99, 13);
				getContentPane().add(cIdLabel);
				
				//cSID Label
				csIdLabel .setFont(new Font("Tahoma", Font.PLAIN, 15));
				csIdLabel .setBounds(8, 66, 99, 13);
				getContentPane().add(csIdLabel );
				
				//tIdLabel
				tIdLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				tIdLabel.setBounds(8, 89, 99, 13);
				getContentPane().add(tIdLabel);
				
				//compTypLabel
				compTypLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				compTypLabel.setBounds(8, 112, 128, 13);
				getContentPane().add(compTypLabel);
				
				//issueLabel
				issueLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				issueLabel.setBounds(8, 135, 99, 13);
				getContentPane().add(issueLabel);
				
				//Service Address Label
				RspDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				RspDateLabel.setBounds(8, 158, 128, 13);
				getContentPane().add(RspDateLabel);
				
				//Contact Number Label
				srvTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				srvTypeLabel.setBounds(8, 181, 128, 13);
				getContentPane().add(srvTypeLabel);
				
				
				//Service Type Label
				dateOfVisitLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				dateOfVisitLabel.setBounds(8, 204, 128, 13);
				getContentPane().add(dateOfVisitLabel);
				
				//Query Label
				complaintStatusLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				complaintStatusLabel.setBounds(8, 227, 148, 13);
				getContentPane().add(complaintStatusLabel);
				
				//comIdTextField
				comIdTextField = new JTextField();
				comIdTextField.setBounds(178, 19, 96, 19);
				getContentPane().add(comIdTextField);
				comIdTextField.setColumns(10);
				
				//cIdTextField
				cIdTextField = new JTextField();
				cIdTextField.setColumns(10);
				cIdTextField.setBounds(178, 42, 96, 19);
				getContentPane().add(cIdTextField);
				
				//lastNameField
				csIdTextField = new JTextField();
				csIdTextField.setColumns(10);
				csIdTextField.setBounds(178, 66, 96, 19);
				getContentPane().add(csIdTextField);
				
				//tIdTextField
				tIdTextField = new JTextField();
				tIdTextField.setColumns(10);
				tIdTextField.setBounds(178, 88, 96, 19);
				getContentPane().add(tIdTextField);
				
				//compTypTextField
				compTypTextField = new JTextField();
				compTypTextField.setColumns(10);
				compTypTextField.setBounds(178, 111, 96, 19);
				getContentPane().add(compTypTextField);
				
				//issueTextField
				issueTextField = new JTextField();
				issueTextField.setColumns(10);
				issueTextField.setBounds(178, 134, 96, 19);
				getContentPane().add(issueTextField);
				
				//rspDateTextField
				rspDateTextField = new JTextField();
				rspDateTextField.setColumns(10);
				rspDateTextField.setBounds(178, 158, 96, 19);
				getContentPane().add(rspDateTextField);
				
				//srvTypeTextField
				srvTypeTextField = new JTextField();
				srvTypeTextField.setColumns(10);
				srvTypeTextField.setBounds(178, 181, 96, 19);
				getContentPane().add(srvTypeTextField);
				
				//dateOfVisitTextField
				dateOfVisitTextField = new JTextField();
				dateOfVisitTextField.setColumns(10);
				dateOfVisitTextField.setBounds(178, 204, 96, 19);
				getContentPane().add(dateOfVisitTextField);
				
				//complaintStatusTextField
				complaintStatusTextField = new JTextField();
				complaintStatusTextField.setColumns(10);
				complaintStatusTextField.setBounds(178, 226, 96, 19);
				getContentPane().add(complaintStatusTextField);
				
				//addBtn
				addBtn.setBounds(80, 250, 85, 21);
				getContentPane().add(addBtn);
				
				//msgLabel
				msgLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
				msgLabel.setBounds(187, 255, 45, 13);
				getContentPane().add(msgLabel);
				
				//Action Listener
				addBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String comId = comIdTextField.getText();
						String cId = cIdTextField.getText();
						String csId = csIdTextField.getText();
						String tId = tIdTextField.getText();
						String compTyp = compTypTextField.getText();
						String issue = issueTextField.getText();
						String rspDate = rspDateTextField.getText();
						String srvType = srvTypeTextField.getText();
						String dateOfVisit = dateOfVisitTextField.getText();
						String complaintStatus = complaintStatusTextField.getText();
					}
				});
	}

	private void setWindowsProperties() {
		this.setSize(321, 325);
		this.setVisible(true);		
	}
}
