package linkedlistset;

import java.util.*;



public class LinkedListTest {

  public static void main(String[] args) {

    // this main simply tests the methods for the implementations of the SetADT
    // to try a different implementation change the instations below to fit the
    // other classes.

    SimpleLinkedList.setDebug(true);
    System.out.println("Create list1: ");
    ListADT<Integer> list1 = new SimpleLinkedList<Integer> ();
    System.out.println("list1 = " + list1);

    Integer neg1 = new Integer(-1);
    Integer zero = new Integer(0);
    list1.add(zero);
    System.out.println("does list1 contain 0? " + list1.contains(zero));
    System.out.println("does list1 contain -1? " + list1.contains(neg1));

    Random rand = new Random();
    System.out.println("Add to list1: ");
    for (int i = 0; i < 10; i++){
      list1.add(new Integer(rand.nextInt(100)));
    }
    System.out.println("now, list1 =" +list1);
    
    for (int i = 0; i < 10; i++){
    	Integer removed = list1.removeRandom();
    	System.out.println("remove " + removed + ", and list1 = " + list1);
    }
  }
}
