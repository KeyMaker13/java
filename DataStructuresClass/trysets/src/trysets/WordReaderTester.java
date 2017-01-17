package trysets;

import java.io.IOException;
import java.util.Iterator;

import jss2.ArraySet;
import jss2.SetADT;

public class WordReaderTester  {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
		System.out.println("Lab 2 by Ivan Capistran");
		// TODO Auto-generated method stub
		//WordReader r1 = new WordReader("short.txt");
		
		//while(r1.hasNext())
		//{
		//	System.out.println(r1.next());
		//}
		
		System.out.println("\nPart 3");
		
		SetADT<String> poeSet = new ArraySet<String>();
		WordReader r2 = new WordReader("poe.txt");
		
		SetADT<String> shortSet = new ArraySet<String>();
		WordReader r3 = new WordReader("short.txt");
		
		// for poeSet
		//int count = 0;
		//String reff = "";
		while(r2.hasNext())
		{
			poeSet.add(r2.next());	
		}
		//String[] poeS	= new String[poeSet.size()];
		/*
		r2 = new WordReader("poe.txt");
		while(r2.hasNext())
		{	
			poeS[count] = r2.next();
			if (count < poeS.length -1)
			count++;
		}
		*/
		// for shortSet
		//count = 0;
		while(r3.hasNext()){
			shortSet.add(r3.next());
		}
		//String[] shortS = new String[shortSet.size()];
		/*
		r3 = new WordReader("short.txt");
		while(r3.hasNext())
		{
			shortS[count] = r3.next();
			if (count < shortS.length-1)
			count++;
			
		}
		*/
		System.out.println("The unique words in ShortSet\n" + shortSet.toString());	
		System.out.println("\nNumber of Unique Words in ShortSet +" + shortSet.size());
		// Part 3 I
		System.out.println("\nNumber of Unique Words in poeSet +" + poeSet.size() + "\n\n");
		
		// Part 3 III
		SetADT<String> shortSetOnly = new ArraySet<String>();
		SetADT<String> bothShortAndPoe = new ArraySet<String>();
		bothShortAndPoe = ((ArraySet<String>) shortSet).intersection(poeSet);
		
		Iterator<String> iter = shortSet.iterator();
	
		String reff3 ="";
		while(iter.hasNext()){
			
			reff3 = iter.next().toLowerCase();
			
			if (!poeSet.contains(reff3)){
				shortSetOnly.add(reff3);
			}
			
		}
		
		/*
		boolean found = false;
		
		for (int i = 0; i<shortS.length; i++){
			
			found = false;
			
			for (int j = 0; j<poeS.length; j++){
				
				String checker = poeS[j].toLowerCase();
				String checker2 = shortS[i].toLowerCase();
				
				if (checker.equals(checker2)){
					found = true;
					//bothShortAndPoe.add(checker2);
				}
			}
			if (!found)
			{
				shortSetOnly.add(shortS[i]);
			}
		}
		*/
		
		
		System.out.println("Words in both poeSet and shortSet");
		System.out.println(bothShortAndPoe.toString());
		System.out.println("\n");
		System.out.println("Words in ShortSet Only");
		System.out.println(shortSetOnly.toString());
	}

}
