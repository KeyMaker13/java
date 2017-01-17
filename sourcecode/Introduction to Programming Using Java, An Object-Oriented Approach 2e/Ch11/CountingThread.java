
class CountingThread extends Thread {
	public CountingThread(int x) {
		this.x = x;
	}
	public void run() {
		int i=0;
		while (i<15) {
			System.out.println(i);
			i+=x;
		}
	}
	private int x;
}
