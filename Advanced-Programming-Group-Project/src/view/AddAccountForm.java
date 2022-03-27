package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modules.Technicians;

public class AddAccountForm extends JInternalFrame{
	private static final long serialVersionUID = 1L;
	
	private JLabel accNumLabel;
	private JLabel pmtStatLabel;
	private JLabel amtDueLabel;
	private JLabel pmtDueDateLabel;
	private JTextField accNumTextField;
	private JTextField pmtStatTextField;
	private JTextField amtDueTextField;
	private JTextField pmtDueDateTextField;
	private JButton addBtn;
	private JLabel msgLabel;
	
	public AddAccountForm() {
		super("Add Account", true, true, true, true);
		initializeComponents();
		addComponentsToWindow();
		setWindowsComponents();
	}

	private void initializeComponents() {
		accNumLabel = new JLabel("Account Number: ");
		pmtStatLabel = new JLabel("Payment Status: ");
		amtDueLabel = new JLabel("Amount Due: ");
		pmtDueDateLabel = new JLabel("Payment Due Date: ");
		addBtn = new JButton("ADD");
		
		
		msgLabel = new JLabel("");
	}

	private void addComponentsToWindow() {
		getContentPane().setLayout(null);
		//accNumLabel
		accNumLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(accNumLabel);
		accNumLabel.setBounds(8, 20, 144, 13);
		
		//pmtStatLabel
		pmtStatLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pmtStatLabel.setBounds(8, 43, 132, 13);
		getContentPane().add(pmtStatLabel);
		
		//amtDueLabel
		amtDueLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		amtDueLabel.setBounds(8, 66, 99, 13);
		getContentPane().add(amtDueLabel);
		
		//pmtDueDateLabel
		pmtDueDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pmtDueDateLabel.setBounds(8, 89, 141, 13);
		getContentPane().add(pmtDueDateLabel);
		
		//accNumTextField
		accNumTextField = new JTextField();
		accNumTextField.setBounds(162, 19, 96, 19);
		getContentPane().add(accNumTextField);
		accNumTextField.setColumns(10);
		
		//pmtStatTextField
		pmtStatTextField = new JTextField();
		pmtStatTextField.setColumns(10);
		pmtStatTextField.setBounds(162, 42, 96, 19);
		getContentPane().add(pmtStatTextField);
		
		//amtDueTextField
		amtDueTextField = new JTextField();
		amtDueTextField.setColumns(10);
		amtDueTextField.setBounds(162, 66, 96, 19);
		getContentPane().add(amtDueTextField);
		
		//pmtDueDateTextField
		pmtDueDateTextField = new JTextField();
		pmtDueDateTextField.setColumns(10);
		pmtDueDateTextField.setBounds(162, 88, 96, 19);
		getContentPane().add(pmtDueDateTextField);
		
		//addBtn
		addBtn.setBounds(80, 136, 85, 21);
		getContentPane().add(addBtn);
		
		//msgLabel
		msgLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		msgLabel.setBounds(0, 0, 309, 296);
		getContentPane().add(msgLabel);
		
		//Action Listener
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String accNum = accNumTextField.getText();
				String pmtStat = pmtStatTextField.getText();
				String amtDue = amtDueTextField.getText();
				String pmtDueDate = pmtDueDateTextField.getText();
				Technicians technicians = new Technicians();
				technicians.create(accNum, pmtStat, amtDue, pmtDueDate);
				
				msgLabel.setText("Success");
				msgLabel.setForeground(Color.GREEN);
			}
		});
	}

	private void setWindowsComponents() {
		this.setSize(321, 325);
		this.setVisible(true);	
	}
}
