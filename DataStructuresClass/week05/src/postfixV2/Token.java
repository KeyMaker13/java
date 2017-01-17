package postfixV2;
import stack.*;

public class Token {

   private String name;

  protected static boolean debug  = false;
  public static void setDebug(boolean t) {
      debug = t;
   }

   public Token(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public Object getType() {
      return getClass();
   }

   public Object getValue() {
      return name;
   }

   public void evaluate(StackADT<Token> s) {
   }

   public String valueOf() {
      return name;
   }

   public String toString() {
      return getClass().getName() + ":" + name;
   }
}
