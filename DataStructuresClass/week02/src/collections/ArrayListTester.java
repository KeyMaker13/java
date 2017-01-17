package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ArrayListTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create an Integer ArrayList with 10 elements
		ArrayList <Integer> myArray = new ArrayList <Integer> ();
		Random rand = new Random();
		for (int k = 0; k < 10; k++)
			myArray.add(new Integer(rand.nextInt(100)));
		
		// Print out the array list using indexing
		System.out.println("myArray");
		for (int k = 0; k < myArray.size(); k++)
			System.out.println(myArray.get(k));
		
		// Print out the array using an iterator
		System.out.print("myArray using an iterator: ");
		Iterator <Integer> iter = myArray.iterator();
		while (iter.hasNext())
			System.out.print(iter.next() + " ");
		
		long sum = 0;
		iter = myArray.iterator();
		while (iter.hasNext())
			sum = sum + iter.next().intValue();
		System.out.println("\nSum of myArray using an iterator is " + sum);

	}

}
