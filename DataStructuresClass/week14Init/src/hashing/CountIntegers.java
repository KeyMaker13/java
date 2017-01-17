package hashing;

public class CountIntegers implements Comparable {
  int value;
  int count;

  public CountIntegers(int val) {
    value = val;
    count = 1;
  }

  public int compareTo(Object target) {
    CountIntegers other = (CountIntegers)target;
    return value - other.value;
  }

  public void increment( ) {
    count++;
  }

  public int getValue(){
    return value;
  }

  public int getCount() {
    return count;
  }

  public String toString() {
    return "value=" + value + ":" + count;
  }
}
