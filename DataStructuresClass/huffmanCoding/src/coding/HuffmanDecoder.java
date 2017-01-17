package coding;

import java.io.*;

public class HuffmanDecoder {
   private static final int DEFAULT_TABLESIZE = 255;
   private BitOutputStream unencodedFile;
   private BitInputStream encodedFile;
   private HuffmanCodingEntry[] decodingTable;
   private int unencodedFileSize; // Size of the original file in bytes
   private int alphabetSize; // Number of unique bytes in the file
   private int currentTableSize; // Number of entries in the encoding table

   // Constructor takes the name of encoded file and name of file to hold unencoded results
   public HuffmanDecoder(String infile, String outfile) throws IOException {
      encodedFile = new BitInputStream(infile); // Encoded file is input
      unencodedFile = new BitOutputStream(outfile); // Unencoded file is output
      decodingTable = new HuffmanCodingEntry[DEFAULT_TABLESIZE];
      unencodedFileSize = 0;
      alphabetSize = 0;
      currentTableSize = 0;
      makeDecodingTable();
      writeUnencodedFile();
   }

   public int getAlphabetSize() {
      return alphabetSize;
   }

   public int getFileSize() {
      return unencodedFileSize;
   }
   
   public int getDecodingTableSize(){
	   return decodingTable.length;
   }

   public String getEncoding(int c) { //returns String encoding of c
      int nextNode = c;
      StringBuffer encoding = new StringBuffer("");
      do {
         if (decodingTable[nextNode].isRightChild())
            encoding.append("1");
         else
            encoding.append("0");
         nextNode = decodingTable[nextNode].getParent();
      } while (decodingTable[nextNode].getParent() != -1);
      return encoding.reverse().toString();
   }

   public void printEncodings() { // outputs alphabet encodings
      System.out.println("\n**Huffman decodings**");
      System.out.println("Value\tCode");
      for (int i = 0; i < alphabetSize; i++) {
         System.out.println(decodingTable[i].getValue() + "\t\t" +
                            getEncoding(i));
      }
      System.out.println("\n");
   }

   public void printTable() { //  outputs each HuffmanCodingEntry in the table
      System.out.println("\n**Huffman decoding table**");
      System.out.println("Char\tIndex\tWght\tPar\tType\tLeft\tRight");
      for (int i = 0; i < currentTableSize; i++)
         System.out.println(decodingTable[i]);
      System.out.println();
   }

   // Read in the Huffman coding table and build the tree for decoding
   private void makeDecodingTable() throws IOException {
      // To be completed in lab in Part III
      // <-- Your code here ---------------------------------------->
      // Read in the decoding table

      // Set the child pointers
	   
	   unencodedFileSize = encodedFile.readInt();
	   alphabetSize=encodedFile.readInt();
	   currentTableSize = 2*alphabetSize -1;

	   for(int i=0;i < currentTableSize;i++)
	   {
		   int value=encodedFile.readInt();
		   decodingTable[i]= new HuffmanCodingEntry(i,value);
	   }
	   
     for(int i=0;i<currentTableSize -1 ;i++)
	 { 
	    int parent=decodingTable[i].getParent();
	    if(decodingTable[i].isRightChild())
	    {
	    	decodingTable[parent].setRightChild(i);
	    }
	    else
	    {
	    	decodingTable[parent].setLeftChild(i);
	    }
     } 
   }

   public byte decodeNextChar() throws IOException {
      // To be completed in lab in Part III
      // <-- Your code here ---------------------------------------->
	 int val1 = decodingTable[currentTableSize -1].getIndex(); 
	 while(decodingTable[val1].getLeftChild()!=-1 || decodingTable[val1].getRightChild()!=-1){
		 boolean x = encodedFile.readBit();
		 if (x==true){
			 val1 = decodingTable[val1].getRightChild();
		 }
		 else{
			 val1 = decodingTable[val1].getLeftChild();
		 }
	 }
		 return (byte) decodingTable[val1].getValue();
   }
   // Write the unencoded file by processing the input bit stream
   private void writeUnencodedFile() throws IOException {
      int numProcessed = 0;
      try {
         while (numProcessed < unencodedFileSize) {
            unencodedFile.writeByte(decodeNextChar());
            numProcessed++;
         }
         unencodedFile.flush(); // flush to make sure all characters are written
      } catch (Exception e) {
         throw new IOException("Failed to write encoded file " + e.getMessage());
      } finally {
         unencodedFile.close();
         encodedFile.close();
      }
   }
}