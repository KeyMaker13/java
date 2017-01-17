import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class TowerApplet extends Applet 
implements ActionListener {
	public void init() {
		setBackground(new Color(200,255,255));
		this.setLayout(new BorderLayout(20,2));
		td = new TowerAppletDisplay();
		add("Center",td);
		startButton = new Button("start");
		pauseButton = new Button("pause");
		Panel pb = new Panel();
		pb.setLayout(new BorderLayout(2,2));
		pb.add("North",startButton);
		pb.add("South",pauseButton);
		startButton.addActionListener(this);
		pauseButton.addActionListener(this);
		numDisks = new TextField(" 7");
		numDisks.setFont(new Font("Courier",Font.BOLD,10));
		Label numDisksLabel = new Label(
										"Number of disks:",Label.RIGHT);
		Label stepDelayLabel = new Label(
										 "Delay (millisecs):",Label.RIGHT);
		numDisksLabel.setFont(new Font("Courier",Font.BOLD,10));
		stepDelayLabel.setFont(new Font("Courier",Font.BOLD,10));
		Panel pn = new Panel();
		pn.setLayout(new BorderLayout(2,2));
		pn.add("East",numDisks);
		pn.add("West",numDisksLabel);
		stepDelay = new TextField("1000");
		stepDelay.addActionListener(this);
		stepDelay.setFont(new Font("Courier",Font.BOLD,10));
		Panel ps = new Panel();
		ps.setLayout(new BorderLayout(2,2));
		ps.add("East",stepDelay);
		ps.add("West",stepDelayLabel);
		Panel pp = new Panel();
		pp.setLayout(new BorderLayout(2,2));
		pp.add("North",pn);
		pp.add("South",ps);
		Panel p = new Panel();
		p.setLayout(new  FlowLayout(FlowLayout.CENTER,50,20));
		p.add(pb);
		p.add(pp);
		p.setBackground(new Color(255,200,200));
		add("South",p);
	}
	public void actionPerformed(ActionEvent ae) {
		String whichButton = ae.getActionCommand();
		if (whichButton.equals("start"))
			handleStart();
		else if (whichButton.equals("restart"))
			handleRestart();
		else if (whichButton.equals("pause"))
			handlePause();
		else if (whichButton.equals("resume"))
			handleResume();
		else
			handleKeyboard();
	}
	private void handleStart() {
		int nDisks = Integer.parseInt(
									  numDisks.getText().trim());
		handleKeyboard();
		towersTicker = new TowerThread(nDisks);
		td.replaceModel(towersTicker);
		towersTicker.start();
		startButton.setLabel("restart");
		pauseButton.setLabel("pause");
	}
	private void handleRestart() {
		towersTicker.myStop();
		handleStart();
	}
	private void handlePause() {
		towersTicker.mySuspend();
		pauseButton.setLabel("resume");
	}
	private void handleResume() {
		towersTicker.myResume();
		pauseButton.setLabel("pause");
	}
	private void handleKeyboard() {
		int sDelay = Integer.parseInt(
									  stepDelay.getText().trim());
		td.setDelay(sDelay);
	}
	private   Button startButton, pauseButton;
	private   TextField numDisks, stepDelay;
	private   TowerAppletDisplay td;
	private   TowerThread towersTicker = null;
}
