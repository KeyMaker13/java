import java.awt.*; // Second attempt
import java.applet.*;
public class CenterCircleApplet extends Applet {
    public void paint(Graphics g) {
	int diameter = 50;
	int appletWidth = getSize().width;
	int appletHeight = getSize().height;
	int xMargin = (appletWidth - diameter) / 2;
	int yMargin = (appletHeight - diameter) / 2;
	g.drawOval(xMargin,yMargin,diameter,diameter);
    }
}
