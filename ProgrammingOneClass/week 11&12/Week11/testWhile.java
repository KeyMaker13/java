public class testWhile{
  public static void main(String[] args){
    double r = Math.random();
    int c=1;
    System.out.println("r= " + r );
    while(r<0.5){
      r=Math.random();
       c++;
    System.out.println("r= " + r );
    }
    System.out.println("c= " + c);
    System.out.println("divide by 2"); // next divide by 2
    int num=-100;
    do{
      System.out.print( " " + num);
      num = num/2;
     }while(num != 0);
    
     System.out.println( " " + num); 
     System.out.println("divide by 10");// divide by 10
     num=-1048576;
     while(num !=0){
       System.out.print(" " + num);
       num=num/10;
     }
      System.out.println(" " + num);
      System.out.println("HailStone");
      num=17;
      System.out.print(" " + num);
      while(num !=1){
        if(num%2 ==1){
          num=3*num+1;
        }
        else{
          num=num/2;
        }
        System.out.print(" " + num );
      }
       System.out.println(); 
      System.out.println("Fibonacci");
      int npr=0, ncur=1, sum=0;
      while(ncur < 100){
        System.out.print(" " + npr);
        sum=npr+ncur;
        npr=ncur;
        ncur=sum;
        
      }
       System.out.print(" " + npr);
       System.out.println(); 
  }// end main
}