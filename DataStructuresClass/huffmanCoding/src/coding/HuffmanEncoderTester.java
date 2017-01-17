package coding;

import java.io.IOException;

public class HuffmanEncoderTester {
   public static void main(String[] args) 
   {
    System.out.println("Lab 10 by Ivan Capistran ");
    System.out.println("\n-----Test A -------\n");
    try{
    	
    	HuffmanEncoder eTestA= new HuffmanEncoder
    			("TestA.dat","TestAEncoded.dat");
    	System.out.println("Our file size : "+
    			eTestA.getFileSize());
    	System.out.println("Our file alphabet size :"+
    			eTestA.getAlphabetSize());
    	System.out.println("Our file encoding :");
    	eTestA.printEncodings();
    	System.out.println("Our File Table :");
    	eTestA.printTable();
    	
    	System.out.println("------Test B-------");
    	
    	HuffmanEncoder eTestB= new HuffmanEncoder
    			("TestB.dat","TestBEncoded.dat");
    	System.out.println("Our file size : "+
    			eTestB.getFileSize());
    	System.out.println("Our file alphabet size :"+
    			eTestB.getAlphabetSize());
    	System.out.println("Our file encoding :");
    	eTestB.printEncodings();
    	System.out.println("Our File Table :");
    	eTestB.printTable();
    	
    	System.out.println("------Test C------");
    	
    	HuffmanEncoder eTestC= new HuffmanEncoder
    			("TestA.dat","TestAEncoded.dat");
    	System.out.println("Our file size : "+
    			eTestC.getFileSize());
    	System.out.println("Our file alphabet size :"+
    			eTestC.getAlphabetSize());
    	System.out.println("Our file encoding :");
    	eTestC.printEncodings();
    	System.out.println("Our File Table :");
    	eTestC.printTable();
    	
    }catch(IOException ex)
       {
    	System.err.println("Cannot encode TestA"+
          ex.getMessage());
       }
	   
    }
}
