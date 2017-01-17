package lib;

import java.util.Random;

public class LinkedListTester {
  public static void main(String[] args) {
    BasicLinkedList.setDebug(true);

    Random rand = new Random();
    BasicLinkedList<Integer> list1 = new
        BasicLinkedList<Integer>();

    System.out.println("list2 is an IndexedList");
    IndexedListADT<Integer> list2 = new
        IndexedLinkedList<Integer> ();
     for (int i = 0; i < 10; i++) {
      int val = rand.nextInt(100);
      list2.add (val);
    }

    System.out.println("the list2 = " + list2);
    list2.removeFirst();
    list2.removeFirst();
    System.out.println("the list2 after two removals = " + list2);
    list2.remove(5);
    System.out.println("the list after removing index = 5 "+list2);

    System.out.println("list3 is an OrderedLinkedList");
    OrderedLinkedList<Integer> list3 = new
        OrderedLinkedList<Integer> ();
    for (int i = 0; i < 10; i++) {
      int val = rand.nextInt(100);
      list3.add(val);
    }
    System.out.println("List3 = " + list3);

    System.out.println("list4 is an UnorderedLinkedList");
    UnorderedLinkedList<Integer> list4 = new
        UnorderedLinkedList<Integer>();
    for (int i = 0; i < 10; i++) {
      int val = rand.nextInt(100);
      list4.addToFront(val);
    }
    System.out.println("List4 = " + list4);

  }
}
