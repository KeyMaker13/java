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
public class SearchTest {
  public static void main(String[] args) {
    Integer[] list1 = {5, 11, 2, 9, 8};
    Search<Integer> s1 = new Search<Integer>();
    s1.printArray(list1, "the array");
    System.out.println("Result of searching for 3: " +
                       s1.linearSearch(list1, 3));
    System.out.println("Result of searching for 9: " +
                       s1.linearSearch(list1, 9));
    System.out.println("Result of searching for 5: " +
                      s1.linearSearch(list1, 5));

   Integer[] list2 ={3, 6, 11, 20, 28, 30, 35, 45, 66};
   s1.printArray(list2, "the array");
   System.out.println("Result of searching for 6: " +
                     s1.binarySearch(list2, 6));
  System.out.println("Result of searching for 50: " +
                     s1.binarySearch(list2, 50));
  System.out.println("Result of searching for 35: " +
                    s1.binarySearch(list2, 35));

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
    
    QuadraticSort<Name> q2 = new QuadraticSort<Name> ();

    q2.printArray(test2, "befor selection sort");
    q2.selectionSort(test2);
    q2.printArray(test2, "after selection sort");
    
    Search<Name> s2 = new Search<Name> ();
    Name key = new Name("Who", "S", "Theone");
    System.out.println("Result of searching for " + key +
                       ": " +
                    s2.binarySearch(test2, key));
  }
}
