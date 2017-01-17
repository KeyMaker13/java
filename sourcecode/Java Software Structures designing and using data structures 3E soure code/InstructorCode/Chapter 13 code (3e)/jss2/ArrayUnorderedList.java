/**
 * ArrayUnorderedList represents an array implementation of an unordered list.
 *
 * @author Dr. Lewis
 * @author Dr. Chase
 * @version 1.0, 9/16/2008
 */


package jss2;
import jss2.exceptions.*;

public class ArrayUnorderedList<T> extends ArrayList<T> 
       implements UnorderedListADT<T>
{
   /**
    * Creates an empty list using the default capacity.
    */
   public ArrayUnorderedList()
   {
      super();
   }

   /**
    * Creates an empty list using the specified capacity.
    *
    * @param initialCapacity  the initial integer size of this list
    */
   public ArrayUnorderedList (int initialCapacity)
   {
      super(initialCapacity);
   }

   /**
    * Adds the specified element to the front of the list.
    *
    * @param element  the element to be added to the front of this list
    */
   public void addToFront (T element)
   {
      if (size() == list.length)
         expandCapacity();

      /** shift elements to make room */
      for (int scan=rear; scan > 0; scan--)
         list[scan] = list[scan-1];

      list[0] = element;
      rear++;
   }

   /**
    * Adds the specified element to the rear of the list.
    *
    * @param element  the element to be added to the rear of this list
    */
   public void addToRear (T element)
   {
      if (size() == list.length)
         expandCapacity();

      list[rear] = element;
      rear++;
   }

   /**
    * Adds the specified element after the specified target element.
    * Throws a ElementNotFoundException if the target is not found.
    *
    * @param element  the element to be added after the target
    * @param target   the element after which the given element will be added
    */
   public void addAfter (T element, T target)
   {
      if (size() == list.length)
         expandCapacity();

      int scan = 0;
      while (scan < rear && !target.equals(list[scan])) 
          scan++;
      
      if (scan == rear)
         throw new ElementNotFoundException ("list");
    
      scan++;
      for (int scan2=rear; scan2 > scan; scan2--)
         list[scan2] = list[scan2-1];

      list[scan] = element;
      rear++;
   }
}
