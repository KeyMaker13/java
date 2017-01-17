package departmentstorepkg;

import java.util.ArrayList;

public class DepartmentStore {
	//PART IV
	public String name;
	private ArrayList<Employee> empList;
	
	 /**
	    * Makes a department store with a certain name
	    *
	    * @param a string that gives the store its name
	    * 
	    */
	
	
	public DepartmentStore (String storeName){
		this.name = storeName;
		this.empList = new ArrayList<Employee>();
	}
	
	/**
	 * 
	 * 
	 * 
	 * returns a string that represents an employee object
	 */
	
	public String toString(){
		return this.getClass().toString() + ": " + name;
		
	}
	
	/**
	 * 
	 * 
	 * @param emp an employee parameter that is then added to the class array list
	 * 
	 */
	
	public void addEmployee(Employee emp){
		empList.add(emp);
	}
	
	/**
	 * prints out all the employees in the array list held in this class
	 */
	
	public void print(){
		for(int i = 0; i<empList.size();i++){
			System.out.println(empList.get(i).toString());
		}
	}
	
	/**
	 * 
	 * prints only instances of Employee objects
	 * 
	 */
	public void printEmployees(){
		//instanceof (think of it as an operator) comparing what kind of obj you are
		//finish the work on your own!!
		
		
		for(int i = 0; i<empList.size();i++){
			if(empList.get(i)instanceof Hourly ){
				
				
			}
			else if (empList.get(i) instanceof Executive){
				
			}
			else{
				System.out.println(empList.get(i).toString());
			}
			
		}
		
	}
	
	/**
	 * prints only instances of Executive objects
	 * 
	 */
	public void printExecutives(){
		//instanceof (think of it as an operator) comparing what kind of obj you are
		//finish the work on your own!!
		
		
		for(int i = 0; i<empList.size();i++){
			if(empList.get(i)instanceof Executive ){
				System.out.println(empList.get(i).toString());
				}
			
		}
	}
	
	/**
	 * 
	 * prints only instances of Hourly objects
	 */
	public void printHourly(){
		//instanceof (think of it as an operator) comparing what kind of obj you are
		//finish the work on your own!!
		for(int i = 0; i<empList.size();i++){
			if(empList.get(i)instanceof Hourly){
				
				System.out.println(empList.get(i).toString());
			}
			
		}
	}
	
	/**
	 * 
	 * @param ssn takes in a string social security number to match it with an employee in the array list
	 * @return returns the employee that is matched with the social security number string or null if the string is not valid
	 */
	
	public Employee findEmployee(String ssn){
		
		for(int i = 0; i<empList.size();i++){
			if(empList.get(i).socialSecurityNumber.compareTo(ssn) == 0){
				return empList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * 
	 * 
	 * @param ssn takes in a social security number to match it with an employee and it removes that employee 
	 */
	
	public void removeEmployee(String ssn){
		for(int i = 0; i<empList.size();i++){
			if(empList.get(i).socialSecurityNumber.compareTo(ssn) == 0){
				empList.remove(i);
			}
		}
	}
	
	/**
	 * 
	 * 
	 * @param emp takes in an employee object and matches it with an employee in the array list and then deletes that object
	 */
	
	public void removeEmployee(Employee emp){
		for(int i = 0; i<empList.size();i++){
			if(empList.get(i).compareTo(emp) == 0){
				empList.remove(i);
			}
		}
		
	}
	/**
	 * 
	 * @param ssn takes in a social security string to find the hourly object
	 * @param hours an integer named hours that will update the hours on an hourly object
	 * @return returns true if the hourly object is updated, returns false if the hourly object is not in the array list
	 */
	
	public boolean updateHours(String ssn, int hours){
		
		boolean r = false;
		
		if(findEmployee(ssn)  instanceof Hourly)
			 {
				((Hourly)findEmployee(ssn) ).addHours(hours);
				 r = true;
			 }
        if (r){
			return true;
		}
		else{
			return false;
		}
	}
	
}
		
	 

