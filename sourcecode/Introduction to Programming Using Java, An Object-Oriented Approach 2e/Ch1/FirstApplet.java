import java.awt.*; // Our first applet
import java.applet.*;
public class FirstApplet extends Applet {
    public void paint(Graphics g) {
	g.drawString("Welcome to Java.",
		     20,20);
    }
}
