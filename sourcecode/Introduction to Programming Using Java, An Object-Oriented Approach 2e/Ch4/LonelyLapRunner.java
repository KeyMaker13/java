import java.io.*;
class LonelyLapRunner {
    public static void main(String args[]) throws Exception{
	BufferedReader keyboard = new BufferedReader(
			              new InputStreamReader(System.in));
	Stopwatch sw = new Stopwatch();
	long bestSoFar = 9223372036854775807L;
	System.out.print("Hit Enter to start!");
	keyboard.readLine();
	sw.start();
	System.out.print("First lap in progress...");
	keyboard.readLine();
	long lapTime = sw.getElapsedTime();
	sw.start();
	if (lapTime < bestSoFar)
	    bestSoFar = lapTime;
	System.out.print("Second lap in progress...");
	keyboard.readLine();
	lapTime = sw.getElapsedTime();
	sw.start();
	if (lapTime < bestSoFar)
	    bestSoFar = lapTime;
	System.out.print("Third lap in progress...");
	keyboard.readLine();
	lapTime = sw.getElapsedTime();
	if (lapTime < bestSoFar)
	    bestSoFar = lapTime;
	System.out.print("Your best time is ");
	System.out.println(bestSoFar/1000);
    }
}
