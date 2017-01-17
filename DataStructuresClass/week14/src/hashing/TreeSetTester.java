package hashing;

import java.util.*;

public class TreeSetTester {

	public static void printValues(Iterator iter) {
		System.out.print("[");
		while (iter.hasNext()) {
			System.out.print(" " + iter.next());
		}
		System.out.println(" ]");
	}

	public static ValueCount<Integer> getCount(
			Iterator<ValueCount<Integer>> iter, Integer value) {
		while (iter.hasNext()) {
			ValueCount<Integer> count = iter.next();
			if (count.getValue().equals(value))
				return count;
		}
		return null;
	}

	public static void main(String[] args) {
		Random rand = new Random();

		// Create a TreeSet to 10 Integer objects...
		TreeSet<Integer> set = new TreeSet<Integer>();
		Integer val;
		System.out.println("Generate 10 random numbers");
		for (int i = 0; i < 10; i++) {
			val = new Integer(rand.nextInt(1000));
			System.out.print(val + " ");
			set.add(val);
		}
		System.out.println("\nTreeSet:" + set);

		// Create a TreeSet to hold ValueCount objects with unique values
		TreeSet<ValueCount<Integer>> set1 = new TreeSet<ValueCount<Integer>>();
		System.out.println("Generated 100 randome numbers");
		for (int i = 0; i < 100; i++) {
			val = new Integer(rand.nextInt(10));
			ValueCount<Integer> count = getCount(set1.iterator(), val);
			if (count == null) {
				count = new ValueCount<Integer>(val);
				set1.add(count);
			} else
				count.increment();
		}
		System.out.println("TreeSet1:" + set1);

	}
}
