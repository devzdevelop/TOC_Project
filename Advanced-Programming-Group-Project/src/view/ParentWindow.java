package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import modules.ShowTechniciansTableInternalFrame;

@SuppressWarnings("serial")
public class ParentWindow extends JFrame implements WindowListener{
	private JDesktopPane desktop;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParentWindow frame = new ParentWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ParentWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 488);
		desktop = new JDesktopPane();
		 
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		menuBar.add(fileMenu);
		
		
		JMenuItem addUserMenuItem = new JMenuItem("Add User");
		fileMenu.add(addUserMenuItem);
		
		JMenuItem updateUserMenuItem = new JMenuItem("Update User");
		fileMenu.add(updateUserMenuItem);
		
		JMenuItem viewUsersMenuItem = new JMenuItem("View Users");
		fileMenu.add(viewUsersMenuItem);
		
		
		
		JMenu editMenu = new JMenu("Edit");
		editMenu.setMnemonic('E');
		menuBar.add(editMenu);
		
		//Action Listeners
		addUserMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desktop.add(new DatabaseSelection("Add", desktop));
			}
		});
		
		updateUserMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktop.add(new DatabaseSelection("Update", desktop));
			}
		});
		
		viewUsersMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktop.add(new DatabaseSelection("ViewAll", desktop));
			}
		});
		
		JMenuItem technicianMenuItem = new JMenuItem("Technicians Table");
		technicianMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktop.add(new DatabaseSelection("Update", desktop));
				//desktop.add(new ShowTechniciansTableInternalFrame());
			}
		});
		
		editMenu.add(technicianMenuItem);
		
		getContentPane().add(desktop);
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
}
