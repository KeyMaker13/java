package project2;

import java.util.NoSuchElementException;





public class RIForLinkedList<T> implements ReversibleIterator<T>
{
 // All we have to do is maintain a single node, we won't need to refer to
 // the entire list beyond the constructor.
 private PublicNode<T> current;
 
 public RIForLinkedList(PublicLinkedList<T> linkedList) // O(1)
 {
  // Set current to the start of the list.
  current = linkedList.front;
 }

 @Override
 public boolean hasPrevious() // O(1)
 {
  // This should never be null in a circular list, but since this
  // iterator could technically be used with any linked list, we
  // still want this condition here.
  return (current.previous != null);
 }
 
 @Override
 public boolean hasNext() // O(1)
 {
  // This should never be null in a circular list, but since this
  // iterator could technically be used with any linked list, we
  // still want this condition here.
  return (current != null);
 }
 
 @Override
 public T previous() // O(1)
 {
  if(!hasPrevious())
   throw new NoSuchElementException();
  
  current = current.previous;
  return current.element;
 }

 @Override
 public T next() // O(1)
 {
  if(!hasNext())
   throw new NoSuchElementException();

  T ref = current.element;
  current = current.next;
  return ref;
 }

 public void remove() // O(1)
 {
  throw new UnsupportedOperationException();
 }
}