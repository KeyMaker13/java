/**
 * QueueADT defines the interface to a queue collection.
 *
 * @author Dr. Lewis
 * @author Dr. Chase
 * @version 1.0, 9/17/2008
 */

package jss2;

public interface QueueADT<T>
{
   /**
    * Adds one element to the rear of the queue
    *
    * @param element  the element to be added to the rear of this queue
    */
   public void enqueue (T element);

   /**
    * Removes and returns the element at the front of the queue
    *
    * @return  the element at the front of this queue
    */
   public T dequeue();

   /**
    * Returns without removing the element at the front of the queue
    *
    * @return  the element at the front of this queue
    */
   public T first();
   
   /**
    * Returns true if the queue contains no elements
    *
    * @return  true if the queue contains no elements
    */
   public boolean isEmpty();

   /**
    * Returns the number of elements in the queue
    *
    * @return  the integer number of elements in this queue
    */
   public int size();

   /**
    * Returns a string representation of the queue
    *
    * @return  a string representation fo the queue
    */
   public String toString();
}
