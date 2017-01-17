package collections;

import java.util.Random;

public class ArrayTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create an Integer array with 10 elements
		Integer [] myArray = new Integer [10];
		Random rand = new Random();
		for (int k = 0; k < myArray.length; k++)
			myArray[k] = new Integer(rand.nextInt(100));
		
		System.out.println("myArray");
		for (int k = 0; k < myArray.length; k++)
			System.out.println(myArray[k]);

		// Find the largest value in myArray
		Integer myMax = myArray[0];
		for (int k = 1; k < myArray.length; k++)
			if (myMax.compareTo(myArray[k]) < 0)
				myMax = myArray[k];
		System.out.println("Max is " + myMax);
	}

}
