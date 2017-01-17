package bank;

public class Event implements Comparable {
	// An Event is an object that stores an event, i.e., a time point when something
	// changes in the simulation.
	// A CUSTOMER_ARRIVAL event represents the arrival of a new customer who needs to
	// be assigned to an available clerk, or if none is available has to wait in line.
	// A SERVICE_FINISHED event represents the point in time when a clerk finishes servicing
	// one customer, and is now available to serve the next customer.
	public static final int CUSTOMER_ARRIVAL = 0;
	public static final int SERVICE_FINISHED = 1;


	private int time;    // The time that this event happens
	private int type;	 // The type of this event (either CUSTOMER_ARRIVAL or SERVICE_FINISHED)
	private Object target;    // Either a Customer (if type==CUSTOMER_ARRIVAL) or a Clerk (if type==SERVICE_FINISHED)

	public Event(int type, Object target, int time){
		this.type = type;
		this.target = target;
		this.time=time;
	}

	public Object getTarget(){
		return target;
	}

	public int getType(){
		return type;
	}

	public int getTime(){
		return time;
	}

	public int compareTo(Object o){
		// Order events by their time
		// This is needed for the event queue
		Event otherEvent = (Event)o;
		return (time-otherEvent.getTime());
	}

}
