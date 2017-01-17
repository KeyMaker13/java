package trysets;
import jss2.*;

import java.util.*;

public class IntegerSetTester {
  public static void main(String[] args) {
    System.out.println("Lab 2: Part I written by Ivan Capistran");
    System.out.println("Creating set1--------------------");
    SetADT<Integer> set1 = new ArraySet<Integer>();
    
    Random r = new Random();
    int max = 0;
    for (int i = 0; i <1000; i++)
    {
    	int number = 1+r.nextInt(50);
    	
    	set1.add(number);
    	if (number > max){
    		max = number;
    	}
    	
    }
    
    System.out.println(set1.toString());
    System.out.println("set1 size = " + set1.size() + "\n\n");

    Iterator<Integer> iter = set1.iterator();
    
    if (iter.hasNext())
    {
    	int test = iter.next();
    	
    	set1.remove(iter.next());
    }
    
    System.out.println(set1.toString());
    
  
  
  System.out.println("After Removal : " + set1.toString() +"\n");
  
  SetADT<Integer> set2 = new ArraySet<Integer>();
  
  for (int i = 0; i < 100; i++)
  {
	 set2.add(1 + r.nextInt(10));
  }
  
  Iterator<Integer> iter2 = set2.iterator();
  
  System.out.println("Set 2: \n" + set2.toString());
  
  SetADT<Integer> set3 = new ArraySet<Integer>();
  
  set3 = set1.union(set2);
  System.out.println("Set 3: \n" + set3.toString());
  System.out.println("The size of set 3  is :" + set3.size());
  
  // Create set4
  SetADT<Integer> set4 = new ArraySet<Integer>();
  
  set4 =  ((ArraySet<Integer>) set1).intersection(set2);
 
  System.out.println("Set 4: \n" + set4.toString());
  System.out.println("Size of set 4: " + set4.size());
  
  System.out.println("The max value in set1 is :" + max);
 
  }
}

