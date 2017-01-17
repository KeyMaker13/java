import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class WordProcessorApplet extends Applet 
implements ActionListener {
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
		Panel labelPosition = new Panel();
		labelPosition.setLayout(new BorderLayout());
		labelPosition.add("North",  new Label("Text Position",Label.CENTER));
		labelPosition.add("South",position);
		
		singleButton = new Button("1");
		oneAndHalfButton = new Button("1.5");
		doubleButton = new Button("2");
		Panel lineSpacing = new Panel();
		lineSpacing.add(singleButton);
		lineSpacing.add(oneAndHalfButton);
		lineSpacing.add(doubleButton);
		Panel labelSpacing = new Panel();
		labelSpacing.setLayout(new BorderLayout());
		labelSpacing.add("North", new Label("Line Spacing",Label.CENTER));
		labelSpacing.add("South",lineSpacing);
		Panel textSize = new Panel();
		smallButton = new Button("Small");
		mediumButton = new Button("Medium");
		largeButton = new Button("Large");
		textSize.add(smallButton);
		textSize.add(mediumButton);
		textSize.add(largeButton);
		Panel labelTextSize = new Panel();
		labelTextSize.setLayout(new BorderLayout());
		labelTextSize.add("North",new Label("Text Size",Label.CENTER));
		labelTextSize.add("South",textSize);
		Panel marginValue = new Panel();
		marginValue.add(new Label("Width:"));
		marginSize = new TextField("0",8);
		marginValue.add(marginSize);
		Panel marginSet = new Panel();
		setLeftButton = new Button("Set Left");
		setRightButton = new Button("Set Right");
		marginSet.add(setLeftButton);
		marginSet.add(setRightButton);
		Panel margins = new Panel();
		margins.setLayout(new BorderLayout());
		margins.add("North",marginValue);
		margins.add("South",marginSet);
		Panel labelMargins = new Panel();
		labelMargins.setLayout(new BorderLayout());
		labelMargins.add("North",new Label("Margins",Label.CENTER));      
		labelMargins.add("South",margins);
		Panel controls = new Panel();
		controls.add(labelPosition);
		controls.add(labelSpacing);
		controls.add(labelTextSize);
		controls.add(labelMargins);
		tc = new TextCanvas();
		add(controls);
		add(tc);
		
		leftButton.addActionListener(this); 
		centerButton.addActionListener(this);
		rightButton.addActionListener(this); 
		topButton.addActionListener(this);
		middleButton.addActionListener(this);
		bottomButton.addActionListener(this); 
		singleButton.addActionListener(this);
		oneAndHalfButton.addActionListener(this);
		doubleButton.addActionListener(this);
		smallButton.addActionListener(this);
		mediumButton.addActionListener(this);
		largeButton.addActionListener(this);
		setLeftButton.addActionListener(this);
		setRightButton.addActionListener(this);
		
	}
	public void start() {  
		setSize(14*middleButton.getWidth(),20*middleButton.getHeight());
		tc.setSize(getWidth()-20, 15*middleButton.getHeight());
	}
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		
		if (source.equals("Left"))  
			tc.setHorizJust(TextCanvas.LEFT);
		else if (source.equals("Center"))
			tc.setHorizJust(TextCanvas.CENTER);
		else if (source.equals("Right"))
			tc.setHorizJust(TextCanvas.RIGHT);
		else if (source.equals("Top"))
			tc.setVertJust(TextCanvas.TOP);
		else if (source.equals("Middle"))
			tc.setVertJust(TextCanvas.MIDDLE);
		else if (source.equals("Bottom"))
			tc.setVertJust(TextCanvas.BOTTOM);
		else if (source.equals("1"))
			tc.setSpacing(1.0);
		else if (source.equals("1.5"))
			tc.setSpacing(1.5);
		else if (source.equals("2"))
			tc.setSpacing(2.0);
		else if (source.equals("Small"))
			tc.setTextSize(TextCanvas.SMALL);
		else if (source.equals("Medium"))
			tc.setTextSize(TextCanvas.MEDIUM);
		else if (source.equals("Large"))
			tc.setTextSize(TextCanvas.LARGE);
		else if (source.equals("Set Left"))
			tc.setLeftMargin(Integer.parseInt(marginSize.getText()));
		else if (source.equals("Set Right"))
			tc.setRightMargin(Integer.parseInt(marginSize.getText()));
	}
	private Button leftButton,centerButton,rightButton;
	private Button topButton,middleButton,bottomButton;
	private Button singleButton,oneAndHalfButton,doubleButton;
	private Button smallButton,mediumButton,largeButton;
	private Button setLeftButton,setRightButton;
	private TextField marginSize;
	private TextCanvas tc;
}

