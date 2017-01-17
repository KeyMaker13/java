package balance;

public class SymbolCheck {

   // returns true if ch is '[', '{', or '(' or false otherwise
   public static boolean isOpenSymbol(char ch) {
      switch (ch) {
         case '[':
         case '{':
         case '(':
            return true;
         default:
            return false;
      }
   }

   // returns true if ch is ']', '}' or ')' or false otherwise
   public static boolean isCloseSymbol(char ch) {
      switch (ch) {
         case ']':
         case '}':
         case ')':
            return true;
         default:
            return false;
      }
   }

   // returns a symbol's pair if it is an open or close symbol
   // if not an open or close symbol returns the character itself
   public static char getPaired(char ch) {
      switch (ch) {
         case '[':
            return ']';
         case '{':
            return '}';
         case '(':
            return ')';
         case ']':
            return '[';
         case '}':
            return '{';
         case ')':
            return '(';
         default:
            return ch;
      }
   }
}
