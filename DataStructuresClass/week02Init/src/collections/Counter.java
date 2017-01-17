package collections;

/**
 * <p>Title: Counter </p>
 *
 * <p>Description: An object to maintain a count of other comparable objects </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: UTSA </p>
 * @author Weining Zhang
 * @version 1.0
 */
public class Counter implements Comparable {
  Comparable value;
  int count;

  Counter(Comparable val) {
    value = val;
    count = 0;
  }

  public int compareTo(Object target) {
    Counter other = (Counter)target;
    return value.compareTo(other.value);
  }

  public void increment( ) {
    count++;
  }

  public Comparable getValue(){
    return value;
  }

  public int getCount() {
    return count;
  }

  public String toString() {
    return "value=" + value + ":" + count;
  }
}
