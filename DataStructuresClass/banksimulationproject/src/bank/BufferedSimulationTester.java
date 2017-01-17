package bank;

import java.util.ArrayList;
import java.util.Iterator;

public class BufferedSimulationTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	System.out.println("BufferedSimulationTester class written by Ivan Capistran");
	 System.out.println("\n");
	//Custom print 1
	System.out.println("Custom Test 1: 5 clerks, 20 customers, departure time 10");
	 BufferedSimulation c1 = BufferedSimulationTester.simpleSimulation(5, 20,10);
	  BufferedSimulationTester.analyzeSimulation(c1);
	 System.out.println("\n");
	  
	//Custom print 2
	  System.out.println("Custom Test 2 : 10 clerks, 12 customers, 30 departure time");
	  BufferedSimulation c2 = BufferedSimulationTester.simpleSimulation(10, 12, 30);
	  BufferedSimulationTester.analyzeSimulation(c2);
	  System.out.println("\n");
	  
	//Custom print 3 
	  System.out.println("Custom Test 3: Random Simulation 15 clerks");
	  BufferedSimulation c3 = BufferedSimulationTester.randomSimulation(15);
	  BufferedSimulationTester.analyzeSimulation(c3);
	  System.out.println("\n");
	  
	//Custom print 4 
	  System.out.println("Custom Test 4: Notes example Simulation");
	  BufferedSimulation c4 = BufferedSimulationTester.notesExampleSimulation(7, 20);
	  BufferedSimulationTester.analyzeSimulation(c4);
	  System.out.println("\n");
	  
	
	// one clerk, two customers
	System.out.println("First test");
    BufferedSimulation s1 = BufferedSimulationTester.simpleSimulation(1, 2,10);
    BufferedSimulationTester.analyzeSimulation(s1);
    
    // two clerks, two customers
	System.out.println("\nSecond test");
    BufferedSimulation s2 = BufferedSimulationTester.simpleSimulation(2, 2, 10);
    BufferedSimulationTester.analyzeSimulation(s2);
    
    // Notes example:
    
	System.out.println("\nThird test");
    BufferedSimulation s3 = BufferedSimulationTester.notesExampleSimulation(3, 30);
    BufferedSimulationTester.analyzeSimulation(s3);
    
}

public static void analyzeSimulation(BufferedSimulation sim) {
	System.out.println("Results for simulation: " 
					+ sim.getSimulationName());
	System.out.println("Total time: " + sim.getSimulationTime());
	ArrayList <Customer> cust = sim.getServicedCustomers();
	System.out.println("Number of customers serviced: " + cust.size());
	int totalServiceTime = 0;
	int totalSystemTime = 0;
	Iterator <Customer> iter = cust.iterator();
	while(iter.hasNext()) {
		Customer thisCust = iter.next();
		System.out.println(thisCust);
		totalServiceTime += thisCust.getServiceTime();
		totalSystemTime += thisCust.getDepartureTime() - thisCust.getArrivalTime();
	}
	System.out.println("Total service time: " + totalServiceTime);
	System.out.println("Total system time: " + + totalSystemTime);
	
}

public static BufferedSimulation simpleSimulation(int nclerks, 
		int ncustomers, int service) {
	// Run a simulation with nclerks and ncustomers that
	// all arrive at time 0 and each have the service time.
	BufferedSimulation sim = new BufferedSimulation(nclerks +
			" clerks, " + ncustomers + 
			" customers with service times of " + service);
	for (int k = 0; k < nclerks; k++)
	   sim.addClerk(new Clerk());
	CustomerGenerator gen1 = new StandardCustomerGenerator();
	for (int k = 0; k < ncustomers; k++)  
		gen1.addCustomer(new Customer(0, service));
	sim.addCustomerGenerator(gen1);
	sim.run();
	return sim;
}	

public static BufferedSimulation notesExampleSimulation(int nclerks, int service) {
	BufferedSimulation sim = new BufferedSimulation(
			"Notes example with " + nclerks + 
			" clerks and customer service time " + service);
	// Add the clerks
	for (int k = 0; k < nclerks; k++)
		sim.addClerk(new Clerk());
	
	// Add the first customer generator
	CustomerGenerator gen1 = new StandardCustomerGenerator();
	gen1.addCustomer(new Customer(0, service));
	gen1.addCustomer(new Customer(15, service));
	gen1.addCustomer(new Customer(25, service));
	sim.addCustomerGenerator(gen1);
	
	// Add the second customer generator
	CustomerGenerator gen2 = new StandardCustomerGenerator();
	gen2.addCustomer(new Customer(10, service));
	gen2.addCustomer(new Customer(20, service));
	sim.addCustomerGenerator(gen2);
	
	// Add the first customer generator
	CustomerGenerator gen3 = new StandardCustomerGenerator();
	gen3.addCustomer(new Customer(37, service));
	gen3.addCustomer(new Customer(57, service));
	sim.addCustomerGenerator(gen3);
	
	sim.run();
	return sim;
}

public static BufferedSimulation randomSimulation(int nClerks){
	
	BufferedSimulation sim = new BufferedSimulation(nClerks+ " Clerks");
	
	for (int k = 0; k < nClerks; k++){
		sim.addClerk(new Clerk());
	}
	
	CustomerGenerator gen1 = new RandomCustomerGenerator(10,100,50);
	CustomerGenerator gen2 = new RandomCustomerGenerator(5,150,30);
	
	sim.addCustomerGenerator(gen1);
	sim.addCustomerGenerator(gen2);
	sim.run();
	return sim;
}
}
