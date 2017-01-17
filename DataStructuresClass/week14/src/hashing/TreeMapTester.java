package hashing;

import java.util.*;

public class TreeMapTester {

	public static void main(String[] args) {
		Random rand = new Random();
		Integer val;
		// Create a TreeMap to hold ValueCount<Integer> keyed by their value
		TreeMap<Integer, Counter> map1 = new TreeMap<Integer, Counter>();

		for (int i = 0; i < 100; i++) {
			val = new Integer(rand.nextInt(10));
			Counter count = map1.get(val);
			if (count == null) {
				count = new Counter();
				map1.put(val, count);
			}
			count.inc();
		}
		System.out.println("TreeMap:" + map1);

	}
}
