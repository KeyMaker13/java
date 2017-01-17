import java.io.*;
class Test {
    public static void main(String[] arg) throws Exception {
	TypingTutor t = new TypingTutor();
	long result = t.test();
	if (result > 0) {
	    System.out.print("Your time was ");
	    System.out.println(result/1000 + " seconds.");
	} else
	    System.out.println("You did not type correctly.");
	System.out.println();
	result = t.test();
	if (result > 0) {
	    System.out.print("Your time was ");
	    System.out.println(result/1000 + " seconds.");
	} else
	    System.out.println("You did not type correctly.");
	System.out.println();
	result = t.test();
	if (result > 0) {
	    System.out.print("Your time was ");
	    System.out.println(result/1000 + " seconds.");
	} else
	    System.out.println("You did not type correctly.");
	int perfCount = t.getNumPerfect();
	if (perfCount > 0) {
	    long lowestTime = t.getLowestTime();
	    System.out.print("Your best time was ");
	    System.out.println(lowestTime/1000 + " seconds.");
	} else
	    System.out.println("You failed all 3 tests!");
	t.setPracticeString("Exotic zebras jaywalk with impunity.");
        result = t.test();
	if (result > 0) {
	    System.out.print("Your time was ");
	    System.out.println(result/1000 + " seconds.");
	}
	else
	    System.out.println("You did not type correctly.");
	System.out.println();
	result = t.test();
	if (result > 0) {
	    System.out.print("Your time was ");
	    System.out.println(result/1000 + " seconds.");
	}
	else
	    System.out.println("You did not type correctly.");
	System.out.println();
	result = t.test();
	if (result > 0) {
	    System.out.print("Your time was ");
	    System.out.println(result/1000 + " seconds.");
	}
	else
	    System.out.println("You did not type correctly.");
    }
}
