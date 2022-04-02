package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpaceVehicle {
	
	private ArrayList<State> statesList = new ArrayList<>();
	private State currentState;
	
	private boolean LS;
	
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
				//Aborts
				double SW30 = rand.nextInt(200); //Should not exceed 30
				double UPW = rand.nextInt(50); //Should not exceed 15
				double ATC10 = rand.nextInt(20); //Should not be less than 10
				double DTC10 = rand.nextInt(20); //Should not be less than 10
				double TDC3 = rand.nextInt(10); //Should not be less than 3
				double DCF5 = rand.nextInt(10); //Should not be less than 5
				double CL4500 = rand.nextInt(13000); //Should not exceed 4500
				double CCF10 = rand.nextInt(20); //Should not be less than 10
				boolean CCD = rand.nextBoolean(); //Should not be true
				
				//Delay
				double LS10 = rand.nextInt(20); //Should not be less than 10
				double MIR5 = rand.nextInt(2500); //Should not exceed 1500
				
//				System.out.println(SW30+ " " +UPW+ " " +ATC10+ " " +DTC10+ " " +TDC3+ " " +DCF5+ " " +CL4500+ " " +CCF10+ " " +CCD+ " " +LS10+ " " +MIR5+ " ");
		
				if (SW30>30 || UPW>15 || ATC10<10 || DTC10<10 || TDC3<3 || DCF5<5 || CL4500>4500 || CCF10<10 || CCD==true) {
					this.currentState = this.changeCurrentState("AC", statesList);
				}else if (LS10<10 || MIR5>1500) {
					this.currentState = this.changeCurrentState("DL", statesList);
				}else if(this.LS== true) {
					this.currentState = this.changeCurrentState("LO", statesList);
				}

			case "DL":
				
			case "AC":
				
			case "LO":
				
			case "PA":
				
			case "IG":
				
			case "SS":
				
			case "OO":
			
			case "BB":
				
			case "EB":
				
			case "SD":
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
