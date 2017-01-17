import java.awt.*;
import java.applet.*;
public class CenterTextApplet extends Applet {
    public void paint(Graphics g) {
	int appletWidth = getSize().width;
	int appletHeight = getSize().height;
	String s = "X marks the spot";
	FontMetrics fm = g.getFontMetrics();
	int textWidth = fm.stringWidth(s);
	int textHeight = fm.getHeight();
	int xMargin = (appletWidth - textWidth) / 2;
	int yMargin = (appletHeight - textHeight) / 2;
	g.drawString(s,xMargin,yMargin+textHeight);
    }
}
