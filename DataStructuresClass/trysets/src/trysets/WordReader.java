package trysets;

import java.io.*;
import java.util.*;

/**
 * <p>Title: </p> WordReader
 * <p>Description: </p> Provides an "iterator" over the file filename
 * to return individual words, while removing leading and trailing
 *  punctuation. WordReader throws an IOException if it is unable
 *  to open the file corresponding to filename. However, for other
 *  errors, it reports errors by returning null for the next word.
 */
public class WordReader implements Iterator<String> {
   private static final String punctuation = ".,:)({}[]';)-=+!@`";
   private BufferedReader read;
   private String name;
   private String nextWord;
   private boolean more;
   private StringTokenizer tokens;

   public WordReader(String filename) throws IOException {
      name = filename;
      more = true;
      read = new BufferedReader(new FileReader(filename));
      tokens = null;
      updateWord();
   }

   public boolean hasNext() {
      return more;
   }

   public String next() {
      if (!more)
         throw new NoSuchElementException("No more words in " + name);
      String thisWord = nextWord;
      updateWord();
      return thisWord;
   }

   public void remove() {
      throw new UnsupportedOperationException(
            "Can not remove elements from file");
   }

   private String trimPunctuation(String word) {
      int start = 0;
      // find first non-punctuation
      int end = word.length();
      while (start < end && punctuation.indexOf(word.charAt(start)) != -1) {
         start++;
      }
      if (start >= end) { // all punctuation
         return null;
      } while (punctuation.indexOf(word.charAt(end - 1)) != -1) {
         end--;
      }
      return word.substring(start, end);
   }

   private void updateWord() {
      try {
         while (more) {
            if (tokens == null) {
               String thisLine = read.readLine();
               if (thisLine == null) {
                  throw new IOException("Empty line");
               }
               tokens = new StringTokenizer(thisLine);
            }
            if (tokens.hasMoreTokens()) {
               nextWord = trimPunctuation(tokens.nextToken());
               if (nextWord != null) {
                  return;
               }
            } else {
               tokens = null;
            }
         }
      } catch (Exception e) {
         more = false;
         nextWord = null;
         try {
            read.close();
         } catch (Exception e1) {}
      }
   }

}
