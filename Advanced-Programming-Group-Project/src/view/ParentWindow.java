package view;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

@SuppressWarnings("serial")
public class ParentWindow extends JFrame implements WindowListener{
	private JDesktopPane desktop;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenuItem technicianMenuItem;
	private JMenuItem addUserMenuItem;
	private JMenuItem updateUserMenuItem;
	private JMenuItem viewUsersMenuItem;
	private JLabel headingLabel;
	private JButton addUserBtn;
	private JButton updateUserBtn;
	private JButton viewAllBtn;
	private JButton viewUserBtn;
	private JButton deleteUserBtn;
	private JLabel optionLabel;
	

	public ParentWindow() {
		intializeComponents();
		addComponentsToWindow();
		setWindowComponents();
	}

	private void intializeComponents() {
		desktop = new JDesktopPane();
		desktop.setLayout(null);
		desktop.setBackground(Color.ORANGE);
		setTitle("Micro-Star CableVision");
		
		
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		addUserMenuItem = new JMenuItem("Add User");
		updateUserMenuItem = new JMenuItem("Update User");
		viewUsersMenuItem = new JMenuItem("View Users");
		technicianMenuItem = new JMenuItem("Technicians Table");
		headingLabel = new JLabel("ADMIN MENU");
		addUserBtn = new JButton("Add User");
		addUserBtn.setToolTipText("Add users to their respective database table.");
		updateUserBtn = new JButton("Update User");
		updateUserBtn.setToolTipText("Update specific fields for a user in their respective database table.");
		viewAllBtn = new JButton("View All");
		viewAllBtn.setToolTipText("View all from a selected database table.");
		viewUserBtn = new JButton("View User");
		viewUserBtn.setToolTipText("View specific information.");
		deleteUserBtn = new JButton("Delete User");
		deleteUserBtn.setToolTipText("Delete a user completely.");
		optionLabel = new JLabel("Select Your Option:");
	}


	private void addComponentsToWindow() {
		//menuBar
		setJMenuBar(menuBar);
		
		//fileMenu
		fileMenu.setMnemonic('F');
		menuBar.add(fileMenu);
		
		//editMenu
		editMenu.setMnemonic('E');
		menuBar.add(editMenu);
		
		//addUserMenuItem
		fileMenu.add(addUserMenuItem);
		
		//updateUserMenuItem
		fileMenu.add(updateUserMenuItem);
		
		//viewUsersMenuItem
		fileMenu.add(viewUsersMenuItem);
		
		//technicianMenuItem
		editMenu.add(technicianMenuItem);
		
		//lblNewLabel
		headingLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		headingLabel.setBounds(287, 37, 136, 25);
		desktop.add(headingLabel);
		
		//addUserBtn
		addUserBtn.setForeground(Color.WHITE);
		addUserBtn.setBackground(Color.BLACK);
		addUserBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addUserBtn.setBounds(10, 165, 136, 52);
		desktop.add(addUserBtn);
		
		//updateUserBtn
		updateUserBtn.setForeground(Color.WHITE);
		updateUserBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		updateUserBtn.setBackground(Color.BLACK);
		updateUserBtn.setBounds(156, 165, 136, 52);
		desktop.add(updateUserBtn);
		
		//viewAllBtn
		viewAllBtn.setForeground(Color.WHITE);
		viewAllBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		viewAllBtn.setBackground(Color.BLACK);
		viewAllBtn.setBounds(302, 165, 136, 52);
		desktop.add(viewAllBtn);
		
		//viewUserBtn
		viewUserBtn.setForeground(Color.WHITE);
		viewUserBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		viewUserBtn.setBackground(Color.BLACK);
		viewUserBtn.setBounds(10, 227, 136, 52);
		desktop.add(viewUserBtn);
		
		//deleteUserBtn
		deleteUserBtn.setForeground(Color.WHITE);
		deleteUserBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		deleteUserBtn.setBackground(Color.BLACK);
		deleteUserBtn.setBounds(156, 227, 136, 52);
		desktop.add(deleteUserBtn);
		
		//lblAdminMenu
		optionLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		optionLabel.setBounds(129, 130, 163, 25);
		desktop.add(optionLabel);
		
		
		/*Action Listeners*/
		//addUserMenuItem
		addUserMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.add(new DatabaseSelection("Add", desktop));
			}
		});
		
		//updateUserMenuItem
		updateUserMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktop.add(new DatabaseSelection("Update", desktop));
			}
		});
		
		//viewUsersMenuItem
		viewUsersMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktop.add(new DatabaseSelection("ViewAll", desktop));
			}
		});
		
		//technicianMenuItem
		technicianMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktop.add(new DatabaseSelection("Update", desktop));
				//desktop.add(new ShowTechniciansTableInternalFrame());
			}
		});
		
		//addUserBtn
		addUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktop.add(new DatabaseSelection("Add", desktop));
			}
		});
		
		//updateUserBtn
		updateUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktop.add(new DatabaseSelection("Update", desktop));
			}
		});
		
		
		//viewAllBtn
		viewAllBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktop.add(new DatabaseSelection("ViewAll", desktop));
			}
		});
		
		//viewUserBtn
		viewUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		//deleteUserBtn
		deleteUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		getContentPane().add(desktop);
	}


	private void setWindowComponents() {
		
		setBounds(100, 100, 729, 488);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ParentWindow pWindow = new ParentWindow();
	}
}
