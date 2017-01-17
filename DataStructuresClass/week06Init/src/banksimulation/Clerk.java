package banksimulation;

public class Clerk {
	// A clerk is an object that provides services to a customer. 
	private Customer currentCustomer; //Customer currently serviced by clerk
	private boolean available; // True if the clerk is available (i.e., has no customer)

	public Clerk(){
		currentCustomer = null;
		available = true;
	}
	
	public void assignCustomer(Customer customer){
		currentCustomer = customer;
		available = false;
	}
	
	public Customer getCustomer(){
		return currentCustomer;
	}
	
	public Event getFinishEvent(int currentTime){
		// Generates the event corresponding to the point in time when the clerk
		// will be finished servicing his currentCustomer 
		return new Event(Event.SERVICE_FINISHED, this, currentTime + 
				currentCustomer.getServiceTime());
	}
	
	public boolean isAvailable(){
		return available;
	}
	
	public void setAvailable(boolean available){
		this.available = available;
	}
	
}
