package banksimulation;

import queues.*;
import java.util.*;

public class UnbufferedSimulation {
	// This simulation simulates a set of clerks that service several customers.
	// The customers are given by a set of customGenerators which each produce
	// a "stream" of customers. There is no waiting line. When a customer
	// arrives and no clerk is available, then the customer walks away.
	// 
	// This is an event driven simulation in which every change to the system is
	// represented by an event object. All events are stored in an event queue
	// (a priority queue that is ordered by the time of the event).

	// Input for the simulation - streams of customers
	private ArrayList<CustomerGenerator> cGenerators;
	//Clerks provide service to customers
	private ArrayList<Clerk> clerks; 
	//Event queue holds time points at which system changes
	private PriorityQueueADT<Event> eventQueue;// represents time points
	// Current time of the system (starts at 0 and increase with events)
	private int currentTime; 
	// Output of the simulation
	private ArrayList<Customer> servicedCustomers;// The serviced customers
	private String name;

	public UnbufferedSimulation(String simname) {
		cGenerators = new ArrayList<CustomerGenerator>();
		clerks = new ArrayList<Clerk>();
		eventQueue = new LinkedPriorityQueue<Event>();
		servicedCustomers = new ArrayList<Customer>();
		currentTime = 0;
		name = simname;
	}

	public void addCustomerGenerator(CustomerGenerator newGenerator) {
		cGenerators.add(newGenerator);
	}

	public void addClerk(Clerk newClerk) {
		clerks.add(newClerk);
	}
	
	public int getNumberClerks() {
		return clerks.size();
	}
	
	public ArrayList<Customer> getServicedCustomers() {
		return servicedCustomers;
	}
	
	public String getSimulationName() {
		return name;
	}
	
	public int getSimulationTime() {
		return currentTime;
	}

	public void run() {
		// Run the simulation, assuming customerGenerators and clerks have been
		// added.

		// Fill eventQueue with a CUSTOMER_ARRIVAL event for each customer in
		// all the customerGenerators
		initEventQueue();
		currentTime = 0;

		// Event loop: Process events until there is no more event
		// Notice that handleEvent may add events to the eventQueue
		while (!eventQueue.isEmpty()) {
			Event event = eventQueue.removeMin();
			currentTime = event.getTime();
			handleEvent(event);
		}
	}

	private void initEventQueue() {
		// Generate a CUSTOMER_ARRIVAL event for each customer in all the
		// customerGenerators.
		// The customerGenerators will be empty after this method, and they
		// won't be used in the
		// simulation anymore.
		Iterator<CustomerGenerator> iter = cGenerators.iterator();
		while (iter.hasNext()) {
			CustomerGenerator thisGen = iter.next();
			Iterator<Customer> genIter = thisGen.iterator();
			while (genIter.hasNext()) {
				Customer customer = genIter.next();
				Event event = new Event(Event.CUSTOMER_ARRIVAL, customer,
						customer.getArrivalTime());
				eventQueue.add(event);
			}
		}
	}

	private void handleEvent(Event event) {
		
		if (event.getType() == Event.CUSTOMER_ARRIVAL && 
				findAvailableClerk() != null) {
			// a new customer arrives and a clerk is available
			Clerk clerk = findAvailableClerk();
			clerk.assignCustomer((Customer) event.getTarget());
			eventQueue.add(clerk.getFinishEvent(currentTime));
		} else if (event.getType() == Event.SERVICE_FINISHED) {
			// Customer leaves a clerk at currentTime
			Clerk clerk = (Clerk) event.getTarget();
			Customer customer = clerk.getCustomer();
			customer.setDepartureTime(currentTime);
			servicedCustomers.add(customer);
			// Clerk is free. Set mode of the clerk to "available"
			clerk.setAvailable(true);
		}
	} // handleEvent

	private Clerk findAvailableClerk() {
		// Return a clerk that is available (i.e., has no current customer)
		Iterator<Clerk> it = clerks.iterator();
		while (it.hasNext()) {
			Clerk clerk = it.next();
			if (clerk.isAvailable())
				return clerk;
		}
		return null;
	}
}
