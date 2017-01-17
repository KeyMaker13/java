/** * QueueGUI demonstrates the use of a queue using a graphic user interface.
 *
 * @author Dr. Lewis 
 * @author Dr. Chase
 * @version 1.0, 08/12/08 */
import jss2.*;import jss2.exceptions.*;import javax.swing.*;import java.awt.*;import java.awt.event.*;import java.util.LinkedList; // to track linked list contentsimport java.awt.FontMetrics; // to calculate string width in pixelspublic class QueueGUI{  Graphics2D g2;    static JFrame myFrame = new JFrame("Queue Demonstration");  static JPanel drawPane;    private JTextField inputTF;  private JTextArea contentsTA;  private JScrollPane contentsSP,outputSP,drawPaneSP;  private JTextArea outputTA = new JTextArea();  private JLabel sizeLbl = new JLabel("Number of elements in queue: 0");  static boolean showFunctions = false;    static Color textColor = new Color(210,210,255);  static Color nodeColor = new Color(1,110,218);  static Color bgColor = new Color(47,47,63);  static Color ptrColor = new Color(7,223,7);  static Color valueColor = new Color(255,255,255);  static Color objColor = Color.ORANGE;  static Color strColor = Color.MAGENTA;  static Color logColor = new Color(34,110,61);    private LinkedQueue<String> myQueue = new LinkedQueue<String>();  private LinkedList<String> myList = new LinkedList<String>();    /**   * Creates the GUI elements.   */  public Component createComponents()  {    sizeLbl.setFont(new Font("Verdana", Font.PLAIN, 12));    sizeLbl.setHorizontalAlignment(SwingConstants.CENTER);    JLabel inputLbl = new JLabel("Enter data to enqueue: ");    inputLbl.setHorizontalAlignment(SwingConstants.CENTER);    inputLbl.setFont(new Font("Verdana", Font.PLAIN, 12));    JLabel contentsLbl = new JLabel("Output of myQueue.toString():");    contentsLbl.setHorizontalAlignment(SwingConstants.CENTER);    contentsLbl.setFont(new Font("Verdana", Font.PLAIN, 12));        /**     * Represents an action listener for Enqueue.     */    class EnqueueListener implements ActionListener    {      /**       * Adds entered data to the rear of this queue.       */      public void actionPerformed(ActionEvent e)      {        String curInput = inputTF.getText();        if (!curInput.equals(""))        {          myQueue.enqueue(curInput);          myList.add(curInput);          if (showFunctions)          {            outputTA.append("\nCalled: myQueue.enqueue(\"" + curInput +                      "\");  // \"" + curInput + "\" has been enqueued");            outputTA.setText(outputTA.getText()); // forces scroll down          }          else          {            outputTA.append("\nEnqueued \"" + curInput + "\"");            outputTA.setText(outputTA.getText());          }          inputTF.setText(""); // clears user input field          sizeLbl.setText("Number of elements in queue: " + myQueue.size());          inputTF.selectAll();                    contentsTA.setText(myQueue.toString());          drawPane.repaint();          }          else          {            outputTA.append("\nCannot enqueue empty data!");            outputTA.setText(outputTA.getText());          }        }      }            /**       * Shows the graphical representation of the queue.       */      class DrawQueuePanel extends JPanel      {        public void paintComponent(Graphics g)        {          int curX = 80;          int curY = 25;          int boxHt = 30;                    g2 = (Graphics2D) g;          super.paintComponent(g2); //paints background          g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,                              RenderingHints.VALUE_ANTIALIAS_ON);          g2.setRenderingHint(RenderingHints.KEY_RENDERING,                              RenderingHints.VALUE_RENDER_QUALITY);          g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,                              RenderingHints.VALUE_INTERPOLATION_BICUBIC);          g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,                              RenderingHints.VALUE_COLOR_RENDER_QUALITY);          g2.setStroke(new BasicStroke((float)1.75,BasicStroke.CAP_ROUND,                           BasicStroke.JOIN_MITER));                    /** draws each box for the border */          Dimension drawDim = this.getSize();          g2.setBackground(bgColor);          g2.clearRect(0,0,drawDim.width,drawDim.height);	          g2.drawRect(0,0,drawDim.width-1,drawDim.height-1);          g2.setFont(new Font("Verdana", Font.BOLD, 12));          FontMetrics fm = g2.getFontMetrics();          g2.setPaint(textColor);                    /** Draws the myQueue node */          g2.drawString("myQueue",curX-15,curY);          curY += 5;                    /** Draws the first box */          g2.setPaint(objColor);          g2.drawRect(curX,curY,boxHt,3*boxHt);                    /** draws the separators */          g2.drawLine(curX,curY + boxHt,curX + boxHt,curY + boxHt);          g2.drawLine(curX,curY + 2*boxHt,curX + boxHt,curY + 2*boxHt);                    /** queue count display */          int nowSize = myQueue.size();          String curSize = "" + nowSize;          g2.setPaint(valueColor);          int countPad = (boxHt - fm.stringWidth(curSize))/2;          g2.drawString(curSize,curX + countPad,curY + boxHt - 10);                    /** draws labels on left side */          g2.setPaint(textColor);          g2.drawString("count",curX-45,curY+boxHt-10);          curY += boxHt;          g2.drawString("front",curX-45,curY+boxHt-10);          g2.drawString("rear",curX-45,curY+(2*boxHt)-10);                    if (nowSize == 0)          {            /** draws null symbol */            g2.setPaint(ptrColor);            g2.drawLine(curX, curY, curX + boxHt, curY+boxHt);            g2.drawLine(curX, curY+boxHt, curX + boxHt, curY+2*boxHt);          }           else if (nowSize == 1)          {            /** draws the front arrow to the right */            g2.setPaint(ptrColor);            g2.drawLine(curX + (boxHt/2), curY + boxHt/2,                        curX + (4*boxHt), curY + boxHt/2);                        /** draws the arrowpoints */            g2.drawLine(curX + (4*boxHt), curY + boxHt/2,                        curX + (4*boxHt)-4, curY + (boxHt/2)-4);            g2.drawLine(curX + (4*boxHt), curY + boxHt/2,                        curX + (4*boxHt)-4, curY + (boxHt/2)+4);                        /** draws the rear arrow to the right */            g2.drawLine(curX + (boxHt/2), curY + (3*boxHt/2),                        curX + (9*boxHt/2), curY + (3*boxHt/2));                        /** draws the small line up */            g2.drawLine(curX + (9*boxHt/2), curY + (3*boxHt/2),                        curX + (9*boxHt/2), curY + boxHt);                        /** draws the arrowpoints */            g2.drawLine(curX + (9*boxHt/2), curY + boxHt,                        curX + (9*boxHt/2)-4, curY + (boxHt)+4);            g2.drawLine(curX + (9*boxHt/2), curY + boxHt,                        curX + (9*boxHt/2)+4, curY + (boxHt)+4);                        /** draws label above nodes */            g2.setPaint(textColor);            g2.drawString("[ next | element ]", curX + 4*boxHt-15, curY-5);                    }          else          {            /** draws the front arrow to the right */            g2.setPaint(ptrColor);            g2.drawLine(curX + (boxHt/2), curY + boxHt/2,                        curX + (4*boxHt), curY + boxHt/2);                        /** draws the arrowpoints */            g2.drawLine(curX + (4*boxHt), curY + boxHt/2,                        curX + (4*boxHt)-4, curY + (boxHt/2)-4);            g2.drawLine(curX + (4*boxHt), curY + boxHt/2,                        curX + (4*boxHt)-4, curY + (boxHt/2)+4);                        /** draws the small line down for rear arrow */            g2.drawLine(curX + (boxHt/2), curY + (3*boxHt/2),                         curX + (boxHt/2), curY + (2*boxHt) +                         ((nowSize-2)*(3*boxHt/2)));                        /** draws the line to the rear node */            g2.drawLine(curX + (boxHt/2), curY + (2*boxHt) +                        ((nowSize-2)*(3*boxHt/2)), curX + (4*boxHt),                       curY + (2*boxHt) + ((nowSize-2)*(3*boxHt/2)));                        /** draws the arrowpoints */            g2.drawLine(curX + (4*boxHt), curY + (2*boxHt) +                       ((nowSize-2)*(3*boxHt/2)), curX + (4*boxHt)-4,                       curY + (2*boxHt) + ((nowSize-2)*(3*boxHt/2))-4);            g2.drawLine(curX + (4*boxHt), curY + (2*boxHt) +                       ((nowSize-2)*(3*boxHt/2)), curX + (4*boxHt)-4,                       curY + (2*boxHt) + ((nowSize-2)*(3*boxHt/2))+4);                                      /** draws label above nodes */            g2.setPaint(textColor);            g2.drawString("[ next | element ]", curX + 4*boxHt-15, curY-5);          }                curX += boxHt*4;                for (int i=0; i < myList.size(); i++)        {          String top =  myList.get(i);                     /** draws the first box */          g2.setPaint(nodeColor);          g2.drawRect(curX,curY,2*boxHt,boxHt);                      /** draws the separator */          g2.drawLine(curX + boxHt,curY,curX + boxHt,curY + boxHt);                    /** draws the arrow to the element */          g2.setPaint(ptrColor);          g2.drawLine(curX + ((3*boxHt)/2), curY + boxHt/2,                      curX + (4*boxHt), curY + boxHt/2);                    /** draws the arrow points */          g2.drawLine(curX + (4*boxHt), curY + boxHt/2,                      curX + (4*boxHt)-4, curY + (boxHt/2)-4);          g2.drawLine(curX + (4*boxHt), curY + boxHt/2,                      curX + (4*boxHt)-4, curY + (boxHt/2)+4);                                          int elementLen = fm.stringWidth("\"" + top + "\"");          g2.setPaint(strColor);                    /** draws the element box */          g2.drawRect(curX + 4*boxHt, curY, elementLen + 10, boxHt);          g2.setPaint(valueColor);                    /** element data */          g2.drawString("\"" + top + "\"",curX + (4*boxHt)+ 5,curY + boxHt - 10);                    if (i != myList.size()-1)          {              g2.setPaint(ptrColor);                        /** draws down arrow */            g2.drawLine(curX + boxHt/2,curY + boxHt/2,curX + boxHt/2,                        curY + ((3*boxHt)/2));                        /** draws arrow points */            g2.drawLine(curX + boxHt/2,curY + ((3*boxHt)/2),                       (curX + boxHt/2)-4,curY + ((3*boxHt)/2)-4);            g2.drawLine(curX + boxHt/2,curY + ((3*boxHt)/2),                       (curX + boxHt/2)+4,curY + ((3*boxHt)/2)-4);                    }          else          {            /** draws null pointer */            g2.setPaint(ptrColor);            g2.drawLine(curX, curY + boxHt, curX + boxHt, curY);            /** updates the scrollbars if drawing goes out of view */            drawPane.setPreferredSize(new Dimension(400, curY + 2*boxHt));            drawPane.revalidate();          }          curY += (boxHt * 3)/2;        }      }    }        inputTF = new JTextField(10);    inputTF.setFont(new Font("Verdana", Font.BOLD, 12));    inputTF.setHorizontalAlignment(SwingConstants.CENTER);    inputTF.addActionListener(new EnqueueListener());         JButton enQbutton = new JButton("Enqueue");    enQbutton.setMnemonic(KeyEvent.VK_E);    enQbutton.addActionListener(new EnqueueListener());    enQbutton.setFont(new Font("Verdana", Font.PLAIN, 22));        JButton deQbutton = new JButton("Dequeue");    deQbutton.setFont(new Font("Verdana", Font.PLAIN, 22));    deQbutton.setMnemonic(KeyEvent.VK_D);    /**  dequeue button uses anonymous class for listener */    deQbutton.addActionListener(new ActionListener() {
      /**       * Removes and returns data at the front of this queue.       */      public void actionPerformed(ActionEvent e)      {        if (myQueue.size() > 0)        {          String curDeQ =  myQueue.dequeue();          Object dummy = myList.removeFirst();          if (showFunctions)          {            outputTA.append("\nCalled: String curDeQ =   " +                            "myQueue.dequeue();  // Now, curDeQ is \""                            + curDeQ + "\"");            outputTA.setText(outputTA.getText());          }          else          {            outputTA.append("\nDequeued \"" + curDeQ + "\" from the queue");            outputTA.setText(outputTA.getText());          }          sizeLbl.setText("Number of elements in queue: " + myQueue.size());          contentsTA.setText(myQueue.toString());                    drawPane.repaint();        }        else        {          outputTA.append("\nCannot dequeue from an empty queue!");          outputTA.setText(outputTA.getText());        }      }    });        JButton firstButton = new JButton("First");    firstButton.setFont(new Font("Verdana", Font.PLAIN, 22));    firstButton.setMnemonic(KeyEvent.VK_F);    firstButton.addActionListener(new ActionListener() {
      /**       * Returns value of data at the front of this queue.       */      public void actionPerformed(ActionEvent e)      {        if (myQueue.size() > 0)        {          String curFirst =  myQueue.first();                    if (showFunctions)          {            outputTA.append("\nCalled: String curFirst =   myQueue.first();  " +                            "// Now, curFirst is \"" + curFirst + "\"");            outputTA.setText(outputTA.getText());          }          else          {            outputTA.append("\nChecked the first element of the queue, " +                            "and it is \"" + curFirst + "\"");            outputTA.setText(outputTA.getText());          }        }        else        {          outputTA.append("\nCannot execute first() on an empty queue!");          outputTA.setText(outputTA.getText());        }      }    });        JButton sizeButton = new JButton("Size");    sizeButton.setFont(new Font("Verdana", Font.PLAIN, 22));    sizeButton.setMnemonic(KeyEvent.VK_S);    sizeButton.addActionListener(new ActionListener() {      /**       * Returns the size of this queue.       */      public void actionPerformed(ActionEvent e)      {        int curSize = myQueue.size();                   if (showFunctions)        {          outputTA.append("\nCalled: int curSize = myQueue.size();  " +                          "// Now, curSize is " + curSize);          outputTA.setText(outputTA.getText());        }        else        {          outputTA.append("\nChecked the size of the queue, and it has " +                           curSize + " elements");          outputTA.setText(outputTA.getText());        }      }    });        JButton isEmptyButton = new JButton("isEmpty");    isEmptyButton.setFont(new Font("Verdana", Font.PLAIN, 22));    isEmptyButton.setMnemonic(KeyEvent.VK_M);    isEmptyButton.addActionListener(new ActionListener() {
      /**       * Returns true if this queue is empty.       */      public void actionPerformed(ActionEvent e)      {        boolean empty = myQueue.isEmpty();                   if (showFunctions)        {          String msg = "Called: boolean empty = myQueue.isEmpty();  // Now, empty == ";          if (empty)          {            msg += "true";          }          else          {            msg += "false";          }                    outputTA.append("\n" + msg);          outputTA.setText(outputTA.getText());        }        else        {          String msg = "Checked if the queue was empty,";                    if (empty)          {            msg += " and it is empty";          }          else          {            msg += " and it is NOT empty";          }                    outputTA.append("\n" + msg);          outputTA.setText(outputTA.getText());        }      }    });        contentsTA = new JTextArea(12,20);    contentsTA.setFont(new Font("Verdana", Font.BOLD, 12));    contentsTA.setEditable(false);    contentsTA.setToolTipText("This area displays the current contents of the queue as " +                              "returned by the toString() function.");    contentsSP = new JScrollPane(contentsTA);        outputTA = new JTextArea(5,20);    outputTA.setText("Enter data into the queue to see a demonstration");    outputTA.setEditable(false);    outputTA.setFont(new Font("Verdana", Font.BOLD, 16));    outputTA.setForeground(logColor);    outputTA.setBackground(Color.WHITE);        outputSP = new JScrollPane(outputTA);    outputSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);        JPanel pane = new JPanel();        pane.setLayout(new BorderLayout());    JPanel leftPane = new JPanel();    leftPane.setLayout(new BorderLayout());              JPanel center = new JPanel();    center.setLayout(new GridLayout(3,1));    center.add(inputLbl);    center.add(inputTF);    center.add(sizeLbl);        leftPane.add("Center",center);        JPanel south = new JPanel();    south.setLayout(new GridLayout(3,2));    enQbutton.setToolTipText("Press this button to \"enqueue\" an Object onto the queue.");    south.add(enQbutton);    deQbutton.setToolTipText("Press this button to \"dequeue\" an Object from the queue.  " +                             "Objects are dequeued in First-In-First-Out order.");    south.add(deQbutton);    firstButton.setToolTipText("Press this button to look at the \"first\" Object in the " +                               "queue.  The first Object is returned and also remains first " +                               "in the queue.");    south.add(firstButton);    sizeButton.setToolTipText("Press this button to return the number of elements currently " +                              "contained within the queue.");    south.add(sizeButton);    isEmptyButton.setToolTipText("Press this button to check if the queue is empty.");    south.add(isEmptyButton);        leftPane.add("South", south);        JPanel north = new JPanel();    north.setLayout(new BorderLayout());    north.add("North", contentsLbl);    north.add("Center", contentsSP);             leftPane.add("North",north);    pane.add("West",leftPane);          drawPane = new DrawQueuePanel();    drawPaneSP = new JScrollPane(drawPane);                   pane.add("Center",drawPaneSP);    pane.add("South", outputSP);    return pane;  }    /**   * Creates and displays the main application window.   */  public void display()  {    try    {      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());    }    catch (Exception e) { }        /** create the top-level container and add contents to it */    Component contents = this.createComponents();    myFrame.getContentPane().add(contents, BorderLayout.CENTER);    /** listen for window closing */    myFrame.addWindowListener(new WindowAdapter()    {      public void windowClosing(WindowEvent e)      {        System.exit(0);      }    });        /** setup the menu bar at the top of the frame */    JMenuBar myMenuBar = new JMenuBar();    myFrame.setJMenuBar(myMenuBar);             JMenu optionsMenu = new JMenu("Options");    JMenu colorMenu = new JMenu("Color");        ButtonGroup colorGroup = new ButtonGroup();    JRadioButtonMenuItem selectColor = new JRadioButtonMenuItem("Show Color Display");    colorGroup.add(selectColor);    colorMenu.add(selectColor);    selectColor.setSelected(true);        /** makes changes when a different color is selected */    class ColorListener implements ActionListener {      public void actionPerformed(ActionEvent e)      {        if (e.getActionCommand().equals("Show Monochrome Display"))        {          /** change to black and white */          textColor = new Color(0,0,0);          nodeColor = new Color(0,0,0);          bgColor = new Color(255,255,255);          ptrColor = new Color(0,0,0);          valueColor = new Color(0,0,0);          objColor = new Color(0,0,0);          strColor = new Color(0,0,0);          drawPane.repaint();        }        else        {          /** change to color */          textColor = new Color(210,210,255);          nodeColor = new Color(1,110,218);          bgColor = new Color(47,47,63);          ptrColor = new Color(7,223,7);          valueColor = new Color(255,255,255);          objColor = Color.ORANGE;          strColor = Color.MAGENTA;          drawPane.repaint();        }      }    }        selectColor.addActionListener(new ColorListener());        JRadioButtonMenuItem selectMono = new JRadioButtonMenuItem("Show Monochrome Display");    colorGroup.add(selectMono);    colorMenu.add(selectMono);    selectMono.addActionListener(new ColorListener());    optionsMenu.add(colorMenu);    optionsMenu.addSeparator();        JCheckBoxMenuItem showCalls = new JCheckBoxMenuItem("Show ADT function calls?");    showCalls.setToolTipText("Check this box if you wish to see the function call " +                             "that is executed for each button.");        showCalls.addItemListener( new ItemListener() {      public void itemStateChanged(ItemEvent e)      {        if (e.getStateChange() == ItemEvent.SELECTED)        {          showFunctions = true; // enable display of function calls        }        else        {          showFunctions= false;        }      }    });        optionsMenu.add(showCalls);    myMenuBar.add(optionsMenu);        JMenu helpMenu = new JMenu("Help");    JMenuItem aboutMenuItem = new JMenuItem("About QueueDemo");    aboutMenuItem.addActionListener(new ActionListener() {      public void actionPerformed(ActionEvent e)      {        JOptionPane.showMessageDialog(myFrame,             "Queue Demonstration\n\nbeta3 - last modified 24.March.2005\n" +             "Karen McPherson\nkmcpherso@radford.edu",            "About QueueDemo", JOptionPane.PLAIN_MESSAGE);      }    });        helpMenu.add(aboutMenuItem);    myMenuBar.add(helpMenu);        myFrame.pack();    myFrame.setSize(800,650);          myFrame.setVisible(true);  }}
