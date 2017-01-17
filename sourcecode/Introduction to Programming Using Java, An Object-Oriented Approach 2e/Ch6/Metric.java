class Metric {
    public double convertFeetToMeters(double feet) {
	return feet * METERSPERFOOT;
    }
    public void printFeetToMetersTable(int maxFeet) {
	System.out.println("Feet Meters");
	for (int i=1; i <= maxFeet; i++) {
	    double feet = (double) i;
	    double meters = convertFeetToMeters(feet);
	    System.out.println(feet+" "+meters);
	}
    }
    public static final double METERSPERFOOT = 0.3048;
}
