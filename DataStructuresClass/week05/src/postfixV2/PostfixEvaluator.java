package postfixV2;

import java.util.*;

import stack.ArrayStack;
import stack.StackADT;





public class PostfixEvaluator {
   private static boolean debug = false;
   private StackADT<Token> stack;

   public PostfixEvaluator( ) {
      //ArrayStack.setDebug(debug);
      Token.setDebug(debug);
      stack = new ArrayStack<Token>();
   }

   public Token removeTopToken( ) {
      return (Token)(stack.pop());
   }

   public void putTopToken(Token tok) {
      stack.push(tok);
   }

   public Token evaluate(String expr) {
      StringTokenizer tokenizer = new StringTokenizer(expr);

      while (tokenizer.hasMoreTokens()) {
         Token thisToken = TokenFactory.createToken(
                         tokenizer.nextToken());
         thisToken.evaluate(stack);
      }
      return (Token) (stack.pop());
   }

   public static void setDebug(boolean t) {
      debug = t;
   }
}
