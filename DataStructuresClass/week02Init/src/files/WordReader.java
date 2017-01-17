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

	private void updateWord() {
	}
}
