

class DoNothingThreadExample {
	public static void main(String[] a) {
		Thread t1 = new Thread();
		Thread t2 = new Thread();
		t1.start();
		t2.start();
	}
}
