package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import domain.SpaceVehicle;
import domain.State;

import java.awt.Font;
import java.util.ArrayList;

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
	
	public SpaceVehicleStatusMenu(SpaceVehicle spaceVehicle, ArrayList<String> currentState, ArrayList<String> inputList) {
		getContentPane().setLayout(null);
		//this.spaceVehicle = spaceVehicle;
		this.currentState = currentState;
		this.inputList = inputList;
		intializeComponents(spaceVehicle);
		addComponentsToWindow();
		setWindowProperties();
		realTimeStatus();
	}

	private void intializeComponents(SpaceVehicle spaceVehicle) {
		lblSpaceVehicleStatus = new JLabel("Space Vehicle Status");
//		lblCurrentState = new JLabel("Current State: ");
//		lblCurrentInput = new JLabel("Current Input: ");
		lblCurrentState = new JLabel("Current State: ");
		lblCurrentInput = new JLabel("Current Input: ");
		lblCounterL = new JLabel("Counter L: ");
		lblCounterT = new JLabel("Counter T: ");
		lblCounterD = new JLabel("Counter D: ");
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
		for(String currentState: currentState) {
			try {
				lblCurrentState.setText("Current State: " + currentState);
				Thread.sleep(2000);
			System.out.println(currentState);		
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(String inputList: inputList) {
			try {
				lblCurrentInput.setText("Current Input: " + inputList);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String [] args) {
	}
}
