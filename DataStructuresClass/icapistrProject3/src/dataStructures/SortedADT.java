package dataStructures;
import java.util.*;

public interface SortedADT<T extends Comparable> extends CollectionADT<T> {

   // return the minimum element
   public T findMin();
 
   // return the maximum element
   public T findMax();

   // return a ReversibleIterator that starts with the first element
   public ReversibleIterator<T> iterator();

   // return a ReversibleIterator that starts with the 
   // first element that is greater than or equal to start
   public ReversibleIterator<T> iterator(T start);
} 