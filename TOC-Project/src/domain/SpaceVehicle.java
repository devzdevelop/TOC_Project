package domain;

import java.util.ArrayList;
import java.util.List;

public class SpaceVehicle {
	
	private ArrayList<State> statesList = new ArrayList<>();
	private State currentState;
	
	//Constructors
	public SpaceVehicle() {
		this.initializeStates();
		
		//SpaceVehicle starts in this state
		this.currentState = statesList.get(0);
		System.out.println("\nCurrent State: " + this.getCurrentState());
		
		//Test print all states
		this.getAllStates();
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


	
}
