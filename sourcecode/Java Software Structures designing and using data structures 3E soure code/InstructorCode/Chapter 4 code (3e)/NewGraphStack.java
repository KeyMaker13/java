/**
 *  @author Lewis and Chase
 *
 *  Driver for a program that demonstrates the use of a 
 *  stack's push and pop operations with a graphical 
 *  user interface.
 */

public class NewGraphStack
{
  /**
   * Stack push/pop graphical demo.
   * @param args array of Strings
   */
  public static void main (String[] args)
  {
    NewGraphStackGUI graphStack = new NewGraphStackGUI();
    graphStack.display();
  }
}
