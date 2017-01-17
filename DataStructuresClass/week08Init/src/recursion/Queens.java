package recursion;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Queens {
	private int boardsize;
	private int numberSolutions;
	private int positionInRow[]; // column # of queen in row
	private boolean cols[]; // corresponding col is available
	private boolean forwardDiagonal[]; // diagonal available
	private boolean backwardDiagonal[]; // diagonal available
	private ArrayList<int[]> actualSolutions;

	public Queens(int bsize) {
		boardsize = bsize;
		initialize();

		putQueensInRow(0);
		// placeQueensDiagonal();
	}

	public int getNumberSolutions() {
		return numberSolutions;
	}

	public int[] getSolution(int i) {
		if (i < 1 || i > numberSolutions)
			throw new NoSuchElementException();
		int[] sol = (int[]) actualSolutions.get(i - 1);
		return sol;
	}

	// place queens on board starting in row, assuming
	// queens have already been placed in rows 0 to row-1
	private void putQueensInRow(int row) {
		for (int column = 0; column < boardsize; column++) {

			if (!valid(row, column))
				continue;
			cols[column] = false; // do the placement
			forwardDiagonal[row - column + boardsize - 1] = false;
			backwardDiagonal[row + column] = false;
			positionInRow[row] = column;
			if (row == boardsize - 1) {
				numberSolutions++;
				actualSolutions.add(positionInRow.clone());
				printBoard(boardsize + "-queens solution " + numberSolutions );
			} else
				putQueensInRow(row + 1);
			cols[column] = true; // undo the placement (the backtracking step)
			forwardDiagonal[row - column + boardsize - 1] = true;
			backwardDiagonal[row + column] = true;
			positionInRow[row] = -1;
		}
	}

	public void printBoard(String msg) {
		System.out.println("\n" + msg + "\n" + boardToString());
	}

	public String boardToString() {
		String result = "\n    ";
		for (int i = 0; i < boardsize; i++)
			result += "  " + (i % 10) + "  ";
		result += "\n";
		for (int i = 0; i < 5 * (boardsize + 1); i++)
			result += "-";
		for (int i = 0; i < boardsize; i++) {
			result += "\n  " + (i % 10) + " ";
			if (positionInRow[i] == -1)
				continue;
			for (int j = 0; j < 5 * positionInRow[i]; j++)
				result += " ";
			result += "  X";
		}
		return result + "\n";
	}

	private void placeQueensDiagonal() {
		for (int i = 0; i < boardsize; i++)
			positionInRow[i] = i;
	}

	private boolean valid(int row, int column) {
		if (!cols[column] ||
	             !forwardDiagonal[row - column + boardsize - 1] ||
	             !backwardDiagonal[row + column])
	   return false;
		return true;

	}

	private void initialize() {
		actualSolutions = new ArrayList<int[]>();
		numberSolutions = 0;
		positionInRow = new int[boardsize];
		cols = new boolean[boardsize];
		forwardDiagonal = new boolean[2 * boardsize - 1];
		backwardDiagonal = new boolean[2 * boardsize - 1];
		for (int i = 0; i < boardsize; i++) {
			positionInRow[i] = -1;
			cols[i] = true;
		}
		for (int i = 0; i < 2 * boardsize - 1; i++) {
			forwardDiagonal[i] = true;
			backwardDiagonal[i] = true;
		}
	}
}