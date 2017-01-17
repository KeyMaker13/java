package hashing;

public class Counter {
	private int count;

	public Counter() {
		count = 0;
	}

	public void inc() {
		count++;
	}

	public void reset() {
		count = 0;
	}

	public String toString() {
		return "" + count;
	}

}
