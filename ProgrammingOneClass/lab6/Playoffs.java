import java.util.*;

public class Playoffs
{
 
  public static void main (String[] args)
  {
    Scanner console = new Scanner(System.in);
    
    // print title and prompt user for information
    System.out.println("Lab 6 written by IVAN CAPISTRAN\n");
    System.out.println("Play off Simulation");
    System.out.println("Two teams will play each other 7 times.\nso the winning team will win 4 of these games.");
    System.out.println("You are a fan of team 1 so what percent is team 1 more likely to win?");
    System.out.println("Enter a percentage from 0 to 100");
    
    int p = console.nextInt();
    // test for correct input of information
    while (( p < 0) || (p >101))
    {  
       p = console.nextInt();
    }
     
    Random rand = new Random();
    // print scores and use methods created
    System.out.println("Team " + singleGame(p, rand) + " wins just one game");
    System.out.println();
    System.out.println("Team " + playOff(p, rand) + " wins the first play off");
    System.out.println();
    System.out.println("Team " + tenPlayOff(p, rand) + " wins 10 more play offs");
    
 }
  // method for single game
  public static int singleGame(int percent, Random r)
  {
     r = new Random();
    int gameRandom = 1 + r.nextInt(100);
    
    if (gameRandom < percent)
    {
      return 1;
    }
    else
    {
      return 2;
    }
  }
  // method for 1 play off
  public static int playOff(int percent, Random r)
  {
    r = new Random();
    
    int tally = 0; 
    int team1 = 0;
    int team2 = 0;
    while (tally <=7)
    {
      int gameRandom = 1 + r.nextInt(100);
      
      if (gameRandom < percent)
      {
        team1++;
      }
      else
      {
        team2++;
      }
      tally++;
    }
    if (team1 > team2)
    {
      return 1;
    }
    else
    {
      return 2;
    }
  }
  // method for 10 playoffs
  public static int tenPlayOff(int percent, Random r)
  {
     r = new Random();
    int tally = 0; 
    int team1 = 0;
    int team2 = 0;
    int team1tally = 0;
    int team2tally = 0;
    
    while ((team1tally < team2tally + 10) || (team2tally < team1tally + 10))
    {
    while (tally <=7)
    {
      int gameRandom = 1 + r.nextInt(100);
      
      if (gameRandom < percent)
      {
        team1++;
      }
      else
      {
        team2++;
      }
       tally++;
    }
      if (team1 > team2)
    {
      team1tally++;
    }
    else
    {
      team2tally++;
    }
   }
    if (team1tally > team2tally)
    {
      return 1;
    }
    else
    {
      return 2;
    }
    
  
  
    
}
}
  