package coding;

import java.io.*;
import java.util.*;

import datastructures.*;

public class HuffmanEncoder {
   private static final int MAXIMUM_UNIQUE_CHARACTERS = 128;
   private String unencodedFileName;
   private BitOutputStream encodedFile;
   private HuffmanCodingEntry[] encodingTable;
   private int[] invertedTable;
   private int unencodedFileSize; // Size of the original file in bytes
   private int alphabetSize; // Number of unique bytes in the file
   private int currentTableSize; // Number of entries in the encoding table

   public HuffmanEncoder(String infile, String outfile) throws IOException {
      unencodedFileName = infile;
      encodedFile = new BitOutputStream(outfile);
      encodingTable = new HuffmanCodingEntry[2*MAXIMUM_UNIQUE_CHARACTERS - 1];
      invertedTable = new int[2*MAXIMUM_UNIQUE_CHARACTERS - 1];
      for (int i = 0; i < invertedTable.length; i++)
         invertedTable[i] = -1;
      unencodedFileSize = 0;
      alphabetSize = 0;
      currentTableSize = 0;
      makeEncodingTable();
      writeEncodedFile();
   }

   //  Usual Accessors
   public int getFileSize() {
      return unencodedFileSize;
   }

   public int getAlphabetSize() {
      return alphabetSize;
   }

   public String getEncoding(int c) { //returns String encoding of c
      int nextNode = c;
      StringBuffer encoding = new StringBuffer("");
      do {
         if (encodingTable[nextNode].isRightChild())
            encoding.append("1");
         else
            encoding.append("0");
         nextNode = encodingTable[nextNode].getParent();
      } while (encodingTable[nextNode].getParent() != -1);
      return encoding.reverse().toString();
   }

   public void printEncodings() { // outputs alphabet encodings
      System.out.println("\n**Huffman encodings**");
      System.out.println("Value\tCode");
      for (int i = 0; i < alphabetSize; i++) {
         System.out.println(encodingTable[i].getValue() + "\t\t" +
                            getEncoding(i));
      }
      System.out.println("\n");
   }

   public void printTable() { //  outputs each HuffmanCodingEntry in the table
      System.out.println("\n**Huffman encoding table**");
      System.out.println("Char\tIndex\tWght\tPar\tType\tLeft\tRight");
      for (int i = 0; i < currentTableSize; i++)
         System.out.println(encodingTable[i]);
      System.out.println();
   }

   private void buildTree() {
      int nextInternalValue = MAXIMUM_UNIQUE_CHARACTERS; // 128
      PriorityQueueADT q = new LinkedPriorityQueue();
      for (int i = 0; i < alphabetSize; i++)
         q.add(encodingTable[i]);
      try {
         while (true) {
            HuffmanCodingEntry T1 = (HuffmanCodingEntry) (q.removeMin());
            HuffmanCodingEntry T2 = (HuffmanCodingEntry) (q.removeMin());
            T1.setParent(currentTableSize);
            T2.setParent(currentTableSize);
            T2.setChildType(true);
            insertInTable(nextInternalValue, T1.getWeight() + T2.getWeight());
            q.add(encodingTable[currentTableSize - 1]);
            nextInternalValue++;
         }
      } catch (NoSuchElementException e) { // expected to happen at end
      }
   }

   private void computeCharacterCounts() throws IOException {
      FileInputStream f = null; // could also use BitInputStream here
      try { // we catch and rethrow the exception to be sure to close file
         f = new FileInputStream(unencodedFileName);
         int thisByte;
         while ( (thisByte = f.read()) != -1) {
            insertInTable(thisByte, 1);
            unencodedFileSize++;
         }
      } catch (Exception e) {
         throw new IOException("Exception " + e.getMessage() +
                               "reading " + unencodedFileName);
      } finally { // always want to close the file no matter what
         if (f != null)
            f.close();
      }
      alphabetSize = currentTableSize; // now have the unique characters
   }

   private void insertInTable(int v, int weight) {
      if (invertedTable[v] == -1) { // if v is not in the table add it
         encodingTable[currentTableSize] =
               new HuffmanCodingEntry(v, currentTableSize, weight, -1, false);
         invertedTable[v] = currentTableSize;
         currentTableSize++;
      } else // add weight to the total weight of the character v
         encodingTable[invertedTable[v]].addWeight(weight);
   }

   private void makeEncodingTable() throws IOException {
      computeCharacterCounts(); // Inserts characters in table
      buildTree(); //  Builds the table so that each character is a leaf
   }

   //  Writes the encoded entry to the file using recursion
   private void writeEncodedChar(int thisChar, BitOutputStream bout) throws
         IOException {
      // finds the location of thisChar in the table
      int theEntry = invertedTable[thisChar]; // Find the position in the table
      // finds the location of thisChar's parent
      int theParent = encodingTable[theEntry].getParent();

      /*  If current node has no parent, return.*/
      if (theParent == -1)
         return;
      /*  Call traversal algorithm for the parent. */
      writeEncodedChar(encodingTable[theParent].getValue(), bout);

      /*  If current node is a left child, output a 0.
                If current node is a right child, output a 1.  */
      bout.writeBit(encodingTable[theEntry].isRightChild());
   }

   /**
        Total number of bytes in original file (an int)
        Number of characters in the alphabet
        Encoded first table entry  (an int)
        Encoded second table entry (an int)
                 ...
        Encoded last table entry (an int)
        Huffman-encoded bitstream for the file ....
    */
   private void writeEncodedFile() throws IOException {
      BitInputStream f = null;
      try {
         f = new BitInputStream(unencodedFileName);
         encodedFile.writeInt(unencodedFileSize);
         encodedFile.writeInt(alphabetSize);
         for (int i = 0; i < currentTableSize; i++)
            encodedFile.writeInt(encodingTable[i].encode());
            // Read one character at a time, encode it, and write to file
         int thisChar = 0;
         for (int j = 0; j < unencodedFileSize; j++) {
            if ( (thisChar = f.readByte()) == -1)
               throw new IOException("Unexpected end of file reading character "
                                     + j + " in " + unencodedFileName);
            writeEncodedChar(thisChar, encodedFile);
         }
         encodedFile.flush();
      } catch (Exception e) {
         throw new IOException("Error encoding file: " + e.getMessage());
      } finally { // No matter what we want to release system resources
         encodedFile.close();
         if (f != null)
            f.close();
      }
   }
}
