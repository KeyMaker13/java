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
