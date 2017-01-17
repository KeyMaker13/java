/**
 * 
 */
package events;

import java.util.Date;
import java.util.Random;

/**
 * @author Ivan Capistran
 *
 */
public class EventTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("CS1713 Lab 7 : Written by Ivan Capistran.");
		
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
		Event[] event3 = new Event[10];
		for (int i = 0; i < event3.length; i++){
			event3[i] = getNextEvent(20, "ARRIVAL");
			System.out.println(event3[i]);
		}
		System.out.println();
		
		System.out.println("Creating 100 new events and only displaying the maximum and minimum events\nand average time");
		Event[] event4 = new Event[100];
		minTime = 10000;
		maxTime = -1;
		double totalTime = 0;
		for (int i = 0; i < event4.length; i++){
			event4[i] = getNextEvent(20, "ARRIVAL");
			totalTime += event4[i].getM_time();
			
			if (event4[i].getM_time() > maxTime ) {
				maxTime = event4[i].getM_time();
			}
			if (event4[i].getM_time() < minTime ) {
				minTime = event4[i].getM_time();
			}
		}
		System.out.println("Max time = " + maxTime );
		System.out.println("Min time = " + minTime );
		System.out.println("Average time = " + totalTime / event4.length );

	}
	
	static Random randtest = new Random(); // static generator for tester

	   public static Event getNextEvent(int IDRange, String type) {
	     Integer ID = new Integer(randtest.nextInt(IDRange) + 1);
	     Double time = new Double(randtest.nextDouble());
	     return new Event(ID, type, time);

	   }
}