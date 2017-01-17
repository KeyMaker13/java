package craps;

import java.awt.*;
import javax.swing.*;

/**
 * <p>Panel that draws a dice</p>
 * This panel calculates its size based on the dice size and the border.
 *
 * @version 1.0
 */
public class DicePanel extends JPanel {
   private DiceDrawer draw;
   private int diceValue;
   private int diceBorder;

   public DicePanel(int size, int border) {
      draw = new DiceDrawer(size);
      diceBorder = border;
      diceValue = 1;
      setPreferredSize(new Dimension(2 * border + size, 2 * border + size));
   }

   public int getValue() {
      return diceValue;
   }

   public void paintComponent(Graphics g) {
      Graphics gTemp = g.create();
      gTemp.translate(diceBorder, diceBorder);
      draw.drawDiceFace(gTemp, diceValue);
      System.out.println("test");
      gTemp.dispose();
   }

   public void setValue(int value) {
      diceValue = value;
   }
}
