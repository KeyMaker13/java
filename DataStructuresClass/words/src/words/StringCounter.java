package words;

/**
 *  StringCounter keeps a count associated with a particular String
 */
public class StringCounter {
   private String word;
   private int count;

   public StringCounter(String word) { // the String to be counted
      this.word = word;
      count = 0;
   }

   public int getCount() { //returns the count associated with this object
      return count;
   }

   public String getString() { //returns String represented by this object
      return word;
   }

   public void increment() { // increments the count
      count++;
   }

   public String toString() { // returns a String representing object state
      return word + ":" + count;
   }

}
