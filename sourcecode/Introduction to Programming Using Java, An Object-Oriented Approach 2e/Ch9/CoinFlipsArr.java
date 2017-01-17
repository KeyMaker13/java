import java.io.*;
import java.util.*;

class CoinFlipsArr {
	public static void main(String[] a) throws Exception {
		BufferedReader  kbd = new BufferedReader(
												 new InputStreamReader(System.in));
		System.out.print("How many experiments to be performed?");
		String expString = kbd.readLine();
		int numExp = Integer.parseInt(expString);
		System.out.print("How many coins in each experiment?");
		String flipString = kbd.readLine();
		int numFlips = Integer.parseInt(flipString);
		System.out.println(numExp+" experiments and "+
						   numFlips+" flips.");
		      int[] headsCount = new int[numFlips];
			  for (int i=0; i < numFlips; i++)
				  headsCount[i] = 0;
			  for (int i=0; i < numExp; i++) {
				  int numHeads = doExperiment(numFlips);
				  headsCount[numHeads]++;
			  }
			  doOutput(headsCount,numExp);
	}
	static int doExperiment(int flips) {
		int heads = 0;
		for (int i=0; i < flips; i++) {
			if (Math.random() < 0.5)
				heads++;
		}
		return heads;
	}
	static void doOutput(int[] a, int numExp) {
		int scaleFactor =  numExp/80+ 1;
		for (int i=0; i < a.length; i++) {
			int heads = a[i];
			for (int j=0; j < heads/scaleFactor; j++) 
				System.out.print('*');
			System.out.println();  
		}
	}
}
