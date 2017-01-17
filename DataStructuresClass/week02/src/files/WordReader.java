package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class WordReader implements Iterator<String> {
	private String fileName;
	private BufferedReader reader;
	private String nextWord;
	private StringTokenizer tokens;

	public WordReader(String afileName) throws IOException {
		fileName = afileName;
		reader = new BufferedReader(new FileReader(fileName));
		tokens = new StringTokenizer(reader.readLine());
		updateWord();
	}

	public boolean hasNext() {
		return reader != null;
	}

	public String next() {
		if (reader == null)
			throw new NoSuchElementException("End of " + fileName);
		String thisWord = nextWord;
		updateWord();
		return thisWord;
	}

	public void remove() {
		throw new UnsupportedOperationException("Remove not supported for "
				+ toString());
	}

	public String toString() {
		return getClass().getName() + ":" + fileName;
	}

	private void updateWord() {
		if (reader == null) {
			return;
		}
		try {
			// need to be careful here.
			// The file can contain line of blank spaces
			while (!tokens.hasMoreTokens()) {
				String nextLine = reader.readLine();
				if (nextLine == null)
					throw new IOException("No more lines");
				tokens = new StringTokenizer(nextLine);
			}
			nextWord = tokens.nextToken();
		} catch (IOException e) {
			try { // 
				reader.close();
			} catch (Exception e1) {
			}
			reader = null;
		}

	}
}
