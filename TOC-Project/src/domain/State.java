package domain;

public class State {
	//Attributes
	private String key;
	private String value;
	//private State nextState;

	//Constructors
	public State() {
		this.key = "?";
		this.value = "?";
	}	
	
	public State(String key, String value) {
		this.key = key;
		this.value = value;
	}

	//Getters and Setters
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	//ToString
	@Override
	public String toString() {
		return "State [key=" + key + ", value=" + value + "]";
	}
	
	
	
	
	
	
	
}
