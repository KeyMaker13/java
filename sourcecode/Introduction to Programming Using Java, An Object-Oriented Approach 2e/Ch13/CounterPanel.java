import java.awt.*;
import java.awt.event.*;

class CounterPanel extends Panel implements ActionListener,CounterObserver {
	public CounterPanel(CounterMultiObserver ctr) {
		incButton = new Button("+");
		resetButton = new Button("reset");
		valField = new TextField();
		Panel p = new Panel();
		p.setLayout(new BorderLayout());
		p.add(incButton, "North");
		p.add(resetButton, "South");
		add(p);
		add(valField);
		incButton.addActionListener(this);
		resetButton.addActionListener(this);
		this.ctr = ctr;
		ctr.registerAsObserver(this);
	}
	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();
		if (s.equals("+"))
			ctr.increment();
		else if (s.equals("reset"))
			ctr.reset();
		valField.setText(Integer.toString(ctr.getValue()));
	}
	public void counterHasChanged(CounterMultiObserver ctr) {
		valField.setText(Integer.toString(ctr.getValue()));
	}
	Button incButton, resetButton;  
	TextField valField;
	CounterMultiObserver ctr;
}

	