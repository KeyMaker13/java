package heap;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class HeapSortTester {
  public static void main(String[] args) {
    
    Integer[] test = {8, 1, 4, 9, 6, 3, 5, 2, 7, 0};
    FastSort<Integer> q1 = new FastSort<Integer>();
   Integer[] test1 = test.clone();
    
    q1.printArray(test1, 0, test1.length - 1, " before heap sort");
    q1.heapsort(test1, 0, test1.length - 1);
    q1.printArray(test1, 0, test1.length - 1, " after heap sort");


  }
}
