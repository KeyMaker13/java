import java.util.*;

class TowerThread extends Thread {
	public TowerThread(int nDisks) {
		this.nDisks = nDisks;
		if (nDisks>9)
			nDisks = 9;
		towers = new String[4];
		towers[1] = "123456789".substring(0,nDisks);
		towers[2] = "";
		towers[3] = "";
	}
	public void registerAsObserver(TowerObserver observer) {
		observers.addElement(observer);
	}
	public void run() {
		amRunning = true;
		amStopped = false;
		solveIt(nDisks, 1, 3);
	}
	public void mySuspend() { amRunning = false;}
	public void myResume()  { amRunning = true;}
	public void myStop()    { amStopped = true;}
	private void delay(int n) {
		try {
			Thread.sleep(n);
		} catch(Exception e) {}
	}
	private void solveIt(int nDisks,int source,int target) {
		if (nDisks<=0)
			return;
		int holdingTower = getHoldingTower(source,target);
		solveIt(nDisks-1,source,holdingTower);
		if (amStopped)
			return;
		while (!amRunning)
			delay(80);
		updateModel(source,target);
		notifyObservers();
		solveIt(nDisks-1,holdingTower,target);
	}
	public int getFrom() {
		return from;
	}
	public int getTo() {
		return to;
	}
	public int getNDisks() {
		return nDisks;
	}
	public String getTower(int index) {
		return towers[index];
	}
	private int getHoldingTower(int source, int target) {
		if ((source == 2 && target == 3) || (source == 3 && target == 2))
			return 1;
		if ((source == 1 && target == 3) || (source == 3 && target == 1))
			return 2;
		return 3;                  
	}
	private void updateModel(int source, int target) {
		from = source;
		to = target;
		int fromLast = towers[from].length()-1;
		towers[to] = towers[to].concat(towers[from].substring(fromLast));
		towers[from] = towers[from].substring(0,fromLast);
	}
	private void notifyObservers() {
		TowerObserver to;
		for (int i=0; i < observers.size(); i++) {
			to = (TowerObserver) observers.elementAt(i);
			to.towerHasChanged(this);
		}
	}
	private boolean amRunning, amStopped;
	private int nDisks;
	private String[] towers;
	private int from,to;
	private Vector observers = new Vector();
}
