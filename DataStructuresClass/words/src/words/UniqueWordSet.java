package words;



import java.util.Iterator;


import jss2.ArraySet;
import jss2.SetADT;

public class UniqueWordSet {
	
	SetADT<StringCounter> mySet = null;
	
	public UniqueWordSet()
	{
		mySet = new ArraySet<StringCounter>();
	}
	
	public int getCount()
	{
		Iterator<StringCounter> iter = mySet.iterator();
		int sum = 0;
		
		while(iter.hasNext())
		{
			StringCounter theStringCounter = iter.next();
			int count = theStringCounter.getCount();
			sum += count;
		}
		
		return sum;
	}

	public int getCount(String word)
	{
		Iterator<StringCounter> iter2 = mySet.iterator();
		int count = 0;
		boolean found = false;
		
		while (iter2.hasNext() && !found)
		{
			StringCounter theSC = iter2.next();
			if (theSC.getString().equals(word))
			{
				found = true;
				count = theSC.getCount();
			}
		}
		
		return count;
	}
	
	public boolean isEmptpy()
	{
			return mySet.isEmpty();
	}
	
	public Iterator<StringCounter> iterator()
	{
		return mySet.iterator();
	}
	
	public String toString()
	{
		return mySet.toString();
	}
	
	public void updateCount(String word)
	{
		//do I have the word? if not, add it to the set; if yes, update count
		
		Iterator<StringCounter> iter3 = mySet.iterator();
		boolean found = false;
		
		while (iter3.hasNext())
		{
			StringCounter sc = iter3.next();
			if (sc.getString().equals(word))
			{
				found = true;
				sc.increment();
			}
		}
		
		if (!found)
		{
			StringCounter sc2 = new StringCounter(word);
			sc2.increment();
			mySet.add(sc2);
		}
	}
	
	public int getCountUnique()
	{
		return mySet.size();
	}
	
	public int averageWordLength(){
		
		Iterator<StringCounter> iter = mySet.iterator();
		int length =0;
		int size = mySet.size();
		int sum = 0;
		
		
		
		while(iter.hasNext()){
			int theStringCounter = iter.next().getString().length();
		 length = theStringCounter;
			sum += length;
			
			
		}
		
		
		return sum/size;
		
	}
	
}
