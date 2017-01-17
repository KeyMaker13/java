class Minimizer {
    public void check(long nextValue) {
	if (nextValue < minSoFar)
	    minSoFar = nextValue;
    }
    public long get() {
	return minSoFar;
    }
    public void reset() {
	minSoFar = 9223372036854775807L;
    }
    private long minSoFar = 9223372036854775807L;
}
