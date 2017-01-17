
import java.awt.*;

import javax.swing.JApplet;

public class DrawRectangle extends JApplet {
	
	
	
    // constructor 
	
	public void paint (Graphics g){
		
		Rectangle[] rect2 = new Rectangle[20];
		double length = 50;
		double width = 40;
		double increase = 0;
		int i;
		for (i=0;i<rect2.length;i++){
			rect2[i].setLength(length+increase);
			rect2[i].setWidth(width+increase);
			
			g.drawRect((int)(100-(increase/2)),(int)(100-(increase/2)),(int)rect2[i].getWidth(),(int)rect2[i].getLength());
			increase +=10;
		}
		
		//(int)rect2[i].getWidth() rect2[i].getLength())
		
	
		
		}


}	
	