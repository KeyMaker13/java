import java.util.*;

public class StarWarsName
  {
  public static void main (String[] args)
  {
   
   // title 
   System.out.println("Star wars name generator\n");
  
   // user prompt
   String firstName = promptString("Enter your first name: " );
   firstName = firstName.trim();
   String lastName = promptString ("Enter your last name : ");
   lastName = lastName.trim();
   String maidenName = promptString ("Enter your mother's maiden name : ");
   maidenName = maidenName.trim();
   String city = promptString ("Enter the city you were born in : ");
   city = city.trim();
   String car = promptString ("Enter the first car you drove: ");
   car = car.trim();
   
   // make star wars name
   String fN = firstName.substring(0,3) + lastName.substring(0,2);
   String lN = maidenName.substring(0,2) + city.substring(0,3);
   String planet = lastName.substring(lastName.length()-2,lastName.length()) + car;
   
   // print out name
   System.out.println("Your are " + fN.toUpperCase() + " " + lN.toUpperCase() + " " + planet.toUpperCase());
   
  }
  //prompt method
  public static String promptString(String line)
   {
     Scanner console = new Scanner(System.in);
     
     System.out.print(line);
     
    
     return console.nextLine();
   }
}

