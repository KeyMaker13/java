import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Different 'look-and-feel' packages
import com.sun.java.swing.plaf.windows.*;
import com.sun.java.swing.plaf.motif.*;
import javax.swing.plaf.metal.*;

public class MyJAppletLAndF extends JApplet implements ActionListener {
	public void init() {
		Container contentPane = getContentPane();

		defaultLookAndFeel = UIManager.getLookAndFeel();

		defaultButton = new JButton("Default");
		metalButton = new JButton("Metal");
		motifButton = new JButton("Motif");
		windowsButton = new JButton("Windows");

		// Create panel of sample components, some with borders
		JPanel components = new JPanel();
		JCheckBox checkBox = new JCheckBox("A CheckBox");
		components.add(checkBox);
		JTextField textField = new JTextField("A TextField");
		components.add(textField);

		// Create panel of buttons
		JPanel buttons = new JPanel();
		buttons.add(defaultButton);
		buttons.add(metalButton);
		buttons.add(motifButton);
		buttons.add(windowsButton);

		// Add the panels to the content pane
		contentPane.add("North", components);	
		contentPane.add("South", buttons);

		// Register with the buttons as a Listener
		defaultButton.addActionListener(this);
		metalButton.addActionListener(this);
		motifButton.addActionListener(this);
		windowsButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ev) {
		try {
			if (ev.getSource() == motifButton) 
				UIManager.setLookAndFeel(new MotifLookAndFeel());
			else if (ev.getSource() == windowsButton) 
				UIManager.setLookAndFeel(new WindowsLookAndFeel());
			else if (ev.getSource() == defaultButton) 
				UIManager.setLookAndFeel(defaultLookAndFeel);
			else 
				UIManager.setLookAndFeel(new MetalLookAndFeel());
			SwingUtilities.updateComponentTreeUI(this);
			validate();
		} catch (UnsupportedLookAndFeelException e) {
			System.out.println("UnsupportedLookAndFeelException");
		}
	}

	LookAndFeel defaultLookAndFeel;
	JButton defaultButton, metalButton, motifButton, windowsButton;
}