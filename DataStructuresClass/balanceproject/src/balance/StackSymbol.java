package balance;

public class StackSymbol {
   private char ch;
   private int pos;

   public StackSymbol(char ch, int pos) {
      this.ch = ch;
      this.pos = pos;
   }

   public char getSymbol() {
      return ch;
   }

   public int getPosition( ) {
      return pos;
   }

   public String toString( ) {
      return (new Character(ch)) + ":" + pos;
   }
}
