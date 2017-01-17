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

 public static ValueCount<Integer> getCount(Iterator<ValueCount<Integer>> iter, Integer value) {
    while (iter.hasNext()) {
       ValueCount<Integer> count = iter.next();
       if (count.getValue().equals(value))
          return count;
    }
    return null;
 }

 public static void main(String[] args) {
    Random rand = new Random();

    //Create a TreeSet to 10 Integer objects...
  

    // Create a TreeSet to hold ValueCount objects with unique values

 }
}
