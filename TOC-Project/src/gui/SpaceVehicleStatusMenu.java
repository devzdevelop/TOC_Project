package gui;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.border.Border;

import domain.SpaceVehicle;

import java.awt.Color;
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
    
	public SpaceVehicleStatusMenu(SpaceVehicle spaceVehicle, ArrayList<String> currentState, ArrayList<String> inputList) {
		setResizable(false);
		getContentPane().setBackground(new Color(153, 255, 255));
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
		lblSpaceVehicleStatus = new JLabel("    Space Vehicle Status Menu");
		lblSpaceVehicleStatus.setForeground(new Color(255, 255, 255));
//		lblCurrentState = new JLabel("Current State: ");
//		lblCurrentInput = new JLabel("Current Input: ");
		lblCurrentState = new JLabel("Current State: ");
		lblCurrentState.setForeground(new Color(255, 255, 255));
		lblCurrentInput = new JLabel("Current Input: ");
		lblCurrentInput.setForeground(new Color(255, 255, 255));
		lblCounterL = new JLabel("Counter L: ");
		lblCounterL.setForeground(new Color(255, 255, 255));
		lblCounterT = new JLabel("Counter T: ");
		lblCounterT.setForeground(new Color(255, 255, 255));
		lblCounterD = new JLabel("Counter D: ");
		lblCounterD.setForeground(new Color(255, 255, 255));
		lblCurrentStateResults = new JLabel("");
		lblCurrentInputResults = new JLabel("");
		lblCounterLResults = new JLabel("");
		lblCounterTResults = new JLabel("");
		lblCounterDResults = new JLabel("");
	}

	private void addComponentsToWindow() {
		//lblSpaceVehicleStatus
		Border blackline = BorderFactory.createLineBorder(Color.white);
		lblSpaceVehicleStatus.setFont(new Font("Nirmala UI", Font.BOLD, 30));
		lblSpaceVehicleStatus.setBounds(115, 32, 444, 37);
		lblSpaceVehicleStatus.setBorder(blackline);
		getContentPane().add(lblSpaceVehicleStatus);
		
		//lblCurrentState
		lblCurrentState.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCurrentState.setBounds(71, 132, 409, 37);
		getContentPane().add(lblCurrentState);
		
		//lblCurrentInput
		lblCurrentInput.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCurrentInput.setBounds(71, 179, 341, 37);
		getContentPane().add(lblCurrentInput);
		
		//lblCounterL
		lblCounterL.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCounterL.setBounds(71, 226, 122, 37);
		getContentPane().add(lblCounterL);
		
		//lblCounterT
		lblCounterT.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCounterT.setBounds(71, 273, 122, 37);
		getContentPane().add(lblCounterT);
		
		//lblCounterD
		lblCounterD.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCounterD.setBounds(71, 320, 122, 37);
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
						     try {
								Thread.sleep(30000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			});
			t1.start();
			
		
			Thread t2 = new Thread(new Runnable() { 
				@Override 
				public void run() {
					for(String inputList: inputList) {
						try {
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
