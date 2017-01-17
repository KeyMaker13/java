import java.awt.*;

class TowerAppletDisplay extends Canvas implements TowerObserver{
	public TowerAppletDisplay() {
		c = new Color[10];
		c[0] = new Color(255,0,0);
		c[1] = new Color(0,255,0);
		c[2] = new Color(0,0,255);
		c[3] = new Color(255,255,0);
		c[4] = new Color(255,0,255);
		c[5] = new Color(0,255,255);
		c[6] = new Color(44,150,44);
		c[7] = new Color(44,44,150);
		c[8] = new Color(150,150,44);
		c[9] = new Color(150,44,150);
	}
	public void replaceModel(TowerThread t) {
		nDisks = t.getNDisks();
		myWidth = this.getWidth() - 2*borderSize;
		myHeight = this.getHeight() - 2*borderSize;
		diskWidth = myWidth / 4;
		smallestDiskWidth = diskWidth / nDisks;
		interDiskWidth = diskWidth / 4;
		diskHeight = 10;
		towerHeight = (nDisks+1) * diskHeight;
		lineLeft = borderSize + interDiskWidth;
		lineBot  = myHeight - (myHeight-towerHeight)/2;
		lineWidth = 3*diskWidth + 2*interDiskWidth;
		lineRight = lineLeft+lineWidth;
		towerLeft = new int[4];
		towerLeft[1] = lineLeft + diskWidth/2;
		towerLeft[2] = towerLeft[1] + diskWidth/2 + interDiskWidth + diskWidth/2;
		towerLeft[3] = towerLeft[2] + diskWidth/2 + interDiskWidth + diskWidth/2;
		t.registerAsObserver(this);
		tower = t;
		paint(this.getGraphics());
		delay(1000);
	}
	public void setDelay(int d) {
		sdelay = d;
	}
	public void towerHasChanged(TowerThread t) {
		int from = t.getFrom();
		int to = t.getTo();
		String toTower = t.getTower(to);
		int toLast = toTower.length()-1;
		Color   c = getDiskColor(to,toLast);
		Graphics g = this.getGraphics();
		paintLowerBackground(g);
		g.setColor(c);
		g.setFont(new Font("Helvetica",Font.BOLD,18));
		g.drawString("Move from " + from + " to " + to, lineLeft,
					 myHeight - (myHeight-towerHeight)/4);
		delay(sdelay);
		tower = t;
		paint(g);
		delay(sdelay/3);
	}
	public void paint(Graphics g) {
		paintBackground(g);
		paintBorder(g);
		g.setColor(new Color(0,0,0));
		if (tower==null)
			return;
		g.drawLine(lineLeft,lineBot,lineRight,lineBot);
		paintTower(g,1);
		paintTower(g,2);
		paintTower(g,3);
	}
	private void paintTower(Graphics g, int whichTower) {
		int j;
		String s = tower.getTower(whichTower);
		g.setColor(new Color(0,0,0));
		g.drawLine(towerLeft[whichTower],lineBot,towerLeft[whichTower],lineBot-towerHeight);
		for (int i=0;i<s.length();i++) {
			j = nDisks-Integer.parseInt(s.substring(i, i+1));
			g.setColor(getDiskColor(whichTower,i));
			int jWidth = (1+j)*smallestDiskWidth;
			int jLeft = towerLeft[whichTower]-jWidth/2;
			int jBot = lineBot - diskHeight - i*diskHeight;
			g.fill3DRect(jLeft,jBot,jWidth,diskHeight,true);
		}
	}
	private void paintLowerBackground(Graphics g) {
		g.setColor(new Color(255,255,255));
		g.fillRect(lineLeft-2, lineBot+4,lineWidth+4,(myHeight-towerHeight)/4);
	}
	private void paintBackground(Graphics g) {
		g.setColor(new Color(255,255,255));
		g.fillRect(5,5,this.getWidth()-10,this.getHeight()-10);
	}
	private void paintBorder(Graphics g) {
		g.setColor(new Color(0,0,0));
		g.fillRect(0,0,this.getWidth(),borderSize);
		g.fillRect(0,this.getHeight()-borderSize, this.getWidth(),borderSize);
		g.fillRect(0,0,borderSize,this.getHeight());
		g.fillRect(this.getWidth()-borderSize,0, borderSize,this.getHeight());
    }
	private Color getDiskColor(int whichTower, int n) {
		String s = tower.getTower(whichTower);
		int j = nDisks-Integer.parseInt(s.substring(n,n+1));
		return c[j%10];
	}
	private void delay(int n) {
		try {
			Thread.sleep(n);
		} catch(Exception e) {}
	}
	private TowerThread    tower;
	private final   int    borderSize = 5;
	private int         sdelay=100;
	private int         nDisks;
	private Color[]     c;
	private int         myHeight;
	private int         myWidth;
	private int         diskWidth;
	private int         smallestDiskWidth;
	private int         interDiskWidth;
	private int         diskHeight;
	private int         towerHeight;
	private int         lineBot;
	private int         lineLeft;
	private int         lineRight;
	private int         lineWidth;
	private int[ ]      towerLeft;
}
