import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class TextJustifierApplet extends Applet  {
	public void init() {
		setBackground(new Color(255,255,255));
		Panel horiz = new Panel();
		leftButton = new Button("Left");
		centerButton = new Button("Center");
		rightButton = new Button("Right");
		horiz.add(leftButton);
		horiz.add(centerButton);              
		horiz.add(rightButton);
		Panel vert = new Panel();
		topButton = new Button("Top");
		middleButton = new Button("Middle");
		bottomButton = new Button("Bottom");
		vert.add(topButton);
		vert.add(middleButton);
		vert.add(bottomButton);              
		Panel position = new Panel();
		position.setLayout(new BorderLayout());
		position.add("North",horiz);
		position.add("South",vert);
		tc = new TextCanvas(leftButton,centerButton,rightButton,
							topButton,middleButton,bottomButton);
		add(position);
		add(tc);
		
		leftButton.addActionListener(tc);   
		centerButton.addActionListener(tc);
		rightButton.addActionListener(tc); 
		topButton.addActionListener(tc);
		middleButton.addActionListener(tc);
		bottomButton.addActionListener(tc);  
	}
	public void start() {   
		tc.setSize(getWidth()-20,
				   getHeight()-(4*leftButton.getHeight()));
	}
	private Button leftButton,centerButton,rightButton;
	private Button topButton,middleButton,bottomButton;
	private TextCanvas tc;
}

class TextCanvas extends Canvas implements ActionListener 
{
	public TextCanvas(Button l, Button c, Button r, 
					  Button t, Button m, Button b) {
		leftButton = l;
		centerButton = c;
		rightButton = r;
		topButton = t;
		middleButton = m;
		bottomButton = b;
	}
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == leftButton)               
			setHorizJust(TextCanvas.LEFT);
		else if (source == centerButton)
			setHorizJust(TextCanvas.CENTER);
		else if (source == rightButton)
			setHorizJust(TextCanvas.RIGHT);
		else if (source == topButton)
			setVertJust(TextCanvas.TOP);
		else if (source == middleButton)
			setVertJust(TextCanvas.MIDDLE);
		else if (source == bottomButton)
			setVertJust(TextCanvas.BOTTOM);
	}
	public void paint(Graphics g) {
		String line1 = "We want more schools and fewer jails,";  
		String line2 = "more books and fewer arsenals,";
		String line3 = "more justice and less revenge.";
		int myWidth = getWidth();
		int myHeight = getHeight();          
		FontMetrics fm = g.getFontMetrics();
		int lineHeight = fm.getHeight();     
		int ascent = fm.getAscent();
		int l1Width = fm.stringWidth(line1);
		int l2Width = fm.stringWidth(line2);
		int l3Width = fm.stringWidth(line3);
		int vertMargin;                      
		int l1Margin,l2Margin,l3Margin;      
		if (horiz == LEFT) 
			l1Margin = l2Margin = l3Margin = 0;
		else if (horiz == CENTER) {
			l1Margin = (myWidth - l1Width) / 2;
			l2Margin = (myWidth - l2Width) / 2;
			l3Margin = (myWidth - l3Width) / 2;
		}
		else {
			l1Margin = myWidth - l1Width;
			l2Margin = myWidth - l2Width;
			l3Margin = myWidth - l3Width; 
		}
		int textHeight = 3*lineHeight;
		if (vert == TOP)
			         vertMargin = 0;
		else if (vert == MIDDLE)
			vertMargin = (myHeight - textHeight) / 2;
		else 
			vertMargin = myHeight - textHeight;
		int vertPos = vertMargin+ascent;
		setBackground(new Color(190,190,190)); 
		g.drawString(line1,l1Margin,vertPos);   
		g.drawString(line2,l2Margin,vertPos+lineHeight);  
		g.drawString(line3,l3Margin,vertPos+2*lineHeight);
	}
	private void setHorizJust(int j) {  
		horiz = j;   
		repaint();   
	}
	private void setVertJust(int j) {
		vert = j;
		repaint();
	}
	
	private int horiz = TextCanvas.LEFT;
	private int vert = TextCanvas.TOP;
	public static final int LEFT = 0;
	public static final int CENTER = 1;
	public static final int RIGHT = 2;
	public static final int TOP = 0;
	public static final int MIDDLE = 1;
	public static final int BOTTOM = 2;
	private Button leftButton,centerButton,rightButton;
	private Button topButton,middleButton,bottomButton;
}
