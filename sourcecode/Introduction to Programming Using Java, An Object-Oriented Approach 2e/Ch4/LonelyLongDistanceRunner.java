import java.io.*;
class LonelyLongDistanceRunner {
    public static void main(String args[]) throws Exception{
	BufferedReader keyboard = new BufferedReader(
                                      new InputStreamReader(System.in));
	Stopwatch sw = new Stopwatch();
	System.out.println("Hit Enter on your way out!");
	keyboard.readLine();
	sw.start();
	System.out.println("Don't forget to hit Enter when you get back!");
	keyboard.readLine();
	sw.showElapsedTime();
	System.out.println("Go take a shower.");
    }
}
