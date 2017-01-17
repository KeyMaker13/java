package pr3;

import java.awt.Color;

public class Key {
	
	protected int xValue;
	protected int yValue;
	String labelValue;
	Color colorValue;
	
	public Key(int x, int y, String label, Color c){
		xValue =x;
		yValue = y;
		labelValue = label;
		colorValue = c;
		
	}
	public int getX(){
		return xValue;
	}
	public int getY(){
		return yValue;
	}
	public String getLabel(){
		return labelValue;
	}
	public Color getColor(){
		return colorValue;
	}
	public int getLength(){
		return xValue;
	}
	
	
	

}
