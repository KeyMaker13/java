import java.io.*;

class Location  {
	
	Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	int distanceFrom(Location loc) {
		int xdist = Math.abs(this.x - loc.x);
		int  ydist = Math.abs(this.y - loc.y);
		return xdist + ydist;
	}
	public static Location read(BufferedReader br) 
	throws Exception {
		String s = br.readLine();
		int comma = s.indexOf(",");
		int x = Integer.parseInt(s.substring(0,comma).trim());
		int y = Integer.parseInt(s.substring(comma+1).trim());
		return new Location(x,y);
	}
	private int x, y;
}
