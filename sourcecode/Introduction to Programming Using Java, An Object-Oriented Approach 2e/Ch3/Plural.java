import java.io.*;
class Plural {
    public static void main(String[] arg) throws Exception {
	BufferedReader keyboard =      // Models a keyboard that reads
	    new BufferedReader(        // lines as Strings
		 new InputStreamReader(System.in));
	                                  // Models a keyboard that reads
	                                  // a stream of characters
	String inputLine; // Models a line of input.
	inputLine = keyboard.readLine();
	System.out.print(inputLine);
	System.out.println("s");
    }
}
