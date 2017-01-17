package lib;


public interface OrderedListADT<T extends Comparable> extends ListADT<T>
{
   //  Adds the specified element to this list at the proper location
   public void add (T element);
}


