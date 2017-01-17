import java.awt.*;
import java.applet.*;
public class FlipperApplet extends Applet {
    public void paint(Graphics g) {
	if (red) // should I draw in red?
	    g.setColor(Color.red);
	else
	    g.setColor(Color.blue);
	g.fillRect(0,0,100,100);
	if (red) // flip value of red
	    red = false;
	else
	    red = true;
    }
    private boolean red=true; // start with red
}
