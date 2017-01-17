package pr1;

import java.awt.*;

import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class SemiPongPanel extends JPanel implements BallHandler,
		MouseMotionListener {
	// made of all them static so the whole class can use and change these
	// attributes
	private static int width;
	private static int height;
	// private static Ball ball = new Ball(30, 40, 10);
	private static Ball[] ballArray = new Ball[20];
	private static int ballsFired;
	private static BallPhysics physics;
	private static int ballCounter = 0;
	private static int hitLeftWall = 0;
	private static int hitRightWall = 0;
	private static int activeBall = 0;
	private static final int radius = 10;
	private static final int bX = 50;
	private static final int bY = 100;
	private static int mYPosition;
	private static int x1 = 300;
	private static int x2 = 300;
	private static int score = 0;
	private static int collided = 0;
	private static int tickCounter = 0;

	public void mouseDragged(MouseEvent e) {
		return;
	}

	public void mouseMoved(MouseEvent e) {

		mYPosition = e.getY();

	}

	public SemiPongPanel(int cWidth, int cHeight) {
		width = cWidth;
		height = cHeight;

		// ball.setVelocityX(20);
		// ball.setVelocityY(40);

		// BallPhysics physics = new BallPhysics(this, this, 10);
		// physics.addBall(ball);

		physics = new BallPhysics(this, this, 10);
		addMouseMotionListener(this);

		// gave all the balls in the array their velocities and physics
		for (int i = 0; i < ballArray.length; i++) {
			ballArray[i] = new Ball(bX, bY, radius);
			ballArray[i].setVelocityX(randomRange(10.0, 100.0));
			ballArray[i].setVelocityY(randomRange(-100.0, 100.0));
			// physics.addBall(ballArray[i]);
			physics.setBallHandler(this);
			this.handleBall(ballArray[i]);

		}

		setPreferredSize(new Dimension(width, height));

	}

	public void paintComponent(Graphics g) {
		// So the ball will not leave a trail of color
		Rectangle bounds = getBounds();
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, bounds.width, bounds.height);
		// draw all 20 balls
		g.setColor(Color.red);
		g.drawOval(40, 90, radius * 2, radius * 2);

		for (int i = 0; i < ballArray.length; i++) {
			ballArray[i].draw(g);
		}
		int y1 = mYPosition;
		int y2 = mYPosition + 50;
		if (mYPosition + 50 > bounds.height) {
			y1 = bounds.height - 50;
		}
        // fills oval over ball and puts up strings to display
		g.setColor(Color.lightGray);
		g.fillOval(40, 90, radius * 2, radius * 2);
		g.setColor(Color.black);
		g.drawLine(x1, y1, x2, y2);
		g.drawString("Semi-Pong by Ivan Capistran", 10, 15);
		g.drawString("Balls remaining " + (20 - ballsFired), 10, 30);
		g.drawString("Balls to the left " + hitLeftWall, 10, 45);
		g.drawString("Balls to the right " + hitRightWall, 10, 60);
		g.drawString("Number of Collisions " + collided, 10, 75);
		g.drawString("Balls active " + activeBall, 10, 255);
		if (ballsFired == 20) {
			g.setColor(Color.red);
		}
		g.drawString("Score " + score, 10, 270);
		// ball.draw(g);

	}

	// create a random range of doubles
	private double randomRange(double low, double high) {
		Random rand = new Random();
		double value = rand.nextDouble() * high + low;
		return value;
	}

	@Override
	public void collided(Ball b1, Ball b2) {
		score++;
		collided++;
	}

	@Override
	public void handleBall(Ball b) {
		// Took a while to figure out but...
		// I figured it out only that when the line stabs the ball it acts funny
		double X = b.getX();
		double Y = b.getY();
		double radius = b.getRadius();
		double velocityX = b.getVelocityX();
		boolean xHit = false;
		boolean yHit = false;

		if (X > (x1-radius)) {
			xHit = true;
		}
		if (X > (x1 + radius)) {
			xHit = false;
		}
		if ((Y > (mYPosition +radius))
				&& (Y < ((mYPosition + 50)+ radius))) {
			yHit = true;

		}
		if ((Y > (mYPosition)- radius)
				&& (Y < ((mYPosition + 50) - radius))) {
			yHit = true;
		}
		if (xHit && yHit) {
			b.setVelocityX(-velocityX);
		}
	}

	@Override
	public void handleTick() {
		// System.out.println("Test");
		// chose 3 as the number instead so the balls fire just a little bit slower
		tickCounter++;
		if (tickCounter % 3 == 0) {
			if (ballCounter < 20) {
				physics.addBall(ballArray[ballCounter]);
				ballsFired++;
				ballCounter++;
				activeBall++;
			}
		}

	}

	@Override
	public void hitLeftWall(Ball b) {
		// easy if this method is used when physics is added to each ball
		// then counters will be either added or subtracted
		// and velocities of balls and their positions will be changed
		hitLeftWall++;
		activeBall--;
		score++;
		score++;
		b.setVelocityX(0);
		b.setVelocityY(0);
		b.setX(-10);
		b.setY(-10);

	}

	@Override
	public void hitRightWall(Ball b) {
		// easy if this method is used when physics is added to each ball
		// then counters will be either added or subtracted
		// and velocities of balls and their positions will be changed
		hitRightWall++;
		activeBall--;
		score--;
		b.setVelocityX(0);
		b.setVelocityY(0);
		b.setX(-10);
		b.setY(-10);

	}
}
