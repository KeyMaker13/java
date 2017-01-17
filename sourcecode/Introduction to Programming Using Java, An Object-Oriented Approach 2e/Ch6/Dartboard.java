class Dartboard {
    public Dartboard(double radius) {
		this.radius = radius;
		insideCircle = 0;
		outsideCircle = 0;
    }
    public void strike(Toss toss) {
		double x = toss.getX();
		double y = toss.getY();
		if (Math.sqrt(x*x + y*y) < radius)
			insideCircle++;
		else
			outsideCircle++;
    }
    public double getFractionIn() {
		double total = (double) (insideCircle+outsideCircle);
		return (double) insideCircle/total;
	}
	
	public static void testDriver() {
		Dartboard d = new Dartboard(1.0);
		System.out.println("Radius: 1.0");
		Toss t = new Toss(0.0,0.0);
		System.out.println("Toss 1: <0.0, 0.0>");
		d.strike(t);
		t = new Toss (0.5,0.5);
		System.out.println("Toss 2: <0.5, 0,5>"); 
		d.strike(t);
		t = new Toss(1.0,1.0);
		System.out.println("Toss 3: <1.0, 1.0>");
		d.strike(t);
		double correctAnswer = 2.0/3.0;
		double calcFraction = d.getFractionIn();
		System.out.print("Fraction in circle (computed): ");
		System.out.println(calcFraction);
		if (calcFraction != correctAnswer) {
			System.out.print("*** Error - computed fraction does not ");
			System.out.print("match correct answer of ");
			System.out.println(correctAnswer);
			System.out.println("Test failed!");
		} else
			System.out.println("Test completed successfully!");
	}
	private double radius;
    private int insideCircle, outsideCircle;
}
