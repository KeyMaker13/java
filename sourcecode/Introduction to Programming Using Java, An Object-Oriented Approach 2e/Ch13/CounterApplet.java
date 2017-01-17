import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class CounterApplet extends Applet 
implements ActionListener {
	public void init() {
		incButton = new Button("+");
		resetButton = new Button("reset");
		valField = new TextField();
		valField.setText(Integer.toString(ctr.getValue()));
		Panel p = new Panel();
		p.setLayout(new BorderLayout());
		p.add(incButton, "North");
		p.add(resetButton, "South");
		add(p);
		add(valField);
		ctr = new Counter();
		incButton.addActionListener(this);
		resetButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();
		if (s.equals("+"))
			ctr.increment();
		else if (s.equals("reset"))
			ctr.reset();
		valField.setText(Integer.toString(ctr.getValue()));
	}
	Button incButton, resetButton;  // Instance variables
	TextField valField;
	Counter ctr;
}

class Counter {
    public void reset() {
        count = 0;
    }
    public void increment() {
        count = count + 1;
	}
    public int getValue() {
        return count;
    }
    private int count = 0;
}
