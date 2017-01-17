import java.awt.*;
import java.applet.*;;

public class CounterAppletFinal extends Applet {
	public void init() {
		CounterMultiObserver ctr1 = new CounterMultiObserver();
		CounterLogger cl1 = new CounterLogger(ctr1,"Counter1");
		CounterPanel nPanel = new CounterPanel(ctr1);
		CounterPanel sPanel = new CounterPanel(ctr1);
		CounterMultiObserver ctr2 = new CounterMultiObserver();
		CounterLogger cl2 = new CounterLogger(ctr2,"Counter2");
		CounterPanel ePanel = new CounterPanel(ctr2);
		CounterPanel wPanel = new CounterPanel(ctr2);      
		setLayout(new BorderLayout());
		add(nPanel,"North");
		add(sPanel,"South");
		add(ePanel,"East");
		add(wPanel,"West");
	}
}
