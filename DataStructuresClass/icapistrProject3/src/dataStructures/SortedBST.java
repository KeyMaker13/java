package dataStructures;

import java.util.*;

public class SortedBST<T extends Comparable<T>> implements SortedADT<T> {

 private LinkedBinarySearchTree<T> tree ;

 public SortedBST() { //O(1)
	 tree = new LinkedBinarySearchTree<T>();
 }

 // return the maximum element
 public T findMax() { //O(logn) 
  return tree.findMax();
 }

 // return the minimum element
 public T findMin() { //O(logn)
  return tree.findMin();
 }

 // Adds the element, returns true if successful
 public boolean add(T element) { //O(logn)
  tree.addElement(element);
  return true;
 }

 // Returns true if the element is in the collection
 public boolean contains(T element) { //O(logn)
  return tree.contains(element);
 }
 
 // Removes the element, returns true if successful
 public boolean remove(T element) { //O(logn)
  return (Boolean) tree.removeElement(element);
 }

 // Returns an iterator over all the elements
 public ReversibleIterator<T> iterator() { //O(1)
	 return new RIForBST<T>(tree);
 }
 
 // return an Iterator that starts with the first element
 // that is greater than or equal to start
 public ReversibleIterator<T> iterator(T start) { //O(1)
  return new RIForBST<T>(tree,start);
 }
 
 // Returns the number of elements in the collection
 public int size() { //O(1)
  return tree.size();
 }
 
 // Returns a string representation of the collection
 public String toString() { //O(n)
	 String outPut ="";
	 Iterator<T> iter = tree.iteratorInOrder();
	 while(iter.hasNext()){
		 outPut+= "" + iter.next() + " "  ;
	 }
  return outPut;
 }
 
}
