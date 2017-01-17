import java.util.*;
public class Temperatures{
  public static void main(String[] args){
    Scanner console = new Scanner(System.in);
    System.out.println("Enter no. days ");
    int days = console.nextInt();
    int[] temps = new int[days];
    int sum=0;
    for(int i=0; i<temps.length; i++){
      System.out.println("Enter temp for day " + i );
      temps[i] = console.nextInt();
      sum= sum + temps[i];
    }
     double avg =(double) sum/days;
     System.out.println(" avg " + avg);
     int count=0;
    for(int i=0; i<temps.length; i++){
      if(temps[i] > avg)
        count++;
       }
    System.out.println(" no days temp. is above avg " + count);
    double var =0;
    for(int i=0; i<temps.length; i++){
      var=var+Math.pow(temps[i]-avg ,2);
    }
    var=var/temps.length;
    double stdv = Math.sqrt(var);
    System.out.println(" stdv " + stdv);
  }// end main
}