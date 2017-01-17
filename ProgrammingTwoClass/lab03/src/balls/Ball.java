/**
 * 
 */
package balls;

import java.awt.Color;
import java.awt.Graphics;
/**
 * @author Ivan Capistran
 *
 */
public class Ball {
	//ball
	private double x;
	private double y;
	private double radius;
	java.awt.Color color;
	// Part II
	private double velocityX;
	private double velocityY;
	/**
	 * 
	 */
	public Ball(double x, double y, double radius) {
		//make the private values available
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = Color.green;
		this.velocityX=0;
		this.velocityY=0;
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}
	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}
	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
	/**
	 * @return the color
	 */
	public java.awt.Color getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(java.awt.Color color) {
		this.color = color;
	}
	/**
	 * @return the velocityX
	 */
	public double getVelocityX() {
		return velocityX;
	}
	/**
	 * @param velocityX the velocityX to set
	 */
	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}
	/**
	 * @return the velocityY
	 */
	public double getVelocityY() {
		return velocityY;
	}
	/**
	 * @param velocityY the velocityY to set
	 */
	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}
	public void draw(Graphics g){
		g.setColor(this.color);
		g.fillOval((int) Math.round(x-radius)
				, (int) Math.round (y-radius)
				, (int) Math.round(radius*2)
				, (int) Math.round(radius*2));
	}
	public boolean intersectsBall(Ball b){
		double d = Math.sqrt(Math.pow(b.getX()-this.getX(),2) + Math.pow(b.getY()-this.getY(),2));
		double r = (b.getRadius() + this.getRadius());
		if (d<r){
		return true;
		}
		return false;
	}
	public void setCollided(){
	setColor(Color.red);	
	}
	
}
