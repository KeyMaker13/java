package recursion;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class QueensSimplified {
	private int boardsize;
	private int numberSolutions;
	private int positionInRow[]; // column # of queen in row
	private boolean cols[]; // corresponding col is available
	
	private ArrayList<int[]> actualSolutions;

	public QueensSimplified(int bsize) {
		boardsize = bsize;
		initialize();
		putQueensInRow(0);
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

	// dummy test method
	private void placeQueensDiagonal() {
		for (int i = 0; i < boardsize; i++)
			positionInRow[i] = i;
	}
	
	// place queens on board starting in row, assuming
	// queens have already been placed in rows 0 to row-1
	private void putQueensInRow(int row) {
        for (int column = 0; column < boardsize; column++) {
        	if (!valid(row, column))
        		continue;
        	cols[column] = false;
        	positionInRow[row] = column;
        	if (row == boardsize - 1) {
        		numberSolutions++;
        		actualSolutions.add(positionInRow.clone());
        		printBoard("Solution " + numberSolutions);
        	} else
        		putQueensInRow(row + 1);
        	cols[column] = true;
        	positionInRow[row] = -1;	
        }
	}

	// return true if (row, column) represents an unused position on the board
	private boolean valid(int row, int column) {
		if (row < 0 || row >= boardsize || column < 0 || column >= boardsize)
			return false;
		return (positionInRow[row] == -1) && cols[column];
	}

	// sets up the data structures
	private void initialize() {
		actualSolutions = new ArrayList<int[]>();
		numberSolutions = 0;
		positionInRow = new int[boardsize];
		cols = new boolean[boardsize];
		for (int i = 0; i < boardsize; i++) {
			positionInRow[i] = -1;
			cols[i] = true;
		}
	}
}