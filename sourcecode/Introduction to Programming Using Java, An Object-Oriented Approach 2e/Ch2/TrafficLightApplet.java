import java.awt.*;
import java.applet.*;
public class TrafficLightApplet extends Applet {
    public void paint(Graphics g) {
	int appletWidth = getSize().width;
	int appletHeight = getSize().height;
	int boxWidth;
	if (appletWidth/5 < appletHeight/3)
	    boxWidth = appletWidth/5;
	else
	    boxWidth = appletHeight/3;

	int boxHeight = boxWidth * 3;
	int xMargin = (appletWidth - boxWidth) / 2;
	int yMargin = (appletHeight - boxHeight) / 2 ;
	g.drawRect(xMargin,yMargin,boxWidth,boxHeight);

	int diameter = 3*boxWidth/4;
	int slotSize = boxWidth;
	int slotMargin = (slotSize - diameter) / 2;
	int lightXCoord = xMargin+slotMargin;
	g.setColor(Color.red); // set color of top light
	g.fillOval(lightXCoord, // x coordinate of all lights
		   yMargin+slotMargin, // y coordinate of top light
		   diameter,diameter); // dimensions of all lights
       
	g.setColor(Color.yellow); // set color of middle light
	g.fillOval(lightXCoord,
		   yMargin+slotMargin+slotSize, // y coordinate
		   diameter,diameter);

	g.setColor(Color.green); // set color of bottom light
	g.fillOval(lightXCoord,
		   yMargin+slotMargin+2*slotSize, // y coordinate
		   diameter,diameter);
    }
}
