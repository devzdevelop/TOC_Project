package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import domain.SpaceVehicle;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class SpaceVehicleMenu extends JFrame{
	private static final long serialVersionUID = 1L;

	private JLabel headingLbl;
	private JLabel SW30Lbl;
	private JButton processSignalsBtn;
	private JButton startBtn;
	private JLabel upwLbl;
	private JLabel atcLbl;
	private JLabel dtcLbl;
	private JLabel tdcLbl;
	private JLabel dcfLbl;
	private JLabel cl4500Lbl;
	private JLabel ccf10Lbl;
	private JLabel ls10Lbl;
	private JLabel mir5Lbl;
	private JLabel tpl10Lbl;
	private JTextField sw30TextField;
	private JTextField upwTextField;
	private JTextField atc10TextField;
	private JTextField dtc10TextField;
	private JTextField tdc3TextField;
	private JTextField dcf5TextField;
	private JTextField cl4500TextField;
	private JTextField ccf10TextField;
	private JTextField ls10TextField;
	private JTextField mir5TextField;
	private JTextField tpc10TextField;
	private JLabel ccdLbl;
	private JRadioButton rdbtnCcdTrue;
	JRadioButton rdbtnCcdFalse;
	
	
	private ArrayList<String> inputList; 
	private SpaceVehicle spaceVehicle = new SpaceVehicle();
	
	public SpaceVehicleMenu() {
		getContentPane().setLayout(null);
		
		intializeComponents();
		addComponentsToWindow();
		setWindowProperties();
	}
	
	public void intializeComponents(){
		headingLbl = new JLabel("Space Vehicle");
		SW30Lbl = new JLabel("SW30: ");
//		String [] itemsArray = {"SW30", "UPW", "ATC10", "DTC10", "TDC3", "DCF5", "CL4500", "CCF10", "CCD", "LS10", "MIRS", "TPC10"};
		processSignalsBtn = new JButton("Process Signals");
		startBtn = new JButton("Start");
		upwLbl = new JLabel("UPW: ");
		atcLbl = new JLabel("ATC10: ");
		dtcLbl = new JLabel("DTC10: ");
		tdcLbl = new JLabel("TDC3: ");
		dcfLbl = new JLabel("DCF5: ");
		cl4500Lbl = new JLabel("CL4500: ");
		ccf10Lbl = new JLabel("CCF10: ");
		ls10Lbl = new JLabel("LS10: ");
		mir5Lbl = new JLabel("MIRS: ");
		tpl10Lbl = new JLabel("TPL10: ");
		sw30TextField = new JTextField();
		upwTextField = new JTextField();
		atc10TextField = new JTextField();
		dtc10TextField = new JTextField();
		tdc3TextField = new JTextField();
		dcf5TextField = new JTextField();
		cl4500TextField = new JTextField();
		ccf10TextField = new JTextField();
		ls10TextField = new JTextField();
		mir5TextField = new JTextField();
		tpc10TextField = new JTextField();
		rdbtnCcdTrue = new JRadioButton("True");
		rdbtnCcdFalse = new JRadioButton("False");
		
		inputList = new ArrayList<String>();
	}
	
	public void addComponentsToWindow() {
		//headingLbl
		headingLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		headingLbl.setBounds(309, 30, 122, 37);
		getContentPane().add(headingLbl);
		
		//inputLbl
		SW30Lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SW30Lbl.setBounds(147, 104, 122, 37);
		getContentPane().add(SW30Lbl);
		
		//acceptInputBtn
		processSignalsBtn.setBounds(309, 494, 133, 21);
		getContentPane().add(processSignalsBtn);
		
		//startBtn
		startBtn.setBounds(309, 555, 133, 21);
		getContentPane().add(startBtn);
		
		//upwLbl
		upwLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		upwLbl.setBounds(147, 151, 122, 37);
		getContentPane().add(upwLbl);
		
		//atcLbl
		atcLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		atcLbl.setBounds(147, 198, 122, 37);
		getContentPane().add(atcLbl);
		
		//dtcLbl
		dtcLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dtcLbl.setBounds(147, 245, 122, 37);
		getContentPane().add(dtcLbl);
		
		//tdcLbl
		tdcLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tdcLbl.setBounds(147, 292, 122, 37);
		getContentPane().add(tdcLbl);
		
		//dcfLbl
		dcfLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dcfLbl.setBounds(147, 339, 122, 37);
		getContentPane().add(dcfLbl);
		
		//cl4500Lbl
		cl4500Lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cl4500Lbl.setBounds(429, 104, 122, 37);
		getContentPane().add(cl4500Lbl);
		
		//ccf10Lbl
		ccf10Lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ccf10Lbl.setBounds(429, 151, 122, 37);
		getContentPane().add(ccf10Lbl);
		
		//ls10Lbl
		ls10Lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ls10Lbl.setBounds(429, 245, 122, 37);
		getContentPane().add(ls10Lbl);
		
		//mir5Lbl
		mir5Lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mir5Lbl.setBounds(429, 292, 122, 37);
		getContentPane().add(mir5Lbl);
		
		//tpc10Lbl
		tpl10Lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tpl10Lbl.setBounds(429, 339, 122, 37);
		getContentPane().add(tpl10Lbl);
		
		//sw30TextField
		sw30TextField.setBounds(215, 115, 96, 19);
		getContentPane().add(sw30TextField);
		sw30TextField.setColumns(10);
		
		//upwTextField
		upwTextField.setColumns(10);
		upwTextField.setBounds(215, 162, 96, 19);
		getContentPane().add(upwTextField);
		
		//atc10TextField
		atc10TextField.setColumns(10);
		atc10TextField.setBounds(215, 209, 96, 19);
		getContentPane().add(atc10TextField);
		
		//dtc10TextField
		dtc10TextField.setColumns(10);
		dtc10TextField.setBounds(215, 256, 96, 19);
		getContentPane().add(dtc10TextField);
		
		//tdc3TextField
		tdc3TextField.setColumns(10);
		tdc3TextField.setBounds(215, 303, 96, 19);
		getContentPane().add(tdc3TextField);
		
		//dcf5TextField
		dcf5TextField.setColumns(10);
		dcf5TextField.setBounds(215, 350, 96, 19);
		getContentPane().add(dcf5TextField);
		
		//cl4500TextField
		cl4500TextField.setColumns(10);
		cl4500TextField.setBounds(510, 115, 96, 19);
		getContentPane().add(cl4500TextField);
		
		//ccf10TextField
		ccf10TextField.setColumns(10);
		ccf10TextField.setBounds(510, 162, 96, 19);
		getContentPane().add(ccf10TextField);
		
		//ls10TextField
		ls10TextField.setColumns(10);
		ls10TextField.setBounds(510, 256, 96, 19);
		getContentPane().add(ls10TextField);
		
		//mir5TextField
		mir5TextField.setColumns(10);
		mir5TextField.setBounds(510, 303, 96, 19);
		getContentPane().add(mir5TextField);
		
		//tpc10TextField
		tpc10TextField.setColumns(10);
		tpc10TextField.setBounds(510, 350, 96, 19);
		getContentPane().add(tpc10TextField);
		
		//rdbtnCcdTrue
		rdbtnCcdTrue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnCcdTrue.setBounds(503, 208, 65, 21);
		getContentPane().add(rdbtnCcdTrue);
		
		//
		rdbtnCcdFalse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnCcdFalse.setBounds(570, 208, 81, 21);
		getContentPane().add(rdbtnCcdFalse);
		
		ccdLbl = new JLabel("CCD: ");
		ccdLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ccdLbl.setBounds(429, 198, 52, 37);
		getContentPane().add(ccdLbl);
		
		//Action Listeners
		//acceptInputBtn
		processSignalsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//inputList.add(JOptionPane.showInputDialog("Enter inputs: "));
				spaceVehicle.inputList.add(JOptionPane.showInputDialog("Enter inputs: "));
				
			}
		});
		
		//startBtn
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> textFieldList = new ArrayList<String>();
				//SpaceVehicle spaceVehicle = new SpaceVehicle();
				spaceVehicle.SW30 = Double.parseDouble(sw30TextField.getText());
				textFieldList.add(sw30TextField.getText());
				spaceVehicle.UPW = Double.parseDouble(upwTextField.getText());
				textFieldList.add(upwTextField.getText());
				spaceVehicle.ATC10 = Double.parseDouble(atc10TextField.getText());
				textFieldList.add(atc10TextField.getText());
				spaceVehicle.DTC10 = Double.parseDouble(dtc10TextField.getText());
				textFieldList.add(dtc10TextField.getText());
				spaceVehicle.TDC3 = Double.parseDouble(tdc3TextField.getText());
				textFieldList.add(tdc3TextField.getText());
				spaceVehicle.DCF5 = Double.parseDouble(dcf5TextField.getText());
				textFieldList.add(dcf5TextField.getText());
				spaceVehicle.CL4500 = Double.parseDouble(cl4500TextField.getText());
				textFieldList.add(cl4500TextField.getText());
				spaceVehicle.CCF10 = Double.parseDouble(ccf10TextField.getText());
				textFieldList.add(ccf10TextField.getText());
				
				if(rdbtnCcdTrue.isSelected() == true) {
					spaceVehicle.CCD = true;
					textFieldList.add("true");
				} else if(rdbtnCcdTrue.isSelected() == false) {
					spaceVehicle.CCD = false;
					textFieldList.add("false");
				}
				
				spaceVehicle.LS10 = Double.parseDouble(ls10TextField.getText());
				textFieldList.add(ls10TextField.getText());
				spaceVehicle.MIR5 = Double.parseDouble(mir5TextField.getText());
				textFieldList.add(mir5TextField.getText());
				
				System.out.println(textFieldList);
				//spaceVehicle.TPL10 = Double.parseDouble(tcl10TextField.getText());
				spaceVehicle.run();
				//new SpaceVehicleStatusMenu(spaceVehicle);
			}
		});
	}
	
	public void setWindowProperties() {
		setTitle("Space Vehicle Menu");
		setBounds(100, 100, 889, 715);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String [] args) {
		new SpaceVehicleMenu();
	}
}
