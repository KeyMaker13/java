package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LineReader implements Iterator<String> {
	private String fileName;
	private BufferedReader reader;
	private String nextLine;

	public LineReader(String afileName) throws IOException {
		fileName = afileName;
		reader = new BufferedReader(new FileReader(fileName));
		updateLine();
	}

	public boolean hasNext() {
		return true;
	}

	public String next() {
		return null;
	}

	public void remove() {
		throw new UnsupportedOperationException("Remove not supported for "
				+ toString());
	}

	public String toString() {
		return getClass().getName() + ":" + fileName;
	}

	private void updateLine() {

	}
}
