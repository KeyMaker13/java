package collections;

import java.util.Iterator;
import java.util.Random;

import jss2.ArraySet;
import jss2.SetADT;

public class ArraySetTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create an Integer ArrayList with 10 elements
		SetADT <Integer> mySet = new ArraySet <Integer> ();
		Random rand = new Random();
		for (int k = 0; k < 10; k++)
			mySet.add(new Integer(rand.nextInt()));
		
		// Print out the set using an iterator
		System.out.println("mySet using an iterator");
		Iterator <Integer> iter = mySet.iterator();
		while (iter.hasNext())
			System.out.println(iter.next());
		
		//Create a second set with 3 random integers
		SetADT <Integer> mySet1 = new ArraySet <Integer> ();
		for (int k = 0; k < 3; k++)
			mySet1.add(new Integer(rand.nextInt(5) + 1));
		iter = mySet1.iterator();
		while (iter.hasNext())
			System.out.println(iter.next());
		
		SetADT <Integer> unionSet = mySet.union(mySet1);
		iter = unionSet.iterator();
		System.out.println("Union set is");
		while (iter.hasNext())
			System.out.println(iter.next());
		
	}

}
