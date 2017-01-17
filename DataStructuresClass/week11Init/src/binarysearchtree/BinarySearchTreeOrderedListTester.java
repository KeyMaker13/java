package binarysearchtree;

import java.util.Random;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2004</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class BinarySearchTreeOrderedListTester {
   public static void main(String[] args) {
      BinarySearchTreeOrderedList<Integer> list =
            new BinarySearchTreeOrderedList<Integer>();
      Random rand = new Random();
      for (int i = 0; i<15; i++) {
         list.add(new Integer(rand.nextInt(200)));
      }
      list.add(new Integer(35));
      list.add(new Integer(95));

      System.out.println(list);
      System.out.println("first=" + list.first() + ", last=" + list.last());
      list.removeFirst();
      list.removeLast();
      list.remove(new Integer(35));
      System.out.println(list);

   }
}
