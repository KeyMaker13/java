package lib;
import java.util.*;
public interface SimpleListADT<T> {
  public void add (T element); //Adds one element to this set, ignoring duplicates
  public T removeRandom (); //Removes and returns a random element from this set 
  public T remove (T element); //  Removes and returns the specified element from this set
  public boolean contains (T target); //Returns true if this set contains the parameter
  public boolean isEmpty(); //Returns true if this set contains no elements
  public int size(); //Returns the number of elements in this set
  public Iterator<T> iterator(); //Returns an iterator for the elements in this set 
  public String toString(); //Returns a string representation of this set
}
