package games;

public class crapsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Craps (lab02) written by Ivan Capistran");
		//first craps game
		Craps crapsGame = new Craps();
		if (crapsGame.play()){
			System.out.println("You Won!");
		}
		else {
			System.out.println("You Lost!");
		}
		System.out.println(crapsGame.toString());
		//System.out.println("First roll "+ crapsGame.getFirstSum());
		//System.out.println("Last roll "+ crapsGame.getLastSum());
		
		System.out.println("\nNow you Will play four more times");
		System.out.println(crapsGame.playFourMoreTimes());
		System.out.println("\n");
		
		// crapsGame2
		Craps crapsGame2 = new Craps();
		
		for (int i =1; i<=10000; i++){
			crapsGame2.play();
		}
		System.out.println("Out of " + 10000 + " games you won " + crapsGame2.numberOfTimesWon() + " times");
		System.out.println("The probability of winning in craps is "+ ((double)crapsGame2.numberOfTimesWon()/10000));
		
		// crapsGame3.playNew();
		System.out.println("\n\nThis 10000 game emulation is created from the crapsGame3.playNew() method");
		
		Craps crapsGame3 = new Craps();
		for (int i =1; i<=10000; i++){
			crapsGame3.playNew();
		}
		System.out.println("Out of " + 10000 + " games you won " + crapsGame3.numberOfTimesWon() + " times");
		System.out.println("The probability of winning in craps is "+ ((double)crapsGame3.numberOfTimesWon()/10000));
		
		

	}

}
