package games;

public class Craps {
	int lastSum;
	int firstSum;
	int numPlayed;
	int numWon;
	boolean bLastResult;
	boolean wonOnce = false;
	boolean lostOnce = false;
	
	int numDice = 2;
	int numSides = 6;
	
	public int getFirstSum() {
		return firstSum;
	}
	
	public int getLastSum() {
		return lastSum;
	}
	public int getNumWon() {
		return numWon;
	}
	public boolean isbLastResult() {
		return bLastResult;
	}
	Dice[] dice;
	 
	// Constructor
	public Craps(){
		lastSum = -1;
		firstSum = -1;
		numPlayed = 0;
		numWon = 0;
		
		dice = new Dice[numDice];
		int i = 0;
		for (i=0; i<numDice; i++){
			dice[i] = new Dice(numSides);
		}
	}
	// roll all the dice and return the sum of their upward faces
	private int nextSum(){
		int localSum=0;
		int i = 0;
		for(i=0; i<numDice; i++)
		{
			dice[i].roll();
			localSum += dice[i].getSideUp();
		}
		
		lastSum = localSum;
		return localSum;
		
	} // end nextSum()
	
	
	public boolean play(){
		lastSum = -1;
		firstSum = -1;
		
		firstSum = nextSum();
		// roll the dice
		if ((7== firstSum )|| (11==firstSum)){
			numWon +=1;
			bLastResult = true;
			wonOnce = true;
			return true;
		}
		
		if ((2== firstSum )|| (3==firstSum) || (12 == firstSum)){
			bLastResult = false;
			lostOnce = true;
			return false;
		}
		 
		lastSum = nextSum();
		if(lastSum == firstSum){
			numWon +=1;
			bLastResult = true;
			wonOnce = false;
			lostOnce = false;
			return true;
		}
		else{
			bLastResult = false;
			wonOnce = false;
			lostOnce = false;
			return false;
		}
		}
	
	
	public String toString(){
		if ((wonOnce) || (lostOnce))
		{
			return "Craps game with " + numDice + " dice with " + numSides + " sides on the dice;\nFirst roll " + firstSum + "\nDid I win? " + bLastResult;
		}
		else{
			return "Craps game with " + numDice + " dice with " + numSides + " sides on the dice;\nFirst roll " + firstSum + " second roll " + lastSum + "\nDid I win? " + bLastResult;
		}
		
	}

public String playFourMoreTimes(){
		
		String firstGame = "";
		String secondGame = "";
		String thirdGame = "";
		String fourthGame = "";
		
		if (play()==true){
			firstGame = toString();
		}
		else{
			firstGame = toString();
		}
        
		if (play()==true){
			secondGame = toString();
		}
		else{
			secondGame = toString();
		}
		
		if (play()==true){
			thirdGame = toString();
		}
		else{
			thirdGame = toString();
		}
		
		if (play()==true){
			fourthGame = toString();
		}
		else{
			fourthGame = toString();
		}
		
	 
		return firstGame + "\n\n" + secondGame + "\n\n" + thirdGame +"\n\n" + fourthGame + ""; 
	
	}
	// keeping count of the amount of games won
	public int numberOfTimesWon(){
		return numWon;
	}
	// play new method
	public boolean playNew(){
		
		// if game becomes false then the game is over
		// the return value negates the winning outcome
		boolean game = true;
		while (game){
		
		firstSum = nextSum();
		
		if ((7== firstSum )|| (11==firstSum)){
			numWon +=1;
			bLastResult = true;
			wonOnce = true;
			game = false;
			return true;
		}
		
		if ((2== firstSum )|| (3==firstSum) || (12 == firstSum)){
			bLastResult = false;
			lostOnce = true;
			game = false;
			return false;
		}
		boolean test = true; 
		while (test){
		//keep rolling until sum is 7 or the same dice is rolled.
		lastSum = nextSum();
		
		if (lastSum == 7){
			bLastResult = false;
			game = false;
			test = false;
			return false;
		}
		
		if(lastSum == firstSum){
			
			numWon +=1;
			bLastResult = true;
			game = false;
			test = false;
			return true;
		}
		}
	
		}
		return false;
		
	}
		
	
		
		
	}
	
	
	
	
	


