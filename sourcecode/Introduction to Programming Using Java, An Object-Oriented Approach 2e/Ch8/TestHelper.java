class TestHelper {
	public static void verify(boolean testCondition, String message) {
		if (!testCondition) {
			System.out.print("*** Error - test failure: ");
			System.out.println(message);
			Thread.dumpStack();
		}
	}
}
