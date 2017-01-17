package departmentstorepkg;

//********************************************************************
//  Executive.java       Author: Lewis and Loftus
//
//  Represents an executive staff member, who can earn a bonus.
//********************************************************************

public class Executive extends Employee {
   private double bonus;

   //-----------------------------------------------------------------
   //  Sets up an executive with the specified information.
   //-----------------------------------------------------------------
   public Executive(String name, String address, String phone,
                    String socialSecurityNumber, double payRate) {
      super(name, address, phone, socialSecurityNumber, payRate);
      bonus = 0; // bonus has yet to be awarded
   }

   //-----------------------------------------------------------------
   //  Awards the specified bonus to this executive.
   //-----------------------------------------------------------------
   public void awardBonus(double execBonus) {
      bonus = execBonus;
   }

   //-----------------------------------------------------------------
   //  Computes and returns the pay for an executive, which is the
   //  regular employee payment plus a one-time bonus.
   //-----------------------------------------------------------------
   public double pay() {
      double payment = super.pay() + bonus;
      bonus = 0;
      return payment;
   }
   
   public String toString() {
	      String result = super.toString();
	      result += "\nBonus: " + bonus;
	      return result;
	   }
}
