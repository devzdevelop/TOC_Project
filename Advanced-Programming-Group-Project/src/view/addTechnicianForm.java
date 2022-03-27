package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modules.Technicians;

import java.awt.Color;

public class addTechnicianForm extends JInternalFrame{
	private static final long serialVersionUID = 1L;
	
	private JLabel tIDLabel;
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel PasswordLabel;
	private JTextField tIDTextField;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField passwordTextField;
	private JButton addBtn;
	private JLabel msgLabel;
	
	public addTechnicianForm() {
		super("Add Technician", true, true, true, true);
		getContentPane().setLayout(null);
		intializeComponent();
		addComponentsToWindow();
		setWindowsProperties();
	}

	
	private void intializeComponent() {
		tIDLabel = new JLabel("tID: ");
		firstNameLabel = new JLabel("First Name: ");
		lastNameLabel = new JLabel("Last Name: ");
		PasswordLabel = new JLabel("Password: ");
		addBtn = new JButton("ADD");
		
		
		msgLabel = new JLabel("");
	}
	
	private void addComponentsToWindow() {
		//CID Label
				tIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				getContentPane().add(tIDLabel);
				tIDLabel.setBounds(8, 20, 45, 13);
				
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
				
				//tIDTextField
				tIDTextField = new JTextField();
				tIDTextField.setBounds(138, 19, 96, 19);
				getContentPane().add(tIDTextField);
				tIDTextField.setColumns(10);
				
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
				
				//addBtn
				addBtn.setBounds(80, 136, 85, 21);
				getContentPane().add(addBtn);
				
				//msgLabel
				msgLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
				msgLabel.setBounds(189, 140, 45, 13);
				getContentPane().add(msgLabel);
				
				//Action Listener
				addBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String tID = tIDTextField.getText();
						String firstName = firstNameTextField.getText();
						String lastName = lastNameTextField.getText();
						String password = passwordTextField.getText();
						Technicians technicians = new Technicians();
						technicians.create(tID, firstName, lastName, password);
						
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
