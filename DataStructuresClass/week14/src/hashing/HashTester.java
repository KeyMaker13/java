package hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.WeakHashMap;

public class HashTester {
	public static void printValues(String name, Iterator iter) {
		System.out.print(name + ": [");
		int i = 0;
		while (iter.hasNext()) {
			if (i >= 10 && i % 10 == 0) {
				System.out.println();
			}
			System.out.print(" " + iter.next());
			i++;
		}
		System.out.println(" ]");
	}

	public static ValueCount<Integer> getCount(
			Iterator<ValueCount<Integer>> iter, Integer value) {
		while (iter.hasNext()) {
			ValueCount<Integer> count = (ValueCount<Integer>) (iter.next());
			if (count.getValue().equals(value))
				return count;
		}
		return null;
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Integer val;
		// Create a TreeMap to hold ValueCount<Integer> keyed by their value
		HashMap<Integer, Counter> map1 = new HashMap<Integer, Counter>();
		IdentityHashMap<Integer, Counter> map2 = new IdentityHashMap<Integer, Counter>();
		WeakHashMap<Integer, Counter> map3 = new WeakHashMap<Integer, Counter>();
		LinkedHashMap<Integer, Counter> map4 = new LinkedHashMap<Integer, Counter>();

		HashSet<ValueCount<Integer>> set1 = new HashSet<ValueCount<Integer>>();
		LinkedHashSet<ValueCount<Integer>> set2 = new LinkedHashSet<ValueCount<Integer>>();

		Counter count;
		ValueCount<Integer> vc;
		System.out.println("Generate 100 randome numbers");
		for (int i = 0; i < 100; i++) {
			val = new Integer(rand.nextInt(10));
			if (i % 10 == 9) {
				System.out.println(val);
			} else {
				System.out.print(val + ", ");
			}
			count = map1.get(val);
			if (count == null) {
				count = new Counter();
				map1.put(val, count);
			}
			count.inc();

			count = map2.get(val);
			if (count == null) {
				count = new Counter();
				map2.put(val, count);
			}
			count.inc();

			count = map3.get(val);
			if (count == null) {
				count = new Counter();
				map3.put(val, count);
			}
			count.inc();

			count = map4.get(val);
			if (count == null) {
				count = new Counter();
				map4.put(val, count);
			}
			count.inc();

			vc = getCount(set1.iterator(), val);
			if (vc == null)
				set1.add(new ValueCount<Integer>(val));
			else
				vc.increment();

			vc = getCount(set2.iterator(), val);
			if (vc == null)
				set2.add(new ValueCount<Integer>(val));
			else
				vc.increment();
		}

		System.out.println();

		printValues("HashMap:", map1.entrySet().iterator());
		printValues("IdentityHashMap", map2.entrySet().iterator());
		printValues("WeakHashMap", map3.entrySet().iterator());
		printValues("LinkedHashMap", map4.entrySet().iterator());

		System.out.println();
		System.out.println("HashSet" + ":" + set1);
		System.out.println("LinkedHashSet" + ":" + set2);

	}

}
