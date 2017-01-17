package departmentstorepkg;

//********************************************************************
//  Employee.java       Author: Lewis and Loftus
//
//  Represents a general paid employee.
//********************************************************************

public class Employee extends StaffMember implements Comparable<Object> {
   protected String socialSecurityNumber;
   protected double payRate;
  
   /**
    * Sets up an employee with the specified information.
    *
    * @param name The full name of the employee
    * @param address The residential address for the employee
    * @param phone Employees's phone number to reach in an emergency
    * @param socialSecurityNumber the ssn for this employee
    * @param payRate how much does the employee get paid
    * 
    */
   
   public Employee(String name, String address, String phone,
                   String socialSecurityNumber, double payRate) {
      super(name, address, phone);
      this.socialSecurityNumber = socialSecurityNumber;
      this.payRate = payRate;
   }
   
   /**
    * Returns information about an employee as a string.
    *
    * @return the human readable string representing this object
    */
   
   
   public String toString() {
      String result = super.toString();
      result += "\nSocial Security Number: " + socialSecurityNumber;
      return result;
   }


   /**
    * Returns the pay rate for this employee.
    *
    * @return the pay rate for this employee
    */
   
   public double pay() {
      return payRate;
   }


   /**
    * compare this object to the one you pass in, to figure out
    * whether we are equal, less, or greater.
    * 
    * @param other is the object we are comparing to
    * @return 0 for equal, - for less, +for greater
    */


public int compareTo(Object other) {
	//checking if two employees are the same
	//where and how do I check for LESS (-) and GREATER (+) check event class as guidance to do this
	
	Employee otherEmployee = (Employee)other;
	if(otherEmployee.name.compareTo(this.name) == 0){
		
		return 0;
	}
	else if (otherEmployee.name.compareTo(this.name)> 0){
		return -1;
	}
	else {
		return 1;
	}
	
	
}
}
