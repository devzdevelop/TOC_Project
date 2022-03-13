package main;

import modules.Date;
import modules.Accounts;
import modules.Complaints;
import modules.Technicians;

public class Driver {

	public static void main(String[] args) {
		Technicians technicians = new Technicians();
		//technicians.create("123", "456", "789", "Test", "Ing");
		
		Complaints complaints = new Complaints();
	//	complaints.create("123", "456", "789", "101112", "C", "I", new Date(13, "January", 2022), "ST", new Date(13, "September", 2022), "CS");
		
		
		Accounts accounts = new Accounts();
		accounts.create(123, "PS", 0, new Date(13, "January", 2022));
	}

}
