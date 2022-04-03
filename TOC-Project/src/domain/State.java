package domain;

import java.util.ArrayList;

public class State {
	//Attributes
	private String key;
	private String value;
	private ArrayList<String> nextStateKeyList = new ArrayList<>();

	//Constructors
	public State() {
		this.key = "?";
		this.value = "?";
		this.nextStateKeyList = null;
	}	
	
	public State(String key, String value, ArrayList<String> nextStateKeyList) {
		this.key = key;
		this.value = value;
		this.nextStateKeyList = nextStateKeyList;
	}

	//Getters and Setters
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ArrayList<String> getNextStateList() {
		return nextStateKeyList;
	}

	public void setNextStateList(ArrayList<String> nextStateList) {
		this.nextStateKeyList = nextStateList;
	}

	@Override
	public String toString() {

		return "key = " + key + " | value = " + value + " | nextStateKeyList = " + nextStateKeyList;

	}
	
	
	
	
	
	

}

