package project2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import exceptions.EmptyListException;

public class PublicLinkedList<T> implements ListADT<T>
{
 private static Random rand = new Random();
 protected PublicNode<T> back;
 protected PublicNode<T> front;
 protected int count;

 public PublicLinkedList() // O(1)
 {
  count = 0;
  front = null;
  back = null;
 }

 public void add(T element) // O(1)
 {
  PublicNode<T> node = new PublicNode<T>(element);
  
  if(count > 0)
  {
   back.next = node;
   node.previous = back;
  }
  else
  {
   front = node;
  }
  back = node;
  
  count++;
 }

 public boolean contains(T target) // O(n)
 {
  PublicNode<T> temp = front;
  
  for(int i=0; i<count; i++)
  {
   if(target.equals(temp.element))
    return true;
   temp = temp.next;
  }
  
  return false;
 }
 
 public boolean isEmpty() // O(1)
 {
  return (count==0);
 }
 
 public Iterator<T> iterator() 
 { 
  return new LinkedListIterator<T>(front);
 }

 public T remove(T element) // O(n)
 {
  if(isEmpty())
   throw new EmptyListException();
  
  if(!contains(element))
   throw new NoSuchElementException();
  
  count--;
  PublicNode<T> curr = front;
  if(front.element.equals(element))
   front = front.next;
  else
  {
   PublicNode<T> prev = null;
   while(!curr.element.equals(element))
   {
    prev = curr;
    curr = curr.next;
   }
   prev.next = curr.next;
  }
  return curr.element;
 }

 public T removeRandom() // O(n)
 {
  if(isEmpty())
   throw new EmptyListException();
  int choice = rand.nextInt(count);
  PublicNode<T> temp = front;
  for(int i =0; i<choice; i++)
   temp = temp.next;
  return remove(temp.element);
 }
 
 public int size() // O(1)
 {
  return count;
 }

 public String toString() // O(n)
 {
  PublicNode<T> temp = front;
  String toReturn = "[";
  
  // first count-1 elements
  for(int i=0; i<count-1; i++)
  {
   toReturn += temp.element + ", ";
   temp = temp.next;
  }

  if(count > 0)
   toReturn += temp.element;
  
  return toReturn + "]";
 }

 public PublicNode<T> getNode(int index) // O(n)
 {
  if(isEmpty()) 
   throw new EmptyListException();
  if(index < 0 || index >= count)
   throw new IndexOutOfBoundsException();
     
  PublicNode<T> ref = front;
    
  for(int i=0; i < index; i++)
   ref = ref.next;
  
  return ref;
 }
 
 public PublicNode<T> find(T target) // O(n)
 {
  if(!contains(target))
   return null;
  
  PublicNode<T> temp = front;
  while(temp != null)
  {
   if(target.equals(temp.element))
    return temp;
   temp = temp.next;
  }
  
  return null;
 }
}		 


