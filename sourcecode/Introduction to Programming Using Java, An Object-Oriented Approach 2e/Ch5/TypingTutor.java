import java.io.*;

public class TypingTutor {
    public TypingTutor(String practice) {
	practiceString = practice;
	lowestTime = new Minimizer();
	perfectCount = new Counter();
    }
    public void setPracticeString(String newString) {
	practiceString = newString;
	lowestTime.reset();
	perfectCount.reset();
    }
    public long test() throws Exception {
	BufferedReader keyboard = new BufferedReader(
			              new InputStreamReader(System.in));
	System.out.println("String to type: " + practiceString);
	System.out.println("Hit Enter to begin... ");
	Stopwatch sw = new Stopwatch();
	String inputString = keyboard.readLine();
	System.out.println("\nType!\n");
	sw.start();
	inputString = keyboard.readLine();
	long typeTime = sw.getElapsedTime();
	if (practiceString.equals(inputString)) {
	    lowestTime.check(typeTime);
	    perfectCount.increment();
	    return typeTime;
	} else
	    return -1;
    }
    public long getLowestTime() {
	return lowestTime.get();
    }
    public int getNumPerfect() {
	return perfectCount.getValue();
    }

    private String practiceString;
    private Minimizer lowestTime = new Minimizer();
    private Counter perfectCount = new Counter();
}
