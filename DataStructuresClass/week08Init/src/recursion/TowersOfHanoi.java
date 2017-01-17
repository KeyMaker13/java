package recursion;

public class TowersOfHanoi {

	
	public static void main(String[] args) {
		System.out.println("Moving tower of size 4 from peg 1 to peg 3");
		solveTower(4, 1, 3, 2);

	}
	
	//Print instructions for moving numberDisks from start to end using temp
	//as a temporary holding place
	public static void solveTower(int numberDisks, int start, int end, int temp) {
		if (numberDisks == 0)
			return;
		solveTower(numberDisks - 1, start, temp, end);
		System.out.println("Move disk " + numberDisks + " from " 
				+ start + " to " + end);
		solveTower(numberDisks - 1, temp, end, start);
	}

}
