import java.io.*;
import java.util.*;

class Logger {
    public Logger() throws Exception {
	logps = new PrintStream(new FileOutputStream("log"));
    }
    public Logger(String logFile) throws Exception {
	logps = new PrintStream(
				new FileOutputStream(logFile));
    }
    public void log() throws Exception {
	GregorianCalendar now = new GregorianCalendar();
	logps.println(now.getTime());
    }
    public void logWithTZ() throws Exception {
	GregorianCalendar now = new GregorianCalendar();
	logps.print(now.getTimeZone().getDisplayName()+" ");
	logps.println(now.getTime());
    }
    private PrintStream logps;
}
