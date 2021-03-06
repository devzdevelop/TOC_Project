package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import domain.SpaceVehicle;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpaceVehicleStatusMenu extends JFrame {
	private JLabel lblSpaceVehicleStatus;
	private JLabel lblCurrentState;
	private JLabel lblCurrentInput;
	private JLabel lblCounterL;
	private JLabel lblCounterT;
	private JLabel lblCounterD;
	private JLabel lblCurrentStateResults;
	private JLabel lblCurrentInputResults;
	private JLabel lblCounterLResults;
	private JLabel lblCounterTResults;
	private JLabel lblCounterDResults;
	private SpaceVehicle spaceVehicle;
	private String input;
	private ArrayList<String> currentState;
	public ArrayList<String> inputList = new ArrayList<String>();
	
	
	//Timers
    Timer timer;
    Timer timer1;
    Timer timer2;
    
    boolean pauseCheck = false;
    
	public SpaceVehicleStatusMenu(SpaceVehicle spaceVehicle, ArrayList<String> currentState, ArrayList<String> inputList) {
		getContentPane().setLayout(null);
		//this.spaceVehicle = spaceVehicle;
		this.currentState = currentState;
		this.inputList = inputList;
		intializeComponents(spaceVehicle);
		addComponentsToWindow();
		setWindowProperties();
		realTimeStatus();
		
		L_counter();
        T_counter();
       
        timer1.start();
        timer.start();

	}

	private void intializeComponents(SpaceVehicle spaceVehicle) {
		lblSpaceVehicleStatus = new JLabel("Space Vehicle Status");
//		lblCurrentState = new JLabel("Current State: ");
//		lblCurrentInput = new JLabel("Current Input: ");
		lblCurrentState = new JLabel("Current State: ");
		lblCurrentInput = new JLabel("Current Input: ");
		lblCounterL = new JLabel("Counter L: ");
		lblCounterT = new JLabel("Counter T: ");
		lblCounterD = new JLabel("Counter D: 30");
		lblCurrentStateResults = new JLabel("");
		lblCurrentInputResults = new JLabel("");
		lblCounterLResults = new JLabel("");
		lblCounterTResults = new JLabel("");
		lblCounterDResults = new JLabel("");
	}

	private void addComponentsToWindow() {
		//lblSpaceVehicleStatus
		lblSpaceVehicleStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSpaceVehicleStatus.setBounds(371, 53, 228, 37);
		getContentPane().add(lblSpaceVehicleStatus);
		
		//lblCurrentState
		lblCurrentState.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCurrentState.setBounds(195, 132, 409, 37);
		getContentPane().add(lblCurrentState);
		
		//lblCurrentInput
		lblCurrentInput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCurrentInput.setBounds(195, 179, 341, 37);
		getContentPane().add(lblCurrentInput);
		
		//lblCounterL
		lblCounterL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCounterL.setBounds(195, 226, 122, 37);
		getContentPane().add(lblCounterL);
		
		//lblCounterT
		lblCounterT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCounterT.setBounds(195, 273, 122, 37);
		getContentPane().add(lblCounterT);
		
		//lblCounterD
		lblCounterD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCounterD.setBounds(195, 320, 122, 37);
		getContentPane().add(lblCounterD);
		
		//lblCurrentStateResults
		lblCurrentStateResults.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCurrentStateResults.setBounds(314, 132, 122, 37);
		getContentPane().add(lblCurrentStateResults);
		
		//lblCurrentInputResults
		lblCurrentInputResults.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCurrentInputResults.setBounds(314, 179, 122, 37);
		getContentPane().add(lblCurrentInputResults);
		
		//lblCounterLResults
		lblCounterLResults.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCounterLResults.setBounds(314, 226, 122, 37);
		getContentPane().add(lblCounterLResults);
		
		//lblCounterTResults
		lblCounterTResults.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCounterTResults.setBounds(314, 273, 122, 37);
		getContentPane().add(lblCounterTResults);
		
		//lblCounterDResults
		lblCounterDResults.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCounterDResults.setBounds(314, 320, 122, 37);
		getContentPane().add(lblCounterDResults);
		
	}

	private void setWindowProperties() {
		setTitle("Space Vehicle Status Menu");
		setBounds(100, 100, 889, 715);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void realTimeStatus() {
		
			Thread t1 = new Thread(new Runnable() { 
				@Override 
				public void run() { 
					for(String currentState: currentState) {
						try {
							lblCurrentState.setText("Current State: " + currentState);
							Thread.sleep(2000);
						System.out.println(currentState);		
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						if(currentState.equals("Delay")) {
							 D_counter();
						     timer2.start();
						     pauseCheck =true;
						     try {
						    	
								Thread.sleep(30000);
								pauseCheck = false;
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					
					String last = currentState.get(currentState.size() - 1);
					if(last == "Splashdown") {
						JOptionPane.showMessageDialog(null, "This string is Accepted");
					}else {
						JOptionPane.showMessageDialog(null, "This string is Rejected");
					}
					
				}
			});
			t1.start();
			
		
			Thread t2 = new Thread(new Runnable() { 
				@Override 
				public void run() {
					for(String inputList: inputList) {
						try {
							if (pauseCheck ==true){
								Thread.sleep(30000);
							}
							lblCurrentInput.setText("Current Input: " + inputList);
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
				}
			});
			t2.start();
	}
	
	public void L_counter() {
        // Timer timer;
		 timer = new Timer(1000, new ActionListener() {
             int L_minutes = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				L_minutes++;

                lblCounterL.setText("Counter L : "+ L_minutes);
				
			}

         });
     }

     public void T_counter() {
         // Timer timer;
         timer1 = new Timer(1000, new ActionListener() {
             int T_minutes = 50;

             @Override
             public void actionPerformed(ActionEvent e) {
                 T_minutes--;
                                 

                 lblCounterT.setText("Counter T : "+ T_minutes);
             }

         });
     }
     public void D_counter() {
         // Timer timer;
         timer2 = new Timer(1000, new ActionListener() {
             int D_minutes = 30;

             @Override
             public void actionPerformed(ActionEvent e) {
                 D_minutes--;
     
                 lblCounterD.setText("Counter D : "+ D_minutes);
                 
                 if(D_minutes == 0) {
                	 timer2.stop();
                 }
             }

         });
     }
	
	public static void main(String [] args) {
	}
}
