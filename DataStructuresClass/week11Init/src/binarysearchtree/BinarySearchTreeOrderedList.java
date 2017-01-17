package binarysearchtree;

import lib.*;
import java.util.Iterator;

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
public class BinarySearchTreeOrderedList<T extends Comparable<T>>
      implements OrderedListADT<T> {

   private LinkedBinarySearchTree<T> tree;


   public String toString() {
      StringBuffer buf = new StringBuffer("OrderedList:[\n");
      Iterator<T> itr = iterator();
      while (itr.hasNext()) {
         buf.append((T)itr.next() + " ");
      }
      buf.append("\n]\n");
      return buf.toString();
   }

   public BinarySearchTreeOrderedList() {
      tree = new LinkedBinarySearchTree<T>();
   }

   public void add(T element) {
      tree.addElement(element);
   }

   public T removeFirst() {
      return tree.removeMin();
   }

   public T removeLast() {
      return tree.removeMax();
   }

   public T remove(T element) {
      return tree.removeElement(element);
   }

   public T first() {
      return tree.findMin();
   }

   public T last() {
      return tree.findMax();
   }

   public boolean contains(T target) {
      return tree.contains(target);
   }

   public boolean isEmpty() {
      return tree.isEmpty();
   }

   public int size() {
      return tree.size();
   }

   public Iterator<T> iterator() {
      return tree.iteratorInOrder();
   }
}
