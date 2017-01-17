package craps;

import java.awt.*;
import javax.swing.*;

public class DiceApplet
    extends JApplet {
  boolean isStandalone = false;
  BorderLayout borderLayout1 = new BorderLayout();
  


  private DiceDrawer draw;
  //Get a parameter value
  public String getParameter(String key, String def) {
    return isStandalone ? System.getProperty(key, def) :
        (getParameter(key) != null ? getParameter(key) : def);
  }

  //Construct the applet
  public DiceApplet() {
	 // draw = new DiceDrawer();
  }

  //Initialize the applet
  public void init() {
    try {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  //Component initialization
  private void jbInit() throws Exception {
    this.setSize(new Dimension(400, 300));
    this.getContentPane().setLayout(borderLayout1);
  }

  //Get Applet information
  public String getAppletInfo() {
    return "Applet Information";
  }

  //Get parameter info
  public String[][] getParameterInfo() {
    return null;
  }

  //static initializer for setting look & feel
  static {
    try {
      //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    }
    catch (Exception e) {
    	
    }
  }
  
  public void paint(Graphics g){
	  //draw(g,20,20,2);
	 
	  
  }
  
  /**
   * Draw an individual die at the given location in our
   * coordinate system.
   * 
   * @param g this is the graphics object to which we draw
   * @param x the x location for the upper left corner of the die
   * @param y the y location for the upper corner of the die
   * @param value the pip value to display on the die
   */
  private void draw(Graphics g, int x, int y, int value) {
	     Graphics gTemp = g.create();
	     gTemp.translate(x, y);
	     draw.drawDiceFace(gTemp, value);
	     gTemp.dispose();
	  }
}//end applet

