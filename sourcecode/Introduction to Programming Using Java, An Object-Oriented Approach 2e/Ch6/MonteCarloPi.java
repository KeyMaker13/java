import java.io.*;
public class MonteCarloPi {
    public static void main(String[] a) throws Exception {
	BufferedReader br = new BufferedReader(
			        new InputStreamReader(System.in));
	System.out.print("How many tosses at the board? ");
	String s = br.readLine();
	int numberOfDarts = Integer.parseInt(s.trim());
	double radius = 0.5;
	Dartboard d = new Dartboard(radius);
	for (int i=1; i <= numberOfDarts; i++) {
	    Toss t = Toss.getRandom(radius);
	    d.strike(t);
	}
	double fractionIn = d.getFractionIn();
	double pi = 4.0 * fractionIn;
	System.out.println("Pi is approximately "+pi);
    }
}
