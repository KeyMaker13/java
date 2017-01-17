class Towers {
	
	public static void main(String[] a) {
		if (a.length!=1)
			System.err.println(
							   "Usage: java Towers <number of disks> ");
		else {
			int nDisks = Integer.parseInt(a[0]);
			Towers th = new Towers(new TowerDisplay(), nDisks);
			th.solveIt();
		}
	}
	
	
	public Towers(TowerDisplay td, int nDisks) {
		this.td = td;
		this.nDisks = nDisks;
		if (nDisks>9)
			nDisks = 9;
		towers = new String[4];
		towers[1] = "123456789".substring(0,nDisks);
		towers[2] = "";
		towers[3] = "";
	}
	public void solveIt() {
		solveIt(nDisks, 1, 3);
	   }
	private void solveIt(int nDisks, int source,int target) {
		if (nDisks<=0)
			return;
		int holdingTower = getHoldingTower(source,target);
		solveIt(nDisks-1,source,holdingTower);
		updateModel(source,target);
		td.displayMove(this);
		solveIt(nDisks-1,holdingTower,target);
	}
	public int getFrom() {
		return from;
	}
	public int getTo() {
		return to;
	}
	public String getTower(int index) {
		return towers[index];
	}
	private int getHoldingTower(int source, int target) {
		if ((source == 2 && target == 3) ||
			(source == 3 && target == 2))
			return 1;
		if ((source == 1 && target == 3) ||
			(source == 3 && target == 1))
			return 2;
		return 3;
	}
	private void updateModel(int source, int target) {
		from = source;
		to = target;
		int fromLast = towers[from].length()-1;
		towers[to] = towers[to].concat(
									   towers[from].substring(fromLast));
		towers[from] = towers[from].substring(0,fromLast);
	}
	private int nDisks;
	private String[] towers;
	private int from,to;
	private TowerDisplay td;
}
