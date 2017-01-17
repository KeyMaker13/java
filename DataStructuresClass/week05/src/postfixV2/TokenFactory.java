package postfixV2;

public class TokenFactory {

   public static Token createToken(String name) {
      if (name == null)
         return null;
      String trimmed = name.trim();
      if (trimmed.equals("+"))
         return new AdditionOperator();
      if (trimmed.equals("*"))
         return new MultiplicationOperator();
      if (trimmed.equals("-"))
         return new SubtractionOperator();
      if (trimmed.equals("/"))
         return new DivisionOperator();
      if (trimmed.equals("%"))
         return new ModulusOperator();
      return new Operand(trimmed);
   }
}