class TextCanvas extends Canvas  {
	public void paint(Graphics g) {
		String line1 = "We want more schoolhouses and fewer jails,";
		String line2 = "more books and fewer arsenals,";
		String line3 = "more justice and less revenge.";
		int myWidth = getWidth();
		int myHeight = getHeight(); 
		Font f = new Font("Dialog", Font.PLAIN, textSize); 
		g.setFont(f);
		FontMetrics fm = g.getFontMetrics();
		int lineHeight = fm.getHeight();     
		int ascent= fm.getAscent();
		int l1Width = fm.stringWidth(line1);
		int l2Width = fm.stringWidth(line2);
		int l3Width = fm.stringWidth(line3);
		int interLineSpace = (int) (lineHeight*(lineSpacing-1.0));
		int writeAreaWidth = myWidth - leftMargin - rightMargin;
		int vertMargin; 
		int l1Margin,l2Margin,l3Margin;   
		if (horiz == LEFT) 
			l1Margin = l2Margin = l3Margin = leftMargin;
		else if (horiz == CENTER) {
			l1Margin = (writeAreaWidth - l1Width) / 2 + leftMargin;
			l2Margin = (writeAreaWidth - l2Width) / 2 + leftMargin;
			l3Margin = (writeAreaWidth - l3Width) / 2 + leftMargin;
		}
		else {
			l1Margin = writeAreaWidth - l1Width + leftMargin;
			l2Margin = writeAreaWidth - l2Width + leftMargin;
			l3Margin = writeAreaWidth - l3Width + leftMargin; 
		}
		int textHeight = 3*lineHeight + 2*interLineSpace;
		if (vert == TOP)
			vertMargin = 0;
		else if (vert == MIDDLE)
			vertMargin = (myHeight - textHeight) / 2;
		else 
			vertMargin = myHeight - textHeight;
		int vertPos = vertMargin + ascent;
		setBackground(new Color(190,190,190));
		
		g.drawString(line1,l1Margin,vertPos);
		g.drawString(line2,l2Margin, vertPos+lineHeight+interLineSpace);
		g.drawString(line3,l3Margin, vertPos+2*(lineHeight+interLineSpace));
	}
	public void setHorizJust(int j) {  
		horiz = j;   
		repaint();   
	}
	public void setVertJust(int j) {
		vert = j;
		repaint();
	}
	
	public void setSpacing(double s) {
		lineSpacing = s;
		repaint();
	}
	public void setTextSize(int s) {
		textSize = s;
		repaint();
	}
	public void setLeftMargin(int m) {
		leftMargin = m;
		repaint();
	}
	public void setRightMargin(int m) {
		rightMargin = m;
		repaint();
	}
	private int horiz = TextCanvas.LEFT;
	private int vert = TextCanvas.TOP;
	private int leftMargin=0, rightMargin=0;
	private double lineSpacing = 1.0;
	private int textSize = TextCanvas.MEDIUM;
	public static final int LEFT = 0;
	public static final int CENTER = 1;
	public static final int RIGHT = 2;
	public static final int TOP = 0;
	public static final int MIDDLE = 1;
	public static final int BOTTOM = 2;
	public static final int SMALL = 10;
	public static final int MEDIUM = 12;
	public static final int LARGE = 20;
}