package recursion;

public class TowersOfHanoi {

	public static void main(String[] args) {
		System.out.println("Moving tower of size 4 from peg 1 to peg 3");
		solveTower(4, 1, 3, 2);

	}

	// Print instructions for moving numberDisks from start to end using temp
	// as a temporary holding place
	public static void solveTower(int numberDisks, int start, int end, int temp) {
		if (numberDisks == 1) {
			System.out.println("Move a disk from peg " + start + " to peg " + end);
		} else {

			solveTower(numberDisks - 1, start, temp, end);
			solveTower(1, start, end, temp);
			solveTower(numberDisks - 1, temp, end, start);
		}
	}

}
