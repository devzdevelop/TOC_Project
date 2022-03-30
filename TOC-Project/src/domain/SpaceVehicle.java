package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class SpaceVehicle {
	
	private ArrayList<State> statesList = new ArrayList<>();
	private State currentState;
	//Aborts
	public double SW30; //Should not exceed 30
	public double UPW; //Should not exceed 15
	public double ATC10; //Should not be less than 10
	public double DTC10; //Should not be less than 10
	public double TDC3; //Should not be less than 3
	public double DCF5; //Should not be less than 5
	public double CL4500; //Should not exceed 4500
	public double CCF10; //Should not be less than 10
	public boolean CCD; //Should not be true
	//Delay
	public double LS10; //Should not be less than 10
	public double MIR5; //Should not exceed 1500
	
	private boolean LS;
	public ArrayList<String> inputList = new ArrayList<String>();
	
	//Constructors
	public SpaceVehicle() {
		this.initializeStates();
		
		//SpaceVehicle starts in this state
		this.currentState = statesList.get(0);
		
		//Set launch signal to default
		this.LS = false;
		
		System.out.println("\nCurrent State: " + this.getCurrentState());
		
		this.LS = true;
		this.changeState(currentState);
		System.out.println("\nCurrent State: " + this.getCurrentState());
		
		//Test print all states
//		this.getAllStates();
	}
	
	//Getters and setters
	public ArrayList<State> getStatesList() {
		return statesList;
	}

	public void setStatesList(ArrayList<State> statesList) {
		this.statesList = statesList;
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}
	
	//Methods
	public void initializeStates() {
		System.out.println("\nInitializing states...");

		statesList.add(new State("LP", "Launch Pad", new ArrayList<>(List.of("LO", "AC", "DL"))));
		statesList.add(new State("DL", "Delay", new ArrayList<>(List.of("AC", "LP"))));
		statesList.add(new State("AC", "Abort", new ArrayList<>(List.of("AC"))));
		statesList.add(new State("LO", "Lift Off", new ArrayList<>(List.of("PA"))));
		statesList.add(new State("PA", "Powered Ascent", new ArrayList<>(List.of("AC", "IG"))));
		statesList.add(new State("IG", "Ignition Condition", new ArrayList<>(List.of("AC", "SS"))));
		statesList.add(new State("SS", "Stage Separation", new ArrayList<>(List.of("AC", "OO"))));
		statesList.add(new State("OO", "On Orbit Operations", new ArrayList<>(List.of("AC", "BB"))));
		statesList.add(new State("BB", "Boostback Burn", new ArrayList<>(List.of("AC", "EB"))));
		statesList.add(new State("EB", "Entry Burn", new ArrayList<>(List.of("SD"))));
		statesList.add(new State("SD", "Splashdown", new ArrayList<>(List.of(""))));
	}
	
	public void getAllStates() {
		System.out.println("\n\t\t~LIST OF STATES~");
		for (State state : statesList) {
			System.out.println("State : " + state);
		}
	}

	public State changeState(State currentState) {
		
		Random rand= new Random();
		
		switch(currentState.getKey()){
		
			case "LP":
				
				if (SW30>30 || UPW>15 || ATC10<10 || DTC10<10 || TDC3<3 || DCF5<5 || CL4500>4500 || CCF10<10 || CCD==true) {
                    this.currentState = this.changeCurrentState("AC", statesList);
//                    JOptionPane.showMessageDialog(null, "Launch Aborted");
                  //  System.exit(0);
                }

                else if (LS10<10 || MIR5>1500) {
                    this.currentState = this.changeCurrentState("DL", statesList);


                }else{
                   // JOptionPane.showMessageDialog(null,"No atmospheric problems detected");
                   // if(input.equals("LS"))
                        this.currentState = this.changeCurrentState("LO", statesList);

                }


            case "DL":
                double SR30 = rand.nextInt(50); //Should not exceed 30
                double TPL10 = rand.nextInt(10); //Should not be less than 10

                if(SR30>30){

                    this.currentState = this.changeCurrentState("LP", statesList);
                }
                else if(TPL10<10){
                    this.currentState = this.changeCurrentState("AC", statesList);
//                    JOptionPane.showMessageDialog(null, "Launch Aborted");
                    //System.exit(0);
                }


            case "LO":
                String input; 
               // if(input.equals("SRB"))
                 this.currentState = this.changeCurrentState("PA", statesList);

            case "PA":
                input = "";
                if(input.equals("MECO")) {
                    this.currentState = this.changeCurrentState("IG", statesList);
                }
                else if(input.equals("RTLS")){
                    this.currentState = this.changeCurrentState("AC", statesList);
            }

            case "IG":
            	 input = "";
                if(input.equals("ET")) {
                    this.currentState = this.changeCurrentState("SS", statesList);
                }
                else if(input.equals("TAL")){
                    this.currentState = this.changeCurrentState("AC", statesList);
                }

            case "SS":
            	 input = "";
                if(input.equals("OIS")) {
                    this.currentState = this.changeCurrentState("OO", statesList);
                }
                else if(input.equals("AOA")){
                    this.currentState = this.changeCurrentState("AC", statesList);
                }

            case "OO":
            	input = "";
                if(input.equals("DS")) {
                    this.currentState = this.changeCurrentState("BB", statesList);
                }
                else if(input.equals("ATO")){
                    this.currentState = this.changeCurrentState("AC", statesList);
                }

            case "BB":
            	input = "";
                if(input.equals("RS")) {
                    this.currentState = this.changeCurrentState("EB", statesList);
                }
                else if(input.equals("CAS")){
                    this.currentState = this.changeCurrentState("AC", statesList);
                }

            case "EB":
            	input = "";
                if(input.equals("SLS")) {
                    this.currentState = this.changeCurrentState("SD", statesList);
                }

            case "SD":

            case "AC":
        }

		
		
		return currentState;
		
	}
	
	public State changeCurrentState(String nextCurrentState,ArrayList<State> statesList) {
		State newCurrentState = new State();
		for (State state : statesList) {
			if (state.getKey()==nextCurrentState) {
				newCurrentState = state;
				break;
			}
		}
		System.out.println("New: "+ newCurrentState);
		
		return newCurrentState;
	}
	
	
	
}