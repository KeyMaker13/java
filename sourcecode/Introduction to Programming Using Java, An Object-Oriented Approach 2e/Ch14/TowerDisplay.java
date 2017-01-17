class TowerDisplay {
	public void displayMove(Towers t) {
		System.out.println("MOVE from "+t.getFrom()+" to "+t.getTo());
		System.out.println("   tower 1:"+t.getTower(1));
		System.out.println("   tower 2:"+t.getTower(2));
		System.out.println("   tower 3:"+t.getTower(3));
	}
}
