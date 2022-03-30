package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import domain.SpaceVehicle;

import java.awt.Font;
import java.util.ArrayList;

public class SpaceVehicleStatusMenu extends JFrame {
	
	public SpaceVehicleStatusMenu(SpaceVehicle spaceVehicle) {
		getContentPane().setLayout(null);
		
		
		intializeComponents();
		addComponentsToWindow();
		setWindowProperties();
	}

	private void intializeComponents() {
		
		
	}

	private void addComponentsToWindow() {
		JLabel lblSpaceVehicleStatus = new JLabel("Space Vehicle Status");
		lblSpaceVehicleStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSpaceVehicleStatus.setBounds(371, 53, 228, 37);
		getContentPane().add(lblSpaceVehicleStatus);
		
		JLabel lblCurrentState = new JLabel("Current State: ");
		lblCurrentState.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCurrentState.setBounds(195, 132, 122, 37);
		getContentPane().add(lblCurrentState);
		
		JLabel lblCurrentInput = new JLabel("Current Input: ");
		lblCurrentInput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCurrentInput.setBounds(195, 179, 122, 37);
		getContentPane().add(lblCurrentInput);
		
		JLabel lblCounterL = new JLabel("Counter L: ");
		lblCounterL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCounterL.setBounds(195, 226, 122, 37);
		getContentPane().add(lblCounterL);
		
		JLabel lblCounterT = new JLabel("Counter T: ");
		lblCounterT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCounterT.setBounds(195, 273, 122, 37);
		getContentPane().add(lblCounterT);
		
		JLabel lblCounterD = new JLabel("Counter D: ");
		lblCounterD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCounterD.setBounds(195, 320, 122, 37);
		getContentPane().add(lblCounterD);
		
		JLabel lblCurrentStateResults = new JLabel("");
		lblCurrentStateResults.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCurrentStateResults.setBounds(314, 132, 122, 37);
		getContentPane().add(lblCurrentStateResults);
		
		JLabel lblCurrentInputResults = new JLabel("");
		lblCurrentInputResults.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCurrentInputResults.setBounds(314, 179, 122, 37);
		getContentPane().add(lblCurrentInputResults);
		
		JLabel lblCounterLResults = new JLabel("");
		lblCounterLResults.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCounterLResults.setBounds(314, 226, 122, 37);
		getContentPane().add(lblCounterLResults);
		
		JLabel lblCounterTResults = new JLabel("");
		lblCounterTResults.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCounterTResults.setBounds(314, 273, 122, 37);
		getContentPane().add(lblCounterTResults);
		
		JLabel lblCounterDResults = new JLabel("");
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
