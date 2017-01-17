package collections;

import java.util.*;

/**
 * <p>Title: CollectionTest </p>
 *
 * <p>Description: Illustrate the use of several collection types </p>
 *
 * <p>Company: UTSA </p>
 * @author Weining Zhang
 * @version 1.0
 */
public class CollectionTest {

  /**
   * printValues
   *
   * @param iter Iterator
   */
  public static void printValues(Iterator iter) {
    System.out.print("[");
    while (iter.hasNext()) {
      System.out.print(" " + iter.next());
    }
    System.out.println(" ]");
  }

  /**
   * getCount
   *
   * @param iter Iterator
   * @param value int
   * @return Counter
   */
  public static Counter getCounter(Iterator iter, int value) {
    while (iter.hasNext()) {
      Counter count = (Counter) (iter.next());
      if (count.getValue().compareTo(value) == 0) {
        return count;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    Random rand = new Random();
    int val;
    //Create a TreeSet to 10 Integer objects...
    TreeSet<Integer> set = new TreeSet<Integer> ();

    for (int i = 0; i < 10; i++) {
      val = rand.nextInt(1000);
      System.out.println(i + ":" + val);
      set.add(new Integer(val));
    }
    System.out.println("Content of set:");
    printValues(set.iterator());

   // Create a TreeSet to hold CountInteger objects with unique vaues
    TreeSet<Counter> set1 = new TreeSet<Counter> ();
    for (int i = 0; i < 100; i++) {
      val = rand.nextInt(10);
      Counter count = getCounter(set1.iterator(), val);
      if (count == null) {
        set1.add(new Counter(val));
      }
      else {
        count.increment();
      }
    }
    System.out.println("Content of set1:");
    printValues(set1.iterator());

    // Create a TreeMap to hold CountIntegers keyed by their value
    TreeMap<Integer, Counter> map1 = new TreeMap<Integer, Counter> ();
    for (int i = 0; i < 100; i++) {
      val = rand.nextInt(10);
      Counter count = (Counter) (map1.get(new Integer(val)));
      if (count == null) {
        map1.put(new Integer(val), new Counter(val));
      }
      else {
        count.increment();
      }
    }
    System.out.println("Content of map1:");
    printValues(map1.values().iterator());

  }
}
