import java.io.*;
public class DisplayFile {
    public static void main(String[] arg) throws Exception {
	BufferedReader br =
	    new BufferedReader(
	        new InputStreamReader(
	            new FileInputStream("example.txt")));
	String line;
	line = br.readLine();
	System.out.println(line);
	line = br.readLine();
	System.out.println(line);
	line = br.readLine();
	System.out.println(line);
    }
}
