class Toss {
    public Toss(double x, double y) {
	this.x = x;
	this.y = y;
    }
    public double getX() {
	return x;
    }
    public double getY() {
	return y;
    }
    public static Toss getRandom(double radius) {
	double x,y;
	double size = Math.random();
	double sign = Math.random();
	size = size * radius;
	if (sign > 0.5)
	    x = size;
	else
	    x = -size;
	size = Math.random();
	sign = Math.random();
	size = size * radius;
	if (sign>0.5)
	    y = size;
	else
	    y = - size;
	return new Toss(x,y);
    }
    private double x,y;
}
