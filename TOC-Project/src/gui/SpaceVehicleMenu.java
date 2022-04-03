package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import domain.SpaceVehicle;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;

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
	private JRadioButton rdbtnCcdFalse;
	private JLabel lblEnterCurrentWeather;
	
	
	private ArrayList<String> inputList; 
	private SpaceVehicle spaceVehicle = new SpaceVehicle();
	private JLabel headingLbl_1;
	private JLabel errorHandleLbl;
	
	public SpaceVehicleMenu() {
		setResizable(false);
		getContentPane().setBackground(new Color(153, 255, 255));
		getContentPane().setLayout(null);
		
		intializeComponents();
		addComponentsToWindow();
		setWindowProperties();
	}
	
	public void intializeComponents(){
		headingLbl = new JLabel("     Welcome To Space Vehicle Menu!");
		headingLbl.setForeground(new Color(255, 255, 255));
		SW30Lbl = new JLabel("SW30: ");
		SW30Lbl.setForeground(new Color(204, 102, 0));
//		String [] itemsArray = {"SW30", "UPW", "ATC10", "DTC10", "TDC3", "DCF5", "CL4500", "CCF10", "CCD", "LS10", "MIRS", "TPC10"};
		processSignalsBtn = new JButton("Process Signals");
		processSignalsBtn.setToolTipText("Enter input individually.");
		processSignalsBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		processSignalsBtn.setForeground(new Color(255, 255, 255));
		processSignalsBtn.setBackground(Color.CYAN);
		startBtn = new JButton("Start");
		startBtn.setToolTipText("Start with the data you entered.");
		startBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		startBtn.setForeground(new Color(0, 255, 255));
		startBtn.setBackground(new Color(255, 255, 255));
		upwLbl = new JLabel("UPW: ");
		upwLbl.setForeground(new Color(204, 102, 0));
		atcLbl = new JLabel("ATC10: ");
		atcLbl.setForeground(new Color(204, 102, 0));
		dtcLbl = new JLabel("DTC10: ");
		dtcLbl.setForeground(new Color(204, 102, 0));
		tdcLbl = new JLabel("TDC3: ");
		tdcLbl.setForeground(new Color(204, 102, 0));
		dcfLbl = new JLabel("DCF5: ");
		dcfLbl.setForeground(new Color(204, 102, 0));
		cl4500Lbl = new JLabel("CL4500: ");
		cl4500Lbl.setForeground(new Color(204, 102, 0));
		ccf10Lbl = new JLabel("CCF10: ");
		ccf10Lbl.setForeground(new Color(204, 102, 0));
		ls10Lbl = new JLabel("LS10: ");
		ls10Lbl.setForeground(new Color(204, 102, 0));
		mir5Lbl = new JLabel("MIRS: ");
		mir5Lbl.setForeground(new Color(204, 102, 0));
		tpl10Lbl = new JLabel("TPL10: ");
		tpl10Lbl.setForeground(new Color(204, 102, 0));
		sw30TextField = new JTextField();
		sw30TextField.setBackground(new Color(204, 102, 51));
		upwTextField = new JTextField();
		upwTextField.setBackground(new Color(204, 102, 0));
		atc10TextField = new JTextField();
		atc10TextField.setBackground(new Color(204, 102, 0));
		dtc10TextField = new JTextField();
		dtc10TextField.setBackground(new Color(204, 102, 0));
		tdc3TextField = new JTextField();
		tdc3TextField.setBackground(new Color(204, 102, 0));
		dcf5TextField = new JTextField();
		dcf5TextField.setBackground(new Color(204, 102, 0));
		cl4500TextField = new JTextField();
		cl4500TextField.setBackground(new Color(204, 102, 0));
		ccf10TextField = new JTextField();
		ccf10TextField.setBackground(new Color(204, 102, 0));
		ls10TextField = new JTextField();
		ls10TextField.setBackground(new Color(204, 102, 0));
		mir5TextField = new JTextField();
		mir5TextField.setBackground(new Color(204, 102, 0));
		tpc10TextField = new JTextField();
		tpc10TextField.setBackground(new Color(204, 102, 0));
		rdbtnCcdTrue = new JRadioButton("True");
		rdbtnCcdTrue.setForeground(new Color(204, 102, 0));
		rdbtnCcdTrue.setBackground(new Color(153, 255, 255));
		rdbtnCcdFalse = new JRadioButton("False");
		rdbtnCcdFalse.setBackground(new Color(153, 255, 255));
		rdbtnCcdFalse.setForeground(new Color(204, 102, 0));
		lblEnterCurrentWeather = new JLabel("Enter Current Weather Conditions: ");
		errorHandleLbl = new JLabel("");
		
		inputList = new ArrayList<String>();
	}
	
	public void addComponentsToWindow() {
		Border blackline = BorderFactory.createLineBorder(Color.white);
		//headingLbl
		headingLbl.setFont(new Font("Nirmala UI", Font.BOLD, 30));
		headingLbl.setBounds(115, 33, 560, 34);
		headingLbl.setBorder(blackline);
		getContentPane().add(headingLbl);
		
		//inputLbl
		SW30Lbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		SW30Lbl.setBounds(147, 179, 122, 37);
		getContentPane().add(SW30Lbl);
		
		//acceptInputBtn
		processSignalsBtn.setBounds(286, 488, 172, 21);
		getContentPane().add(processSignalsBtn);
		
		//startBtn
		startBtn.setBounds(309, 542, 133, 21);
		getContentPane().add(startBtn);
		
		//upwLbl
		upwLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		upwLbl.setBounds(147, 226, 122, 37);
		getContentPane().add(upwLbl);
		
		//atcLbl
		atcLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		atcLbl.setBounds(147, 273, 122, 37);
		getContentPane().add(atcLbl);
		
		//dtcLbl
		dtcLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		dtcLbl.setBounds(147, 320, 122, 37);
		getContentPane().add(dtcLbl);
		
		//tdcLbl
		tdcLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		tdcLbl.setBounds(147, 367, 122, 37);
		getContentPane().add(tdcLbl);
		
		//dcfLbl
		dcfLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		dcfLbl.setBounds(147, 414, 122, 37);
		getContentPane().add(dcfLbl);
		
		//cl4500Lbl
		cl4500Lbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		cl4500Lbl.setBounds(429, 179, 122, 37);
		getContentPane().add(cl4500Lbl);
		
		//ccf10Lbl
		ccf10Lbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		ccf10Lbl.setBounds(429, 226, 122, 37);
		getContentPane().add(ccf10Lbl);
		
		//ls10Lbl
		ls10Lbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		ls10Lbl.setBounds(429, 320, 122, 37);
		getContentPane().add(ls10Lbl);
		
		//mir5Lbl
		mir5Lbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		mir5Lbl.setBounds(429, 367, 122, 37);
		getContentPane().add(mir5Lbl);
		
		//tpc10Lbl
		tpl10Lbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		tpl10Lbl.setBounds(429, 414, 122, 37);
		getContentPane().add(tpl10Lbl);
		
		//sw30TextField
		sw30TextField.setBounds(215, 190, 96, 19);
		getContentPane().add(sw30TextField);
		sw30TextField.setColumns(10);
		
		//upwTextField
		upwTextField.setColumns(10);
		upwTextField.setBounds(215, 237, 96, 19);
		getContentPane().add(upwTextField);
		
		//atc10TextField
		atc10TextField.setColumns(10);
		atc10TextField.setBounds(215, 284, 96, 19);
		getContentPane().add(atc10TextField);
		
		//dtc10TextField
		dtc10TextField.setColumns(10);
		dtc10TextField.setBounds(215, 331, 96, 19);
		getContentPane().add(dtc10TextField);
		
		//tdc3TextField
		tdc3TextField.setColumns(10);
		tdc3TextField.setBounds(215, 378, 96, 19);
		getContentPane().add(tdc3TextField);
		
		//dcf5TextField
		dcf5TextField.setColumns(10);
		dcf5TextField.setBounds(215, 425, 96, 19);
		getContentPane().add(dcf5TextField);
		
		//cl4500TextField
		cl4500TextField.setColumns(10);
		cl4500TextField.setBounds(510, 190, 96, 19);
		getContentPane().add(cl4500TextField);
		
		//ccf10TextField
		ccf10TextField.setColumns(10);
		ccf10TextField.setBounds(510, 237, 96, 19);
		getContentPane().add(ccf10TextField);
		
		//ls10TextField
		ls10TextField.setColumns(10);
		ls10TextField.setBounds(510, 331, 96, 19);
		getContentPane().add(ls10TextField);
		
		//mir5TextField
		mir5TextField.setColumns(10);
		mir5TextField.setBounds(510, 378, 96, 19);
		getContentPane().add(mir5TextField);
		
		//tpc10TextField
		tpc10TextField.setColumns(10);
		tpc10TextField.setBounds(510, 425, 96, 19);
		getContentPane().add(tpc10TextField);
		
		//rdbtnCcdTrue
		rdbtnCcdTrue.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnCcdTrue.setBounds(503, 283, 65, 21);
		getContentPane().add(rdbtnCcdTrue);
		
		//
		rdbtnCcdFalse.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnCcdFalse.setBounds(570, 283, 81, 21);
		getContentPane().add(rdbtnCcdFalse);
		
		ccdLbl = new JLabel("CCD: ");
		ccdLbl.setForeground(new Color(204, 102, 0));
		ccdLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		ccdLbl.setBounds(429, 273, 52, 37);
		getContentPane().add(ccdLbl);
		
		//lblEnterCurrentWeather
		lblEnterCurrentWeather.setForeground(new Color(204, 102, 0));
		lblEnterCurrentWeather.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblEnterCurrentWeather.setBounds(69, 132, 341, 37);
		getContentPane().add(lblEnterCurrentWeather);
		
		//
		errorHandleLbl.setFont(new Font("Tahoma", Font.ITALIC, 14));
		errorHandleLbl.setBounds(309, 591, 214, 13);
		getContentPane().add(errorHandleLbl);
		
		
		
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
			@SuppressWarnings("unused")
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
				spaceVehicle.TPL10 = Double.parseDouble(tpc10TextField.getText());
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
