/**
 * 
 */
package balls;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JApplet;
/**
 * @author Ivan Capistran
 *
 */
public class BallsApplet extends JApplet {

	Physics physics = new Physics(this,this,10);
	private Ball[] ballArray;
	/**
	 * @throws HeadlessException
	 */
	public BallsApplet() throws HeadlessException {
	}
	public void init() {
		ballArray = new Ball[20];
		this.setSize(400,500);
		//instantiate  my objects for this applet
		
		//Physics physics = new Physics(this,this,10);
		
		//create the ball objects
		int i = 0;
		for(i=0; i<ballArray.length; i++){
			ballArray[i]=makeRandomBall();
			physics.addBall(ballArray[i]);
		}
	}
	public void paint(Graphics g){
		//first, erase all background
		 Rectangle bounds = getBounds();
		    g.setColor(Color.lightGray);
		    g.fillRect(0,0,bounds.width,bounds.height);
		    g.drawString("Lab 03 created by Ivan Capistran",0,0);
		int count = 0;
		for (int i = 0; i<ballArray.length;i++)
		{
		ballArray[i].draw(g);
		if (ballArray[i].getColor().equals(Color.red)){
			count++;
		}
		if (count == ballArray.length){
			physics.stopIt();
		}
		}
		g.drawString("Number of red balls " +convertInteger(count), 13, 50);
		g.drawString("Number of green balls " + convertInteger(ballArray.length-count), 13, 60);	
		g.drawString("Lab 03 created by Ivan Capistran",13,40);
	    }
	private Ball makeRandomBall(){
		Ball ball = new Ball(randomRange(20,200),randomRange(20,200),randomRange(2,10));
		ball.setColor(Color.green);
		ball.setVelocityX(randomRange(-40,40));
		ball.setVelocityY(randomRange(-40,40));
        //create the ball objects
		return ball;
	}
	private int randomRange(int low, int high){
		Random rand = new Random();
		int value = rand.nextInt(high-low +1)+low;
		return value;
	}
	public static String convertInteger(int i) {
	    return Integer.toString(i);
	}
}

