import java.awt.*;

class RedGreenThread extends Thread {
    RedGreenThread(Canvas c) {
        this.c = c;
    }
	
	public void run() {
        Graphics gc = c.getGraphics();
        amRunning = true;
        while (true)
			if (amRunning) {
				gc.setColor(new Color(200,50,50));
				gc.fillRect(5,5,90,40);
				try {
					sleep(50);
				} catch(Exception e) {}
				gc.setColor(new Color(50,200,50));
				gc.fillRect(5,5,90,40);
				try {
					sleep(50);
				} catch(Exception e) {}
			}
    }
		public void mySuspend() {
			amRunning=false;
		}
		public void myResume() {
			amRunning=true;
		}
		private Canvas c;
		private boolean amRunning=false;
}

