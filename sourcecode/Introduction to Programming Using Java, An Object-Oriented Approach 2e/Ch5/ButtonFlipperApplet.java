import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class ButtonFlipperApplet extends Applet implements ActionListener {
    public void init() {
	flipButton = new Button("flip");
	flipButton.addActionListener(this);
	this.add(flipButton);
    }
    public void paint(Graphics g) {
	if (red)
	    g.setColor(Color.red);
	else
	    g.setColor(Color.blue);
	g.fillRect(0,0,100,100);
    }
    public void actionPerformed(ActionEvent e) {
	red = !red;
	this.repaint();
    }
    private Button flipButton;
    private boolean red=true;
}
