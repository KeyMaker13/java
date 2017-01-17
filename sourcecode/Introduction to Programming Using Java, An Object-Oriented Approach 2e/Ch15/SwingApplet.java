import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

// Accesses the two icons
import javax.swing.plaf.metal.MetalIconFactory.*;	

public class SwingApplet extends JApplet {
	public void init() {
		JTabbedPane tp = new JTabbedPane();
		getContentPane().add("Center", tp);

		JPanel buttons = new JPanel();
		tp.addTab("Buttons", buttons);

		JButton b1 = new JButton("New Document");
		b1.setIcon(new FileIcon16());
		buttons.add(b1);
		JButton b2 = new JButton("New Folder");
		b2.setIcon(new FolderIcon16());
		buttons.add(b2);

		JPanel texts = new JPanel();
		tp.addTab("Text", texts);

		JTextArea textArea = new JTextArea(10, 20);
		textArea.setBorder(new TitledBorder("A Multi-Line Text Area"));
		b2.setIcon(new FolderIcon16());
		texts.add(textArea);
		JTextField textField = new JTextField(20);
		textField.setBorder(new LineBorder(Color.red, 2));
		textField.setToolTipText("Enter a single line of text here");
		texts.add(textField);
	}

}
