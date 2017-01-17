package pr3;

import java.awt.Color;
import java.awt.Graphics;

public class Graph {
	
	
	protected int[] tempArray;
	public Color color;
	
	
	public Graph(int[] y, Color c){
		tempArray = y;
		color = c;

	}
	
	public Graphics draw (Graphics g, int height, int xScale, int yScale, int xOffSet, int yOffSet ){
		
		
		int[] list = new int[tempArray.length];
		
		int placement = (height - yOffSet-100);
		int moveX =0;
		
		for (int i = 0; i < list.length; i++){
			list[i] = graphPoint(tempArray[i]);
		}
		
		for (int i = 0; i <list.length; i++)
		{
			if(list[i]!= 0)
			{
			drawDot(g,xOffSet + moveX,placement - list[i]);
			
			if (i<list.length-1 && list[i+1]!= 0){
			drawDot(g,xOffSet + moveX + xScale, placement - list[i+1]);
			g.drawLine(xOffSet + moveX, placement - list[i], xOffSet + moveX + xScale, placement - list[i+1]);
			}
			}
			moveX += xScale;
		}
		
		/*
		for (int i = 0; i< tempArray.length; i++){
		
			moveX += xScale;
		int pointA = graphPoint(tempArray[i]);
		int pointB = pointA;
		if(pointA != 0)
		{
			drawDot(g,xOffSet + moveX,placement - pointA );
			if (i != tempArray.length-1){
				pointB = graphPoint(tempArray[i+1]);
				if(pointB !=0)
				g.drawLine(xOffSet + moveX,placement -pointA+2 , xOffSet + moveX + xScale,placement- pointB+2);
			}
		}
		}
		
		*/
		return g;
	}
	
	public void drawDot(Graphics g, int x, int y){
		
		g.setColor(color);
		g.fillOval(x-2, y-1,7,7);
	}
	
	public int graphPoint (int x){
		int v = x;
		
		if (v> 0 && v<=9 ){
			int r = v;
			r = (r*50)/10;
			r = r - 100;
			return r;
		}
		if (v>= 10 && v<=19 ){
			int r = v%10;
			r = (r*50)/10;
			r = r- 50;
			return r;
		}
		if (v>= 20 && v<=29 ){
			int r = v%20;
			r = (r*50)/10;
			r += 0;
			return r;
		}
		if (v>= 30 && v<=39 ){
			int r = v%30;
			r = (r*50)/10;
			r += 50;
			return r;
		}
		if (v>= 40 && v<=49 ){
			int r = v%40;
			r = (r*50)/10;
			r += 100;
			return r;
		}
		if (v>= 50 && v<=59 ){
			
			int r = v%50;
			r = (r*50)/10;
			r += 150;
			
			return r;
		}
		if (v>= 60 && v<=69 ){
			int r = v%60;
			r = (r*50)/10;
			r += 200;
			
			return r;
		}
		if (v>= 70 && v<=79 ){
			int r = v%70;
			r = (r*50)/10;
			r += 250;
			return r;
		}
		if (v>= 80 && v<=89 ){
			int r = v%80;
			r = (r*50)/10;
			r += 300;
			return r;
		}
		if (v>= 90 && v<=99 ){
			int r = v%90;
			r = (r*50)/10;
			r += 350;
			return r;
		}
		if (v>= 100 && v<=109 ){
			int r = v%100;
			r = (r*50)/10;
			r += 400;
			return r;
		}
		if (v == Integer.MIN_VALUE)
		return 0;
		else
			return 0;
	}
	

}
