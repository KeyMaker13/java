package coding;

import java.io.*;

public class BitOutputStream {
   private static final int BYTESIZE = 8;
   private static final byte ONEMASK = 1;
   private int unusedBits;
   private byte currentByte;
   private DataOutputStream data;
   private int totalBytesWritten;

   public BitOutputStream(String file) {
      try {
         data = new DataOutputStream(new FileOutputStream(file));
      } catch (IOException e) {}
      unusedBits = 8;
      currentByte = 0;
      totalBytesWritten = 0;
   }

   public void close() { // release system resources
      try {
         data.close();
      } catch (IOException e) { // don't report an error on close
      }
   }

   public void flush() throws IOException { // Force output of current byte
      writePartialBits();
      data.flush();
   }

   public int getBytesWritten() {
      return totalBytesWritten;
   }

   public String toString() {
      return getClass().getName() + "[total=" + totalBytesWritten +
            ",unused bits=" + unusedBits + "]";
   }

   public void writeBit(boolean v) throws IOException { // Write the bit v
      currentByte = (byte) (currentByte << 1); // shift left 1 to move next bit in
      if (v)
         currentByte = (byte) (currentByte | ONEMASK); // set low bit
      unusedBits--;
      if (unusedBits <= 0) { // current byte is full so output it
         data.writeByte(currentByte);
         totalBytesWritten++;
         unusedBits = BYTESIZE;
         currentByte = 0;
      }
   }

   public void writeByte(byte v) throws IOException { // Write the byte v
      writePartialBits();
      data.writeByte(v);
      totalBytesWritten++;
   }

   public void writeInt(int v) throws IOException { // Write the int v
      writePartialBits();
      data.writeInt(v);
      totalBytesWritten += 4;
   }

   // If a partial byte has been written, pad with zeroes and output
   private void writePartialBits() throws IOException {
      if (unusedBits != BYTESIZE) { // Write out partial bits
         currentByte = (byte) (currentByte << unusedBits);
         data.writeByte(currentByte);
         totalBytesWritten++;
         unusedBits = BYTESIZE;
         currentByte = 0;
      }
   }
}
