package departmentstorepkg;

  /**
   * Base class for employees
   *
   * @author Lewis and Loftus
   * @version 1.0
   */
public abstract class StaffMember {

   /**
    * staff member name
    */
   protected String name;

   /**
    * staff member address
    */
   protected String address;

   /**
    * staff member telephone number
    */
   protected String phone;

   /**
    * initializes a newly-created StaffMember object
    *
    * @param name staff member's name
    * @param address staff member's address
    * @param phone staff member's phone number
    */
   public StaffMember(String name, String address, String phone) {
      this.name = name;
      this.address = address;
      this.phone = phone;
   }

   /**
    * returns a String representation of this object
    *
    * @return String
    */
   public String toString() {
      String result = getClass().getName()+ "\nName: " + name + "\n";
      result += "Address: " + address + "\n";
      result += "Phone: " + phone;
      return result;
   }

   /**
    * abstract method representing the rate of pay for this staff member
    *
    * <P></P> <B>Note:</B> Employees are typically paid hourly, weekly or
    * monthly depending on their type. The subclasses of StaffMember provide the
    * details.
    *
    * @return pay rate over the period specific for the type of staff member
    */
   public abstract double pay();
}
