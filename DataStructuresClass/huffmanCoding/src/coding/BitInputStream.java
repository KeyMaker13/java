package coding;

import java.io.*;

public class BitInputStream {
   private static final int BYTESIZE = 8;
   private int unusedBits;
   private byte currentByte;
   private int totalBytesRead;
   private DataInputStream data;

   // Create an input bit stream for the file
   public BitInputStream(String file) throws FileNotFoundException {
      data = new DataInputStream(new FileInputStream(file));
      unusedBits = 0;
      currentByte = 0;
      totalBytesRead = 0;
   }

   public void close() { // release resources
      unusedBits = 0;
      try {
         data.close();
      } catch (IOException e) { // don't report an error on close

      }
   }

   public void flush() { // If a partial byte has been read throw, throw it away
      unusedBits = 0;
      currentByte = 0;
   }

   public int getBytesRead() {
      return totalBytesRead;
   }

   public boolean readBit() throws IOException { // Read the next bit
      // If all the bits in the current byte have been used, read another
      if (unusedBits <= 0) {
         currentByte = data.readByte();
         totalBytesRead++;
         unusedBits = BYTESIZE;
      }
      boolean bitRead = (currentByte < 0); // is sign bit set?
      currentByte = (byte) (currentByte << 1); // shift left by 1 to move next bit in
      unusedBits--;
      return bitRead;
   }

   public byte readByte() throws IOException {
      unusedBits = 0; // If a partial byte was read, throw it away
      byte t = data.readByte(); // Get the byte
      totalBytesRead++; // If read successful, update byte count
      return t;
   }

   public int readInt() throws IOException {
      unusedBits = 0; // If a partial byte was read, throw it away
      int t = data.readInt(); // Get the int
      totalBytesRead += 4; // If read successful, update byte count
      return t;
   }

   public String toString() {
      return getClass().getName() + "[total=" + totalBytesRead +
            ",unused bits=" + unusedBits + "]";
   }
}
