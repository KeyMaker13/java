import java.io.*;
import java.util.*;

class CoinFlipsVec {
	public static void main(String[] a) throws Exception {
		BufferedReader  kbd = new BufferedReader(
												 new InputStreamReader(System.in));
		System.out.print("How many experiments? ");
		String expString = kbd.readLine();
		int numExp = Integer.parseInt(expString);
		System.out.print("How many coins per experiment? ");
		String flipString = kbd.readLine();
		int numFlips = Integer.parseInt(flipString);
		System.out.println(numExp+" experiments and "+numFlips+" flips.");
		Vector headsCount = new Vector(numFlips);
		for (int i=0; i < numFlips; i++)
			headsCount.add(new Integer(0));
		for (int i=0; i < numExp; i++) {
			int numHeads = doExperiment(numFlips);
			Integer currCount = (Integer)
				headsCount.elementAt(numHeads);
			headsCount.setElementAt(
									new Integer(currCount.intValue()+1), numHeads);
		}
		doOutput(headsCount,numExp);
	}
	
	static int doExperiment(int flips) {
		int heads = 0;
		for (int i=0; i < flips; i++)
			if (Math.random() < 0.5)
				heads++;        
			// otherwise do nothing...
		
		return heads;
	}
	
	static void doOutput(Vector v, int numExp) {
		int scaleFactor =  numExp/80+ 1;
		for (int i=0; i < v.size(); i++) {
			Integer heads = (Integer) v.elementAt(i);
			for (int j=0; j < heads.intValue()/scaleFactor; j++)
				System.out.print('*');
			System.out.println();  
        }
    }
}
