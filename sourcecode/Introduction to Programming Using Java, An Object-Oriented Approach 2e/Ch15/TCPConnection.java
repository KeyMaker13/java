
import java.net.*;
import java.io.*;

class TCPConnection {
    public TCPConnection(String hostname, int portnumber) throws Exception {
        Socket  s = makeSocket(hostname,portnumber);
        br = new BufferedReader(
								new InputStreamReader(
													  s.getInputStream()));
        ps = new PrintStream(s.getOutputStream());
    }
    public String readLine() throws Exception {
        String  s;
        try {
			s = br.readLine();
        } catch (IOException ioe) {
			System.err.println("TCP input failure: network error");
			throw new Exception("Input Failure: Network I/O Error");
        }
        return s;
    }
    public void println(String s) {
        ps.println(s);
    }
    private Socket makeSocket(String hostname, int portnumber) throws Exception {
        Socket s=null;
        int    attempts = 0;
        while (s==null && attempts<maxAttempts) {
			try {
				s  = new Socket(hostname, portnumber);
			} catch (UnknownHostException uhe) {
				System.err.println("Cannot make TCP connection. Reason: Unknown Host: "+hostname);
				throw new TCPException("Connection Failure: Unknown Host");
			} catch (IOException ioe) {
				System.err.println("Connection failed "+
								   "due to Network I/O Error: retrying ...");
			}
			attempts++;
        }
        if  (s==null)
			throw new IOException("Connection Failure: Net I/O Errors");
        else
			return  s;
    }
    private final int      maxAttempts=5;
	private BufferedReader  br;
	private PrintStream     ps;
}

