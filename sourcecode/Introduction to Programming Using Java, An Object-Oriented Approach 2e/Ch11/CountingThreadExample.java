

public class CountingThreadExample {
	public static void main(String a[]) {
		CountingThread t1 = new CountingThread(2);
		CountingThread t2 = new CountingThread(3);
		t1.start();
		t2.start();
	}
}
