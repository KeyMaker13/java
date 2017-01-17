import java.io.*;
import java.util.*;

class Logger {
    public void log() throws Exception {
	PrintStream logps;
	GregorianCalendar now;
	logps = new PrintStream(new FileOutputStream("log"));
	now = new GregorianCalendar();
	logps.println(now.getTime());
    }
    public void logWithTZ() throws Exception {
	PrintStream logps;
	GregorianCalendar now;
	logps = new PrintStream(new FileOutputStream("log"));
	now = new GregorianCalendar();
	logps.print(now.getTimeZone().getDisplayName()+" ");
	logps.println(now.getTime());
    }
}
