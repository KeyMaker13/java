import java.util.*;

public class Trucks {
	
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Bonus by Ivan Capistran");
		
		System.out.println("How many days were used for loading trucks?");
		int days = scan.nextInt();
		while (days<3 || days >31){
			System.out.println("The value must be from 3 days to 31 days");
			days = scan.nextInt();
		}
		
		
		
		System.out.println("The average amount of trucks loaded per day is " + averageTrucks(days));
		
	}
		public static double averageTrucks (int n){
			
			int numberOfTrucks=0;
			int count=0;
			Scanner scan = new Scanner(System.in);
			
			for (int i = 1; i <=n; i++){
				System.out.println("How many trucks were loaded on day "+ i +" ");
				numberOfTrucks = scan.nextInt();
				count += numberOfTrucks;
				
			}
			
			
			
			double average = (double)(count/n);
		
			return average;
		
		}
		
		
		
	}


