class Calculator {
	public Calculator() {
		value = 0.0;
	}
	public void clear() {
		value = 0.0;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double v) {
		value = v;
	}
	public void add(double d) {
		value += d;
	}
	public void subtract(double d) {
		value -= d;
	}
	public void multiply(double d) {
		value *= d;
	}
	public void divide(double d) {   
		value /= d;
	}
	private double value;
}
