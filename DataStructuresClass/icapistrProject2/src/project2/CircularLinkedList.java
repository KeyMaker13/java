package project2;

import java.util.Iterator;
import java.util.NoSuchElementException;


import java.util.NoSuchElementException;
import exceptions.EmptyListException;

public class CircularLinkedList<T> implements CircularList<T>
{
 private PublicLinkedList<T> linkedList;
 
 public CircularLinkedList() // O(1)
 {
  linkedList = new PublicLinkedList<T>();
 }
 
 @Override
 public void add(T element)	// O(1)
 {
  // Add the element like normal to the linked list.
  linkedList.add(element);
  
  // Get the updated size of the list.
  int size = linkedList.size();
  
  // Fetch the last node in the list (ie, the one we just added).
  PublicNode<T> lastNode = linkedList.getNode(size-1);
  
  // Set its links accordingly to make this a circular list.
  lastNode.next = linkedList.front;
  linkedList.front.previous = lastNode;
 }

 public boolean remove(T element) // O(n)
 {
  if(linkedList.isEmpty())
   throw new EmptyListException();
  
  if(!linkedList.contains(element))
   throw new NoSuchElementException();
  
  // Create references to the second node, the second from last node, and
  // the node we wish to remove.
  PublicNode<T> newFrontNode = linkedList.front.next;
  PublicNode<T> newBackNode = linkedList.back.previous;
  PublicNode<T> nodeToRemove = linkedList.find(element);
  
  // Check to see if we're about to remove the first or last node of the
  // list. If so, do the removal, then fix the node linkages to maintain
  // the circular nature of the list.
  if(nodeToRemove == linkedList.back)
  {
   linkedList.remove(element);
   newBackNode.next = linkedList.front;
   linkedList.back = newBackNode;
  }
  else if(nodeToRemove == linkedList.front)
  {
   linkedList.remove(element);
   newFrontNode.previous = linkedList.back;
   linkedList.back.next = newFrontNode;
  }
  else
   linkedList.remove(element);
  
  return true;
 }

 @Override
 public int size() // O(1)
 {
  return linkedList.size();
 }

 @Override
 public boolean contains(T elt) // O(n)
 {
  return linkedList.contains(elt);
 }

 @Override
 public void setFront(T elt) // O(n)
 {
  // Attempt to find the node corresponding to this element in the list.
  PublicNode<T> node = linkedList.find(elt);
  
  // If not found, throw an exception.
  if(node == null)
   throw new NoSuchElementException();
  
  // Otherwise, set the front of the list to this node, and the back of
  // the list to the node immediately preceding it.
  linkedList.front = node;
  linkedList.back = node.previous;
  //linkedList.remove(elt);
 }

 @Override
 public ReversibleIterator<T> iterator() // O(1)
 {
  return new RIForLinkedList<T>(linkedList);
 }
 
 public String toString() // O(n)
 {
  return linkedList.toString();
 }
}
