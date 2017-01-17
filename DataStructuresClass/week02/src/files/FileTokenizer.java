package files;

import java.io.*;
import java.util.*;

/**
 * <p>Title: FileTokenizer </p>
 *
 * <p>Description: A FileTokenizer breaks a text file into a sequence of tokens,
 * which consists of non-blank characters.
 * </p>
 *
 * <p>Company: UTSA </p>
 * @author Prof. Weining Zhang
 * @version 1.0
 */
/*****************************************************************************
 * This class implements both Iterator and Enumeration interfaces
 * It reads a file via a BufferedReader, and uses a StringTokenizer to
 * break a text line into a sequence of tokens. To implement the Iterator
 * interface, it needs to look ahead the next token in the sequence.
 ***************************************************************************/

public class FileTokenizer implements Iterator, Enumeration {
   File theFile;
   private BufferedReader reader;
   private boolean hasMore;
   private Object nextToken;
   private StringTokenizer tokenizer;

  /**
   * FileTokenizer
   *
   * @param filename String
   *
   * Open the filename for read, read in the first text line,
   * initialize the nextToken. If the file is not specified,
   * create a File object with a fake file name, and continue
   */
  public FileTokenizer(String filename) {

      if (filename == null || filename.equals("")) {
         theFile = new File("Empty or null file name");
         hasMore = false;
         tokenizer = null;
         nextToken = null;
         return;
      }
      hasMore = true;
      theFile = new File(filename);
      reader = null;
      try {
         reader = new BufferedReader(new FileReader(theFile));
         nextToken = getNextToken();
      } catch (Exception e) {
         hasMore = false;
         theFile = new File(filename + ":illegal");
         nextToken = null;
      }
   }

   public String getName( ) {
      return theFile.getName();
   }

   private String getNextToken() throws Exception {
     if (!hasMore)
        return null;
     while (tokenizer == null || !tokenizer.hasMoreElements()) {
        String line = reader.readLine();
        if (line == null)
           throw new IOException("End of file");
        tokenizer = new StringTokenizer(line);
     }
     return tokenizer.nextToken();
  }

  // The next two methods are required by the Enumeration interface
  public boolean hasMoreElements() {
      return hasMore;
   }

   public Object nextElement() {
      if (!hasMore)
         throw new NoSuchElementException("No more tokens for " +
                                          theFile.getName());
      Object temp = nextToken;
      try {
         nextToken = getNextToken();
      } catch (Exception e) {
         nextToken = null;
         hasMore = false;
      }
      return temp;
   }


  // The next three methods are required by the Iterator interface
  public boolean hasNext() {
    return hasMore;
  }

  public Object next() {
    if (!hasMore)
   throw new NoSuchElementException("No more tokens for " +
                                    theFile.getName());
   Object temp = nextToken;
   try {
     nextToken = getNextToken();
   } catch (Exception e) {
     nextToken = null;
     hasMore = false;
   }
   return temp;
  }

  public void remove() {
    // Not implemented for this project
    throw new UnsupportedOperationException();
  }
}
