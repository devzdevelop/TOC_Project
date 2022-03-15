package main;

import modules.Date;
import modules.Accounts;
import modules.Complaints;
import modules.Technicians;

public class Driver {

	public static void main(String[] args) {
		//You might have to make adjustments (if you made changes to the technicians class) to the argument passed in the method create the technicians class. Bellow is just test data to test if the method works.
		Technicians technicians = new Technicians();
		//technicians.create("123", "456", "789", "Test", "Ing");
		
		Complaints complaints = new Complaints();
		//You might have to make adjustments (if you made changes to the complaints class) to the argument passed in the method create the complaints class. Bellow is just test data to test if the method works.
	//	complaints.create("123", "456", "789", "101112", "C", "I", new Date(13, "January", 2022), "ST", new Date(13, "September", 2022), "CS");
		
		//You might have to make adjustments (if you made changes to the accounts class) to the argument passed in the method create the accounts class. Bellow is just test data to test if the method works.
		Accounts accounts = new Accounts();
		//accounts.create(123, "PS", 0, new Date(13, "January", 2022));
		
		//Customers customers = new Customers();
		//customers.create();
		
		//CustomerServiceReps customerServiceReps = new CustomerServiceReps();
		//customerServiceReps.create();
	}

}
