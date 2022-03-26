import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ShowTechniciansTable extends JFrame{
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ShowTechniciansTable frame = new ShowTechniciansTable();
					frame.setVisible(true);
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

}
