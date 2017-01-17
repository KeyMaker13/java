import java.awt.*;				// AWT classes ...
import java.awt.event.*;		//	... and events
import java.applet.*;			// Applet-related classes

public class PushApplet extends Applet implements ActionListener {
	public void init() {
		theButton = new Button("Push Me!");
		add(theButton);

		theButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		theButton.setLabel("Ouch!");
	}

	Button theButton;
}
