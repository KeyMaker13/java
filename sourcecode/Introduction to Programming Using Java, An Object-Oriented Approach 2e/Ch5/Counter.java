class Counter {
    public void reset() {
	count = 0;
    }
    public void increment() {
	count = count + 1;
	globalCount = globalCount + 1;
    }
    public int getValue() {
	return count;
    }
    public static int getGlobalValue() {
	return globalCount;
    }
    public static void globalReset() {
	globalCount = 0;
    }
    private static int globalCount = 0;
    private int count = 0;
}
