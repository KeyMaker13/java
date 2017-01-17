package heap;

public class MergeSortTester {

  public static void main(String[] args) {
   Integer[] test = {8, 1, 4, 9, 6, 3, 5, 2, 7, 0};
    FastSort<Integer> q1 = new FastSort<Integer>();
   Integer[] test1 = test.clone();
    
    q1.printArray(test1, 0, test1.length - 1, " before merge sort");
    q1.mergeSort(test1, 0, test1.length - 1);
    q1.printArray(test1, 0, test1.length - 1, " after merge sort");

  }
}
