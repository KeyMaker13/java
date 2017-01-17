import java.awt.*;				// Still use some AWT stuff (e.g., Container)
import java.awt.event.*;		//	and events
import javax.swing.*;			// For Swing controls and JApplet

public class PushJApplet extends JApplet implements ActionListener {
	public void init() {
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		theButton = new JButton("Push Me!");
		contentPane.add(theButton);

		theButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		theButton.setText("Ouch!");
	}

	JButton theButton;
}
