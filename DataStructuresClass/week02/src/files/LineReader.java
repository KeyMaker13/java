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
		return reader != null;
	}

	public String next() {
		if (reader == null)
			throw new NoSuchElementException("End of " + fileName);
		String thisLine = nextLine;
		updateLine();
		return thisLine;
	}

	public void remove() {
		throw new UnsupportedOperationException("Remove not supported for "
				+ toString());
	}

	public String toString() {
		return getClass().getName() + ":" + fileName;
	}

	private void updateLine() {
		if (reader == null)
			return;
		try {
			nextLine = reader.readLine();
			if (nextLine == null)
				throw new IOException();
		} catch (IOException e) {
			try {
				reader.close();	
			} catch (Exception e1) {
			}
			reader = null;
		}

	}
}
