import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class RedGreenWithThreads extends Applet 
implements ActionListener{
    public void init() {
        setLayout(new BorderLayout(2,2));
		b = new Button("start");
        b.addActionListener(this);
        c = new Canvas();
        add("West",b);
        add("East",c);
        c.setSize(100,50);
    }
    public void actionPerformed(ActionEvent ae) {
        String s = ae.getActionCommand();
        if (s.equals("start"))
			handleStart();
        else if (s.equals("resume"))
			handleResume();
        else if (s.equals("stop"))
			handleStop();
    }
    private void handleStart() {
        b.setLabel("stop");
        rgt = new RedGreenThread(c);
        rgt.start();
    }
    private void handleResume() {
        b.setLabel("stop");
        rgt.myResume();
    }
    private void handleStop() {
        b.setLabel("resume");
        rgt.mySuspend();
    }
    private Button          b;
    private Canvas          c;
    private RedGreenThread  rgt=null;
}
