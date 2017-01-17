package postfixV2;
import stack.*;

public class Operand extends Token {
  private int integerValue;
  private double doubleValue;
  public boolean validInteger;
  public boolean validDouble;

  public Operand(String name) {
     super(name);
     validInteger = false;
     validDouble = false;
    try {
       integerValue = Integer.parseInt(name);
       validInteger = true;
    } catch (NumberFormatException e) {}
    try {
       doubleValue = Double.parseDouble(name);
       validDouble =true;
   } catch (NumberFormatException e) {}
  }

  public void evaluate(StackADT<Token> s) {
     s.push(this);
  }

  public int getIntValue() {
    return integerValue;
  }

  public double getDoubleValue() {
    return doubleValue;
  }

  public boolean isValidInteger() {
   return validInteger;
 }

 public boolean isValidDouble() {
   return validDouble;
 }

 public String toString() {
    if (isValidInteger()) {
       return "" + integerValue;
    } else {
       if (isValidDouble()) {
          return "" + doubleValue;
       } else {
          return "not an operand";
       }
    }
 }
}

