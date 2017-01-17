package games;

import java.util.*;

public class Dice {
   private int numberSides;
   private int sideUp;
   private static Random rand = new Random();

   public Dice(int sides) {
      numberSides = sides;
      sideUp = 1;
   }

   public int getNumberSides() {
      return numberSides;
   }

   public int getSideUp() {
      return sideUp;
   }

   public void roll() {
      sideUp = rand.nextInt(numberSides) + 1;
   }

   public String toString() {
      return "number of sides=" + numberSides + " side up is " + sideUp;
   }
}
