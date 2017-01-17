package fastsorts;
import java.util.*;

public class QuickSortTester {

  public static void main(String[] args) {

    Integer[] test = {8, 1, 4, 9, 6, 3, 5, 2, 7, 0}; 
     Integer[] test1 = test.clone();
     FastSort<Integer> s1 = new FastSort<Integer>();
     int part = s1.findPartition(test1, 0, 9);
     System.out.println("Partition is at " + part);
     s1.printArray(test1, 0, test1.length - 1, " after one partition");
     Integer [] test2 = test.clone();
     System.out.println("\n now doing quicksort ");
     s1.printArray(test2, 0, test2.length - 1, " original array");
     s1.quickSort(test2, 0, 9);
  }
}
