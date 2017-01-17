package searcingsorting;

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
public class InsertionSortTest {
  public static void main(String[] args) {
    Integer[] test = {8, 1, 4, 9, 3, 6, 5, 7, 2, 0};
    QuadraticSort<Integer> q1 = new QuadraticSort<Integer>();
    q1.printArray(test, "befor selection sort");
    q1.insertionSort(test);
    q1.printArray(test, "after selection sort");

    Name[] test2 = new Name[10];
    test2[0] = new Name("AAA", "D", "BBBB");
    test2[1] = new Name("aaab", "f", "ABBc");
    test2[2] = new Name("Reedf", "I", "Cddes");
    test2[3] = new Name("Steve", "H", "Absten");
    test2[4] = new Name("Hope", "A", "wonder");
    test2[5] = new Name("Who", "S", "Theone");
    test2[6] = new Name("How", "A", "Good");
    test2[7] = new Name("Steve","B","Good");
    test2[8] = new Name("Cdd", "B", "Wonder");
    test2[9] = new Name("What","A","Date");

    QuadraticSort<Name> q2 = new QuadraticSort<Name>();
    q2.printArray(test2, "befor selection sort");
    q2.insertionSort(test2);
    q2.printArray(test2, "after selection sort");
  }
}
