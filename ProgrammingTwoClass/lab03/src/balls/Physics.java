package balls;

import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Physics extends Thread {

	private ArrayList<Ball> balls;
	private Component parent;
	private Component boundary;
	private long lastTime;
	private long sleepTime;
	private boolean done;
	
	public Physics(Component parent, Component boundary, int framesPerSecond) {
		this.parent = parent;
		this.boundary = boundary;
		sleepTime = 1000 / framesPerSecond;
		lastTime = System.currentTimeMillis();
		balls = new ArrayList<Ball>();
		done = false;
		start();
	}

	public synchronized void stopIt() {
		done = true;
	}

	private synchronized boolean getDone() {
		return done;
	}

	public synchronized void addBall(Ball ball) {
		balls.add(ball);
	}

	private synchronized void handleBalls() {
		long currentTime;
		currentTime = System.currentTimeMillis();
		for (int i = 0; i < balls.size(); i++)
			setBallPosition(currentTime - lastTime, balls.get(i));
		for (int i = 0; i < balls.size(); i++)
			for (int j = i + 1; j < balls.size(); j++)
				if (balls.get(i).intersectsBall(balls.get(j))) {
					balls.get(i).setCollided();
					balls.get(j).setCollided();
				}
		lastTime = currentTime;
	}

	private void setBallPosition(long timeDiff, Ball ball) {
		double deltaTime = timeDiff / 1000.0;
		double oldX = ball.getX();
		double oldY = ball.getY();
		double radius = ball.getRadius();
		double velocityX = ball.getVelocityX();
		double velocityY = ball.getVelocityY();
		double newX = oldX + velocityX * deltaTime;
		double newY = oldY + velocityY * deltaTime;
		Rectangle bounds = boundary.getBounds();
		ball.setX(newX);
		ball.setY(newY);
		if (newX - radius <= 0) {
			newX = 2 * radius - newX;
			ball.setVelocityX(Math.abs(velocityX));
		}
		if (newX + radius >= bounds.width) {
			newX = 2 * (bounds.width - radius) - newX;
			ball.setVelocityX(-Math.abs(velocityX));
		}
		if (newY - radius <= 0) {
			newY = 2 * radius - newY;
			ball.setVelocityY(Math.abs(velocityY));
		}
		if (newY + radius >= bounds.height) {
			newY = 2 * (bounds.height - radius) - newY;
			ball.setVelocityY(-Math.abs(velocityY));
		}
	}
	
	public void run() {
		while (!getDone()) {
			handleBalls();
			parent.repaint();
			try {
				sleep(sleepTime);
			} catch (InterruptedException e) {
			}
		}
	}


}
