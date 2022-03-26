package modules;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class ShowTechniciansTableInternalFrame extends JInternalFrame {

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ShowTechniciansTableInternalFrame frame = new ShowTechniciansTableInternalFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ShowTechniciansTableInternalFrame() {
		//setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Test");
		//lblNewLabel.setBounds(0, 0, 438, 13);
		getContentPane().add(lblNewLabel);
		this.setVisible(true);

	}

}
