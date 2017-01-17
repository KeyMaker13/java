package hashing;

public class ValueCount<T extends Comparable<T>> 
   implements Comparable<ValueCount<T>> {
  T value;
  Counter count;

  public ValueCount(T val) {
    value = val;
    count = new Counter();
    count.inc();
  }
  
  public int hashcode() {
  	return value.hashCode();
  }
  
  public void increment( ) {
    count.inc();
  }

  public T getValue(){
    return value;
  }

  public Counter getCount() {
    return count;
  }

  public String toString() {
    return "<" + value + ":" + count +">";
  }

	@Override
	public int compareTo(ValueCount<T> o) {
		return value.compareTo(o.getValue());
	}
	
}
