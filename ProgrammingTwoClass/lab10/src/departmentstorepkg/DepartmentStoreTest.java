package departmentstorepkg;

import java.util.ArrayList;

public class DepartmentStoreTest {
  public static void main(String[] args) {
    System.out.println("CS 1713 Lab 10 Part IV: written by Ivan Capistran");
    System.out.println();
    DepartmentStore store = new DepartmentStore("Allied Service Department Store");
    System.out.println();
    EmployeeIO empIn = new EmployeeIO("employees.txt");    
    //while another employee to read
    while(empIn.hasNext()){
   	 store.addEmployee(empIn.next());
    }
  
    System.out.println("My store: " + store.toString());
    System.out.println("Here are the people in the store: ");
   
    System.out.println("Testing print method in department store class");
    store.print();
   System.out.println();
  
   System.out.println("Testing printEmployees method in departmentStore class");
   store.printEmployees();
   System.out.println();
  
   System.out.println("Testing printExecutives method in departmentStore class");
   store.printExecutives();
   System.out.println();
  
   System.out.println("Testing printHourly method in departmentStore class");
   store.printHourly();
   System.out.println();
  
   System.out.println("Testing findEmployee method in departmentStore class");
   System.out.println(store.findEmployee("222-22-2222"));
   System.out.println(store.findEmployee("123-45-6789"));
   System.out.println(); 
   
   System.out.println("Testing removeEmployee method in departmentStore class");
   System.out.println("using both removeEmployee(String ssn) and removeEmployee(Employee emp)");
  Employee temp1 = store.findEmployee("123-45-6789");
   store.removeEmployee("123-45-6789");
   System.out.println(store.findEmployee("123-45-6789"));
  // using removeEmployee(Employee emp)
   Employee temp2 = store.findEmployee("323-23-5666");
   store.removeEmployee(store.findEmployee("323-23-5666"));
   System.out.println(store.findEmployee("323-23-5666"));
   System.out.println("adding employees back in");
   store.addEmployee(temp1);
   store.addEmployee(temp2);
   System.out.println(store.findEmployee("123-45-6789"));
   System.out.println(store.findEmployee("323-23-5666"));
   System.out.println(); 
   
   
   System.out.println("Testing return output for updateHours method in departmentStore class");
   System.out.println(store.updateHours("212-33-6978", 0));
   System.out.println(store.updateHours("222-22-2222", 20));
   System.out.println();
  
   System.out.println("Testing hourly hours update for updateHours method in departmentStore class");
   System.out.println(store.updateHours("212-33-6978", 20));
   System.out.println(store.updateHours("658-45-9234", 40));
   store.printHourly();
   System.out.println();
   System.out.println("Testing awardBonus method in Executive class");
   ((Executive)store.findEmployee("123-45-6789")).awardBonus(1000.50);
   ((Executive)store.findEmployee("623-34-2399")).awardBonus(1240.50);
   ((Executive)store.findEmployee("345-67-8934")).awardBonus(1220.50);
   store.printExecutives();
   
   
   
    
  }
}
