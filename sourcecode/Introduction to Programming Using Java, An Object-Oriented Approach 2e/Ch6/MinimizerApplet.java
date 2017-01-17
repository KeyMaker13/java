import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class MinimizerApplet extends Applet implements ActionListener {
    public void init() {
	add(new Label("Value:"));
	valueField = new TextField(30);
	add(valueField);
	minButton = new Button("Minimize!");
	add(minButton);
	minButton.addActionListener(this);
	resultLabel = new Label("Minimum value is ");
	add(resultLabel);
	m = new Minimizer();
    }
    public void actionPerformed(ActionEvent ae) {
	String valString = valueField.getText();
	long val = Long.parseLong(valString);
	m.check(val);
	long min = m.get();
	resultLabel.setText("Minimum value is "+min);
	validate();
      
    }
    private TextField valueField;
    private Button minButton;
    private Label resultLabel;
    private Minimizer m;
}
