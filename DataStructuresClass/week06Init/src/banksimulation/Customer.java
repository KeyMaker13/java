package banksimulation;

public class Customer {
	// A customer represent an entity that waits in line for service and
	// is serviced by a clerk
	private int arrivalTime;   // arrival time of a customer
	private int departureTime; // departure time (not known until customer finishes
	private int serviceTime;   // time for clerk to service this customer

	public Customer(int arrives, int service) {
		arrivalTime = arrives;
		serviceTime = service;
		departureTime = 0;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setDepartureTime(int departs) {
		departureTime = departs;
	}

	public int getDepartureTime() {
		return departureTime;
	}
	
	public int getServiceTime() {
		return serviceTime;
	}

	public int totalTime() { // returns total time spent by customer
		return departureTime - arrivalTime;
	}

	public String toString() {
		return getClass().getName() +":[arrival=" + arrivalTime + ", service=" + 
				serviceTime + ", departure=" + departureTime + "]";
	}

}
