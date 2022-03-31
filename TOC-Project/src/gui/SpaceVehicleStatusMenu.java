package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import domain.SpaceVehicle;

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
	
	public SpaceVehicleStatusMenu(SpaceVehicle spaceVehicle) {
		getContentPane().setLayout(null);
		
		intializeComponents();
		addComponentsToWindow();
		setWindowProperties();
	}

	private void intializeComponents() {
		lblSpaceVehicleStatus = new JLabel("Space Vehicle Status");
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
		lblCurrentState.setBounds(195, 132, 122, 37);
		getContentPane().add(lblCurrentState);
		
		//lblCurrentInput
		lblCurrentInput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCurrentInput.setBounds(195, 179, 122, 37);
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
	
	public static void main(String [] args) {
	}
}
