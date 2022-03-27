package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modules.CustomerServiceReps;
import modules.Technicians;

public class AddCustomerServiceRepForm extends JInternalFrame{
	private static final long serialVersionUID = 1L;
	
	private JLabel cIDLabel;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel PasswordLabel;
	private JTextField cIDTextField;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField passwordTextField;
	private JButton addBtn;
	private JLabel msgLabel;
	private JLabel csIDLabel;
	private JTextField csIDTextField;
	
	public AddCustomerServiceRepForm () {
		super("Add Customer Service Rep", true, true, true, true);
		
		intializeComponents();
		addComponentsToWindow();
		setWindowsProperties();
	}

	private void intializeComponents() {
		csIDLabel = new JLabel("csID: ");
		cIDLabel = new JLabel("cID: ");
		firstNameLabel = new JLabel("First Name: ");
		lastNameLabel = new JLabel("Last Name: ");
		PasswordLabel = new JLabel("Password: ");
		csIDTextField = new JTextField();
		cIDTextField = new JTextField();
		firstNameTextField = new JTextField();
		passwordTextField = new JTextField();
		addBtn = new JButton("ADD");
		msgLabel = new JLabel("");
	}

	private void addComponentsToWindow() {
		getContentPane().setLayout(null);
		
		//csID Label
		csIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		csIDLabel.setBounds(10, 34, 45, 13);
		getContentPane().add(csIDLabel);
		
		//csIDTextField
		csIDTextField.setColumns(10);
		csIDTextField.setBounds(140, 33, 96, 19);
		getContentPane().add(csIDTextField);
		
		//cIDLabel
		cIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(cIDLabel);
		cIDLabel.setBounds(10, 57, 45, 13);
		
		//cIDTextField
		cIDTextField.setBounds(140, 56, 96, 19);
		getContentPane().add(cIDTextField);
		cIDTextField.setColumns(10);
		
		//First Name Label
		firstNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		firstNameLabel.setBounds(10, 80, 99, 13);
		getContentPane().add(firstNameLabel);
		
		//firstNameTextField
		firstNameTextField.setColumns(10);
		firstNameTextField.setBounds(140, 79, 96, 19);
		getContentPane().add(firstNameTextField);
		
		//LastName Label
		lastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lastNameLabel.setBounds(10, 103, 99, 13);
		getContentPane().add(lastNameLabel);
		
		//lastNameField
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(140, 103, 96, 19);
		getContentPane().add(lastNameTextField);
		
		//Password Label
		PasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PasswordLabel.setBounds(10, 126, 99, 13);
		getContentPane().add(PasswordLabel);
	
		//passwordTextField
		
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(140, 125, 96, 19);
		getContentPane().add(passwordTextField);
		
		//addBtn
		addBtn.setBounds(82, 173, 85, 21);
		getContentPane().add(addBtn);
		
		//msgLabel
		msgLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		msgLabel.setBounds(0, 0, 309, 296);
		getContentPane().add(msgLabel);
		
		
		
		//Action Listener
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String csID = csIDTextField.getText();
				String cID = cIDTextField.getText();
				String firstName = firstNameTextField.getText();
				String lastName = lastNameTextField.getText();
				String password = passwordTextField.getText();
				CustomerServiceReps customerServiceRep = new CustomerServiceReps();
				customerServiceRep.create(csID, cID, firstName, lastName, password);
				
				msgLabel.setText("Success");
				msgLabel.setForeground(Color.GREEN);
			}
		});
		
	}

	private void setWindowsProperties() {
		this.setSize(321, 325);
		this.setVisible(true);
	}
	
	
}
