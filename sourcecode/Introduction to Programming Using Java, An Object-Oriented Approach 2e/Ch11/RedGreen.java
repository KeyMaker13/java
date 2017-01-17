import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class RedGreen extends Applet implements ActionListener{
	public void init() {
		setLayout(new BorderLayout(2,2));
		b = new Button("start");
		b.addActionListener(this);
		c = new Canvas();
		add("West",b);
		add("East",c);
		c.setSize(100,50);
	}
	public void paint(Graphics g) {
		Graphics gc = c.getGraphics();
		while (keepGoing) {
			gc.setColor(new Color(200,50,50));
			gc.fillRect(5,5,90,40);
			gc.setColor(new Color(50,200,50));
			gc.fillRect(5,5,90,40);
		}
	}
	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();
		if (s.equals("start"))
			handleStart();
		else if (s.equals("stop"))
			handleStop();
	}
	private void handleStart() {
		keepGoing = true;
		b.setLabel("stop");
	}
	private void handleStop() {
		keepGoing = false;
		b.setLabel("start");
	}
	private Button  b;
	private Canvas  c;
	private boolean keepGoing=false;
}       
