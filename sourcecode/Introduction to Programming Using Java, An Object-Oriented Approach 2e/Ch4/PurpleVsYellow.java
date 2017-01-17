import java.io.*;

class PurpleVsYellow {
    public static void main(String args[]) throws Exception{
	BufferedReader keyboard = new BufferedReader(
				      new InputStreamReader(System.in));
	Counter purpleCounter = new Counter();
	Counter yellowCounter = new Counter();
	System.out.print("Person #1, do you prefer purple or yellow? ");
	String response = keyboard.readLine();
	if (response.equals("purple"))
	    purpleCounter.increment();
	else
	    yellowCounter.increment();
	System.out.print("Person #2, do you prefer purple or yellow? ");
	response = keyboard.readLine();
	if (response.equals("purple"))
	    purpleCounter.increment();
	else
	    yellowCounter.increment();
	System.out.print("Person #3, do you prefer purple or yellow? ");
	response = keyboard.readLine();
	if (response.equals("purple"))
	    purpleCounter.increment();
	else
	    yellowCounter.increment();
	if (purpleCounter.getValue() > yellowCounter.getValue())
	    System.out.println("Purple wins.");
	else
	    System.out.println("Yellow wins.");
    }
}
