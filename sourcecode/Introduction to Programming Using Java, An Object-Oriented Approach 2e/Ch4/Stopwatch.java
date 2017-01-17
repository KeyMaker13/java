import java.util.*;

class Stopwatch {
    public void start() {
	GregorianCalendar now = new GregorianCalendar();
	startTime = now.getTimeInMillis();
    }
    public void showElapsedTime() {
	GregorianCalendar now = new GregorianCalendar();
	long currTime = now.getTimeInMillis();
	long difference = (currTime - startTime)/1000;
	System.out.print(difference);
	System.out.println(" seconds have elapsed.");
    }
    public long getElapsedTime() {
	GregorianCalendar now = new GregorianCalendar();
	long currTime = now.getTimeInMillis();
	return (currTime - startTime);
    }
    private long startTime;
}
