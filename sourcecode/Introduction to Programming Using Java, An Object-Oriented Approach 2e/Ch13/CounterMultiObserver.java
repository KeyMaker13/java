import java.util.*;

class CounterMultiObserver {
    public void reset() {
        count = 0;
		notifyObservers();
    }
    public void increment() {
        count = count + 1;
		notifyObservers();
	}
	public int getValue() {
		return count;
	}

	public void registerAsObserver(CounterObserver co) {
		observers.addElement(co);
		co.counterHasChanged(this);
	}
	public void notifyObservers() {
		CounterObserver co;
		for (int i=0; i < observers.size(); i++) {
			co = (CounterObserver) observers.elementAt(i);
			co.counterHasChanged(this);
		}
	}

	private Vector observers = new Vector();
	private int count = 0;
}
