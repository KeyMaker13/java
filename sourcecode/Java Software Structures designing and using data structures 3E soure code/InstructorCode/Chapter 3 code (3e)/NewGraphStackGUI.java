/** * @author  Lewis and Chase * *  Demonstrates the use of a stack's push and pop operations *  with a graphical user interface. */import jss2.*;import java.awt.*;import java.awt.event.*;import javax.swing.*;public class NewGraphStackGUI extends JPanel{
  /**
   * represents push button on screen
   */   private JButton pushButton;   /**
   * represents pop button on screen
   */   private JButton popButton;   /**
   * displays current stack contents
   */   private JTextArea currentStack;   /**
   * label for input text field
   */   private JLabel inputLabel;   /**
   * input text field
   */   private JTextField currentInput;   /**
   * displays current action
   */   private JTextArea currentAction;   /**
   * panel used as graphical container
   */   private JPanel panel;   /**
   * the stack used in the demo
   */   private ArrayStack<String> myStack = new ArrayStack<String>();    /**   * Sets up the GUI.   */  public NewGraphStackGUI()  {    pushButton = new JButton("Push");    pushButton.addActionListener(new PushListener());    popButton = new JButton("Pop");    popButton.addActionListener(new PopListener());        inputLabel = new JLabel("Add to stack: ");    currentInput = new JTextField(18);    currentInput.setEditable(true);    currentStack = new JTextArea(6, 20);    currentStack.setMargin(new Insets(5,5,5,5));    currentStack.setEditable(false);    currentAction = new JTextArea(3,20);    currentAction.setMargin(new Insets(5,5,5,5));    currentAction.setEditable(false);    currentAction.setText("");        panel = new JPanel();    panel.add(inputLabel);    panel.add(currentInput);    panel.add(pushButton);    panel.add(popButton);        setLayout(new BorderLayout());    add(new JScrollPane(currentStack), BorderLayout.NORTH);    add(panel, BorderLayout.CENTER);    add(new JScrollPane(currentAction), BorderLayout.SOUTH);    setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));  }    /**   * Creates and displays the main application frame.   */  public void display()  {    JFrame frame = new JFrame("Stack Graphics Demo");    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    frame.setContentPane(this);        frame.pack();    frame.setVisible(true);  }  /**
   * Represents an action listener for the push button.   */  private class PushListener implements ActionListener  {    /**     * Adds the contents of the user entry text field to the      * top of this stack.
     * @param event incoming event     */    public void actionPerformed (ActionEvent event)    {      String toPush = currentInput.getText();      if (toPush.length() !=0)      {        myStack.push(toPush);        currentAction.append("\"" + toPush+"\"" + " was pushed onto " +                              "the stack.\n");        currentStack.setText(myStack.toString());        currentStack.setCaretPosition( 0 ); // forces scroll up        currentInput.setText(null); // clears input field      }      else        currentAction.append("Cannot push empty data.\n");    }  }   /**
   * Represents an action listener for the pop button.   */  private class PopListener implements ActionListener  {    /**     * removes the element at the      * top of this stack.
     * @param event incoming event     */    public void actionPerformed (ActionEvent event)    {      if (! myStack.isEmpty())      {        String popped = myStack.pop();        currentAction.append("\"" + popped +"\"" + " was popped off " +                             "the stack.\n");            currentStack.setText(myStack.toString());        currentStack.setCaretPosition( 0 );        currentInput.setText(null);      }      else        currentAction.append("Cannot pop from an empty stack.\n");    }  }}