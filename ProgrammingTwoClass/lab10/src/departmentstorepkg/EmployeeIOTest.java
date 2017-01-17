package departmentstorepkg;

import java.util.*;

public class EmployeeIOTest {
   public static void main(String[] args) {
      System.out.println("CS 1723 Lab 10 Part II: written by Ivan Capistran");
      
      EmployeeIO empIn = new EmployeeIO("employees.txt");
      
      ArrayList<Employee>empList = new ArrayList<Employee>();
     
       //while another employee to read
      while(empIn.hasNext()){
     	 Employee emp = empIn.next();
     	 empList.add(emp);
     	 
    // System.out.println("Employee information is: " + emp.toString());
     	 
      }
      Comparable [] empArray  = new Comparable [empList.size()];
      empArray = (Comparable[])(empList.toArray(empArray));
      Arrays.sort(empArray);
      for (int i = 0; i<empArray.length;i++){
      System.out.println(empArray[i].toString());
      }
   }
}
