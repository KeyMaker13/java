class Counter {
    public void reset() {
        count = 0;
		notifyObserver();
    }
    public void increment() {
        count = count + 1;
		notifyObserver();
	}
	public int getValue() {
		return count;
	}
	public void registerAsObserver(CounterObserver co) {
		observer = co;
		notifyObserver();
	}
	
	private void notifyObserver() {
		observer.counterHasChanged(this);
	}	
	private CounterObserver observer;
	private int count = 0;
}
