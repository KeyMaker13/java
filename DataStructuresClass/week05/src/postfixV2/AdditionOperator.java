package postfixV2;

import stack.StackADT;

public class AdditionOperator extends Token {

   public AdditionOperator( ) {
      super("+");
   }

   public AdditionOperator(String name) {
      super("+");
   }

   public void evaluate(StackADT<Token> s) {
      Operand op2 = (Operand) s.pop();
      Operand op1 = (Operand) s.pop();
      Operand result;
      if (op1.isValidInteger() && op2.isValidInteger()) {
         result = new Operand(String.valueOf(
                       op1.getIntValue() +
                               op2.getIntValue()));
      } else {
         result = new Operand(String.valueOf(
                       op1.getDoubleValue() +
                               op2.getDoubleValue()));

      }
      if (debug) {
         System.out.println("" + op1 + " " + getName()
               + " " + op2);
      }
      s.push(result);
   }
}
