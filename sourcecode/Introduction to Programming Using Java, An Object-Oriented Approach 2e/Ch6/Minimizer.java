class Minimizer {
    public void check(long nextValue) {
	if (nextValue < minSoFar)
	    minSoFar = nextValue;
    }
    public long get() {
	return minSoFar;
    }
    public void reset() {
	minSoFar = Long.MAX_VALUE;
    }
    private long minSoFar = Long.MAX_VALUE;
}
