import java.awt.*;
import java.applet.*;
public class BouncingBallApplet extends Applet {
    public void paint (Graphics g) {
	int myWidth = getSize().width;
	int myHeight = getSize().height;
	int yPos = myHeight/2;
	int diameter = 10;
	g.fillOval(xPos,yPos,diameter,diameter);
	if (xPos > myWidth)
	    xVelocity = -xVelocity;
	if (xPos < 0)
	    xVelocity = -xVelocity;
	xPos = xPos + xVelocity;
	counter = counter + 1;
	if (counter < 2000)
	    repaint();
	else
	    stop();
    }
    private int xPos = 0;
    private int xVelocity = 5;
    private int counter = 0;
}
