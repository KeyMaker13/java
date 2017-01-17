package coding;

import java.io.*;

public class HuffmanDecoderTester 
{
   public static void main(String[] args) 
   {
   System.out.println("Lab 10 by Ivan Capistran (Decoder)");
     try{
    	 System.out.println("--------TestA---------");
    HuffmanDecoder dTestA= 
    	  new HuffmanDecoder("TestAEncoded.dat",
    			                 "TestADecoded.dat");
    System.out.println("Our file size :"
    			                 +dTestA.getFileSize());
    System.out.println("Our Table :");
    dTestA.printTable();
    System.out.println("Our decoding :");
    dTestA.printEncodings();
    
    System.out.println("--------TestB---------");
    HuffmanDecoder dTestB= 
      	  new HuffmanDecoder("TestBEncoded.dat",
      			                 "TestBDecoded.dat");
      System.out.println("Our file size :"
      			                 +dTestB.getFileSize());
      System.out.println("Our Table :");
      dTestB.printTable();
      System.out.println("Our decoding :");
      dTestB.printEncodings();
      System.out.println("--------TestC---------");
      HuffmanDecoder dTestC= 
        	  new HuffmanDecoder("TestCEncoded.dat",
        			                 "TestCDecoded.dat");
        System.out.println("Our file size :"
        			                 +dTestC.getFileSize());
        System.out.println("Our Table :");
        dTestC.printTable();
        System.out.println("Our decoding :");
        dTestC.printEncodings();
        System.out.println("--------TestD---------");
        HuffmanDecoder dTestD= 
          	  new HuffmanDecoder("TestDEncoded.dat",
          			                 "TestDDecoded.dat");
          System.out.println("Our file size :"
          			                 +dTestD.getFileSize());
          System.out.println("Our Table :");
          dTestD.printTable();
          System.out.println("Our decoding :");
          dTestD.printEncodings();
    	 
     }catch(IOException ex)
     {
    	 System.err.println("Cannot Decode! "
                              +ex.getMessage());
     }
   
   }
}
