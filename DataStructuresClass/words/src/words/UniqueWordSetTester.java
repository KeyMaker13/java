package words;

import java.io.IOException;


public class UniqueWordSetTester {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Lab 3 by Ivan Capistran");
		
		UniqueWordSet testSet = new UniqueWordSet();
		
		testSet.updateCount("the");
		testSet.updateCount("bank");
		testSet.updateCount("the");
		testSet.updateCount("green");
		
		System.out.println("Number of unique words : " + testSet.getCountUnique());
		System.out.println("Number of words : " +testSet.getCount());
		System.out.println("Number of times 'the' appears : " + testSet.getCount("the"));
		System.out.println("\n\n");
		
		//Part III
		UniqueWordSet simple = createWordSet("simple.txt");
		//System.out.println(simple.toString());
		UniqueWordSet shortTxt = createWordSet("short.txt");
		//System.out.println(shortTxt.toString());
		
		//Part IV
		UniqueWordSet poeSet = createWordSet("poe.txt");
		System.out.println("Number of words in poeSet : " + poeSet.getCount());
		
		
		System.out.println("Number of unique words in poeSet : " + poeSet.getCountUnique());
		System.out.println("Average word length in poeSet : " + poeSet.averageWordLength());
		
		}
	
	public static UniqueWordSet createWordSet (String FileName) throws IOException
	{
		WordReader r = new WordReader(FileName);
		UniqueWordSet methodWordSet  = new UniqueWordSet();
		
		try{
			while(r.hasNext()){
				methodWordSet.updateCount(r.next());
			}
		}
		catch (Exception IOException){
			System.out.println("The file is not in the correct place.\nPlease locate and place your file in the correct location.");
		}
		return methodWordSet;	
	}
}
