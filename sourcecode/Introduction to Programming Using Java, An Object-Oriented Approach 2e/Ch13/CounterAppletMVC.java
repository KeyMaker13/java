import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class CounterAppletMVC extends Applet implements ActionListener, CounterObserver {
	public void init() {
		incButton = new Button("+");
		resetButton = new Button("reset");
		valField = new TextField();
		Panel p = new Panel();
		p.setLayout(new BorderLayout());
		p.add(incButton, "North");
		p.add(resetButton, "South");
		add(p);
		add(valField);
		ctr = new Counter();
		ctr.registerAsObserver(this);
		incButton.addActionListener(this);
		resetButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();
		if (s.equals("+"))
			ctr.increment();
		else if (s.equals("reset"))
			ctr.reset();
	}
	public void counterHasChanged(Counter ctr) {
		valField.setText(Integer.toString(ctr.getValue()));
	}
	Button incButton, resetButton;  // Instance variables
	TextField valField;
	Counter ctr;
}
