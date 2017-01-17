/**
 * 
 */
package events;

/**
 * @author YOUR NAME
 *
 */
public class Event implements Comparable {

	// Member variables
	// TODO  add member variables : source, type, and time ... all of type Comparable
	// TODO  implement accessor methods for member variables.
	private int m_source;
	public int getM_source() {
		return m_source;
	}

	public void setM_source(int mSource) {
		m_source = mSource;
	}

	public String getM_type() {
		return m_type;
	}

	public void setM_type(String mType) {
		m_type = mType;
	}

	public double getM_time() {
		return m_time;
	}

	public void setM_time(double mTime) {
		m_time = mTime;
	}

	private String m_type;
	private double m_time;
	
	
	/**
	 * Constructor 
	 */
	public Event(int source, String type, double time) {
		// TODO Auto-generated constructor stub
		m_source=source;
		m_type=type;
		m_time=time;
		
	}
	
	/**
	 * toString returns a human readable representation of this object
	 */
	public String toString() { 
		return this.getClass() + ": " + 
		"Source=" + m_source +
		"; Type=" + m_type +
		"; Time" + m_time;
	}
	
	/*
	 * This method is required for objects implementing Comparable interface.
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo( Object other ) {
		int iResult = 0;
		Event otherEvent = (Event)other;
		
		//Check times for equality, then source, then type.
		if( m_time == otherEvent.getM_time() ){
			iResult = -1;
			if( m_source == otherEvent.getM_source() ){
				if( m_type == otherEvent.getM_type() ){
					iResult = 0;
				}
			}
		}
		else {
			if (m_time < otherEvent.getM_time()){
				return -1;
			}
			else
			{
				return 1;
			}
			}
				
			
		
		
		
		return iResult;
	}

}
