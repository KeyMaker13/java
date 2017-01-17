//------------
// Notes
//	- This class requires the (supplied) file named 'junk' 
//------------

import java.io.*;

class BetterBR extends BufferedReader {
    BetterBR() throws IOException {
        super(new InputStreamReader(System.in));
    }

	BetterBR(String fileName) throws IOException {
		super(new InputStreamReader(
			new FileInputStream(new File(fileName))));
		}

	int readint() throws IOException {
		String line;
		line = readLine();
		return Integer.parseInt(line);
	}

	public static void main(String[] arg) throws IOException {
	    int i;
	    String s;
	    BetterBR bbr = new BetterBR("junk");
	    i = bbr.readint();
	    while (i >= 0) { 
			System.out.println("i = "+i);
			i = bbr.readint();
		}
		s = bbr.readLine();
		while (s != null) {   
	        System.out.println("s = "+s);
			s = bbr.readLine();
		}
	}
}
