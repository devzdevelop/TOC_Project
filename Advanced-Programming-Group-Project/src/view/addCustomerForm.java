package view;

import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addCustomerForm extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	
	private JLabel cIDLabel;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel PasswordLabel;
	private JLabel dobLabel;
	private JLabel EmailLabel;
	private JLabel serviceAddressLabel;
	private JLabel ContactNumberLabel;
	private JLabel ServiceTypeLabel;
	private JLabel QueryLabel;
	private JTextField cidTextField;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField passwordTextField;
	private JTextField dobTextField;
	private JTextField emailTextField;
	private JTextField serviceAddressTextField;
	private JTextField contactNumberTextField;
	private JTextField serviceTypeTextField;
	private JTextField queryTextField;
	private JButton addBtn;
	private JLabel msgLabel;
	
	
	public addCustomerForm() {
		super("Add Customer", true, true, true, true);
		getContentPane().setLayout(null);
		intializeComponent();
		addComponentsToWindow();
		setWindowsProperties();
	}
	
	public void intializeComponent(){
		cIDLabel = new JLabel("CID: ");
		firstNameLabel = new JLabel("First Name: ");
		lastNameLabel = new JLabel("Last Name: ");
		PasswordLabel = new JLabel("Password: ");
		dobLabel = new JLabel("DOB: ");
		EmailLabel = new JLabel("Email: ");
		serviceAddressLabel = new JLabel("Service Address: ");
		ContactNumberLabel = new JLabel("Contact Number: ");
		ServiceTypeLabel = new JLabel("Service type: ");
		QueryLabel = new JLabel("Query: ");
		addBtn = new JButton("ADD");
		
		
		msgLabel = new JLabel("");
	}
	
	public void addComponentsToWindow() {
		//CID Label
		cIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(cIDLabel);
		cIDLabel.setBounds(8, 20, 45, 13);
		
		//First Name Label
		firstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		firstNameLabel.setBounds(8, 43, 99, 13);
		getContentPane().add(firstNameLabel);
		
		//LastName Label
		lastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lastNameLabel.setBounds(8, 66, 99, 13);
		getContentPane().add(lastNameLabel);
		
		//Password Label
		PasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PasswordLabel.setBounds(8, 89, 99, 13);
		getContentPane().add(PasswordLabel);
		
		//DOB Label
		dobLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dobLabel.setBounds(8, 112, 99, 13);
		getContentPane().add(dobLabel);
		
		//Email Label
		EmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EmailLabel.setBounds(8, 135, 99, 13);
		getContentPane().add(EmailLabel);
		
		//Service Address Label
		serviceAddressLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		serviceAddressLabel.setBounds(8, 158, 128, 13);
		getContentPane().add(serviceAddressLabel);
		
		//Contact Number Label
		ContactNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ContactNumberLabel.setBounds(8, 181, 128, 13);
		getContentPane().add(ContactNumberLabel);
		
		
		//Service Type Label
		ServiceTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ServiceTypeLabel.setBounds(8, 204, 128, 13);
		getContentPane().add(ServiceTypeLabel);
		
		//Query Label
		QueryLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		QueryLabel.setBounds(8, 227, 128, 13);
		getContentPane().add(QueryLabel);
		
		//cidTextField
		cidTextField = new JTextField();
		cidTextField.setBounds(138, 19, 96, 19);
		getContentPane().add(cidTextField);
		cidTextField.setColumns(10);
		
		//firstNameTextField
		firstNameTextField = new JTextField();
		firstNameTextField.setColumns(10);
		firstNameTextField.setBounds(138, 42, 96, 19);
		getContentPane().add(firstNameTextField);
		
		//lastNameField
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(138, 66, 96, 19);
		getContentPane().add(lastNameTextField);
		
		//passwordTextField
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(138, 88, 96, 19);
		getContentPane().add(passwordTextField);
		
		//dobTextField
		dobTextField = new JTextField();
		dobTextField.setColumns(10);
		dobTextField.setBounds(138, 111, 96, 19);
		getContentPane().add(dobTextField);
		
		//emailTextField
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(138, 134, 96, 19);
		getContentPane().add(emailTextField);
		
		//serviceAddressTextField
		serviceAddressTextField = new JTextField();
		serviceAddressTextField.setColumns(10);
		serviceAddressTextField.setBounds(138, 158, 96, 19);
		getContentPane().add(serviceAddressTextField);
		
		//contactNumberTextField
		contactNumberTextField = new JTextField();
		contactNumberTextField.setColumns(10);
		contactNumberTextField.setBounds(138, 181, 96, 19);
		getContentPane().add(contactNumberTextField);
		
		//serviceTypeTextField
		serviceTypeTextField = new JTextField();
		serviceTypeTextField.setColumns(10);
		serviceTypeTextField.setBounds(138, 204, 96, 19);
		getContentPane().add(serviceTypeTextField);
		
		//queryTextField
		queryTextField = new JTextField();
		queryTextField.setColumns(10);
		queryTextField.setBounds(138, 226, 96, 19);
		getContentPane().add(queryTextField);
		
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
				String cid = cidTextField.getText();
				String firstName = firstNameTextField.getText();
				String lastName = lastNameTextField.getText();
				String password = passwordTextField.getText();
				String dob = dobTextField.getText();
				String email = emailTextField.getText();
				String serviceAddress = serviceAddressTextField.getText();
				String contactNumber = contactNumberTextField.getText();
				String serviceType = serviceTypeTextField.getText();
				String query = queryTextField.getText();
			}
		});
		
	}
	
	public void setWindowsProperties() {
		this.setSize(321, 325);
		this.setVisible(true);
	}
}
