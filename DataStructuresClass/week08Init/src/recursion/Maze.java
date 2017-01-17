package recursion;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Maze {
	private static final int VISITED = 7;
	private static final int PATH = 8;
	private static final int ROAD = 1;
	private static final int EMPTY = 0;

	private int rowSize;
	private int columnSize;
	private int startRow;
	private int startColumn;
	private int endRow;
	private int endColumn;
	private int[][] originalGrid;
	private int[][] solutionGrid;
	private String fileName;

	public Maze(String name) {
		fileName = name;
		readMaze();
		startRow = 0;
		startColumn = 0;
		endRow = rowSize - 1;
		endColumn = columnSize - 1;
		if (traverse(startRow, startColumn))
			solutionGrid[endRow][endColumn] = PATH;
	}

	public String toString() {
		String result = "\nOriginal maze = \n";
		result += gridToString(originalGrid);
		result += "\nSolved maze starting at (" + startRow + ", " + startColumn
				+ ") and ending at (" + endRow + "," + endColumn + ") = \n";
		result += gridToString(solutionGrid);
		return result;
	}

	private void readMaze() {
		try {
			Scanner s = new Scanner(new File(fileName));
			rowSize = s.nextInt();
			columnSize = s.nextInt();
			originalGrid = new int[rowSize][];
			solutionGrid = new int[rowSize][];
			for (int j = 0; j < rowSize; j++) {
				originalGrid[j] = new int[columnSize];
				solutionGrid[j] = new int[columnSize];
				for (int k = 0; k < columnSize; k++) {
					int nextItem = s.nextInt();
					if (nextItem != ROAD && nextItem != EMPTY)
						throw new NoSuchElementException("Bad maze");
					originalGrid[j][k] = nextItem;
					solutionGrid[j][k] = nextItem;
				}
			}
		} catch (Exception e) {
			System.out.println("Failed to read a proper maze from " + fileName
					+ ":" + e.getMessage());
			originalGrid = new int[0][0];
			solutionGrid = new int[0][0];
			rowSize = 0;
			columnSize = 0;
		}
	}

	private String gridToString(int[][] grid) {
		String result = "";
		if (grid != null) {
			for (int j = 0; j < grid.length; j++) {
				for (int k = 0; k < grid[j].length; k++)
					result = result + grid[j][k] + " ";
				result += "\n";
			}
		}
		return result;
	}

	// Returns true if there is a valid path from (row, column) to (endRow,
	// endColumn)
	private boolean traverse(int row, int column) {
		// Handle base case
		if (!valid(row, column))
			return false;
		solutionGrid[row][column] = VISITED;
		if (row == endRow && column == endColumn)
			return true;
		// See if path from here on
		if (traverse(row, column + 1) || traverse(row + 1, column)
				|| traverse(row, column - 1) || traverse(row - 1, column)) {
			solutionGrid[row][column] = PATH;
			return true;
		}
		return false;
	}

	// Returns true if (row, column) is a valid unvisited position on the road
	private boolean valid(int row, int column) {
		if (row < 0 || column < 0 || row >= rowSize || column >= columnSize)
			return false;
		if (solutionGrid[row][column] != ROAD)
			return false;
		return true;
	}
}
