// superceded by TCPConnection Pages 721-723

import java.net.*;
import java.io.*;

class TCPConnection1 {
	public TCPConnection1(String hostname, int portnumber) throws Exception {
		Socket s = new Socket(hostname,portnumber);
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		ps = new PrintStream(s.getOutputStream());
	}
	
	public String readLine() throws Exception {
		String s;
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
	
	private BufferedReader  br;
	private PrintStream     ps;
}
