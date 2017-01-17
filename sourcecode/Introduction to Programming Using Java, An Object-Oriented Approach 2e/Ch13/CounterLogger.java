class CounterLogger implements CounterObserver {
	public CounterLogger(CounterMultiObserver ctr, String counterName) {
		this.counterName = counterName;
		ctr.registerAsObserver(this);
	}
	public void counterHasChanged(CounterMultiObserver ctr) {
		System.out.print(counterName+" changed to ");
		System.out.println(ctr.getValue());
	}
	private String counterName;
}
