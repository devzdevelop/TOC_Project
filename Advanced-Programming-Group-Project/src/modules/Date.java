package modules;

public class Date {
	private static final long serialVersionUID = 1L;
	
	private int day;
	private String month;
	private int year;
	
	
	
	public Date() {
		super();
		this.day = 0;
		this.month = "?";
		this.year = 0;
	}

	public Date(int day, String month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return month + " " + day + ", " + year + "\n";
	}
	
	//Complete the following methods so that we can pass the correct one in the database. This might require some brainstorming or research.
	
	public void responseDate() {
		
	}
	
	public void dateOfVisit() {
		
	}
	
	public void paymentDueDate() {
		
	}
	
	public void pDDATE() {
		
	}
}
