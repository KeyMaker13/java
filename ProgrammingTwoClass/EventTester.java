/**
 * 
 */
package events;

import java.util.Date;
import java.util.Random;

/**
 * @author Gregory
 *
 */
public class EventTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("CS1713 Lab 7 : Written by Sean Decker.");
		
		Event event1 = new Event(4, "STOP", 0.5);
		Event event2 = new Event(3, "John Doe", (double) new Date().getTime());
		
		System.out.println("Event 1 = " + event1.toString() );
		System.out.println("Event 2 = " + event2.toString() );
		
		System.out.println("Part II begins here...");
		Event[] myEvents = new Event[6];
		Random rand = new Random();
		for (int i = 0; i < 6; i++){
			myEvents[i] = new Event(rand.nextInt(5) + 1, "ARRIVAL", rand.nextDouble() );
		}
		
		double minTime = 1000;
		double maxTime = -1;
		for (int i = 0; i < 6; i++){
			System.out.println("Event #" + i + " = " + myEvents[i].toString());
			System.out.println("Compared to event1 : " + event1.compareTo(myEvents[i]));
			if (myEvents[i].getM_time() > maxTime ) {
				maxTime = myEvents[i].getM_time();
			}
			if (myEvents[i].getM_time() < minTime ) {
				minTime = myEvents[i].getM_time();
			}
		}
		
		System.out.println("Max time = " + maxTime );
		System.out.println("Min time = " + minTime );
		
		System.out.println("\n\nPart III\n");
		Event[] part3Events = new Event[10];
		for (int i = 0; i < part3Events.length; i++){
			part3Events[i] = getNextEvent(20, "ARRIVAL");
			System.out.println(part3Events[i]);
		}
		
		Event[] part3Events2 = new Event[100];
		minTime = 10000;
		maxTime = -1;
		double totalTime = 0;
		for (int i = 0; i < part3Events.length; i++){
			part3Events2[i] = getNextEvent(20, "ARRIVAL");
			totalTime += part3Events2[i].getM_time();
			//System.out.println(part3Events[i]);
			if (part3Events2[i].getM_time() > maxTime ) {
				maxTime = part3Events2[i].getM_time();
			}
			if (part3Events2[i].getM_time() < minTime ) {
				minTime = part3Events2[i].getM_time();
			}
		}
		
		System.out.println("Max time = " + maxTime );
		System.out.println("Min time = " + minTime );
		System.out.println("Average time = " + totalTime / part3Events2.length );

	}
	
	static Random randtest = new Random(); // static generator for tester

	   public static Event getNextEvent(int IDRange, String type) {
	     Integer ID = new Integer(randtest.nextInt(IDRange) + 1);
	     Double time = new Double(randtest.nextDouble());
	     return new Event(ID, type, time);

	   }
}