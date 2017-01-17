package doublelinks;

import java.util.Random;

import jss2.DoubleLinkedSet;


public class DoubleLinkedSetTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Lab 4 written by Ivan Capistran");
		
		// Creating random number generator object
		Random rand = new Random();
		
		// Creating DoubleLinkedSet object
		DoubleLinkedSet<Integer> dLSetInteger = new DoubleLinkedSet<Integer>();
		
		// adding 10 random integer values
		for (int i = 1; i <= 10; i ++){
			Integer temp = rand.nextInt(100) + 1; 
			dLSetInteger.add(temp);
		}
		System.out.println("Creating DoubleLinkedSet with 10 Integer random values");
		System.out.println(dLSetInteger.toString());
		
		System.out.println("Testing contains");
		System.out.println("If DoubleLinkedSet does not contain the number 13 then add it to the set");
		// testing contains method
		if (!dLSetInteger.contains(13)){
			
			dLSetInteger.add(13);
			dLSetInteger.add(23);
			dLSetInteger.add(34);
	
		}
		System.out.println(dLSetInteger.toString());
		
		//Testing remove and removeRandom
		System.out.println("Removing number 13");
		dLSetInteger.remove(13);
		System.out.println(dLSetInteger.toString());
		System.out.println("Removing Random");
		dLSetInteger.removeRandom();
		System.out.println(dLSetInteger.toString());
		System.out.println("Removing Random");
		dLSetInteger.removeRandom();
		System.out.println(dLSetInteger.toString());
		System.out.println("Removing Random");
		dLSetInteger.removeRandom();
		System.out.println(dLSetInteger.toString());
		System.out.println("Removing Random");
		dLSetInteger.removeRandom();
		System.out.println(dLSetInteger.toString());
		System.out.println("Removing Random");
		dLSetInteger.removeRandom();
		System.out.println(dLSetInteger.toString());
		System.out.println("Removing Random");
		dLSetInteger.removeRandom();
		System.out.println(dLSetInteger.toString());
		System.out.println("Removing Random");
		dLSetInteger.removeRandom();
		System.out.println(dLSetInteger.toString());
		System.out.println("Removing Random");
		dLSetInteger.removeRandom();
		System.out.println(dLSetInteger.toString());
		System.out.println("Removing Random");
		dLSetInteger.removeRandom();
		System.out.println(dLSetInteger.toString());
		
		
		
		
		
		
		
		
		
		

	}

}
