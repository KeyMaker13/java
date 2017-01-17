package departmentstorepkg;

import java.io.*;
import java.util.*;

/**
 * Class that provides an iterator type interface for files
 * containing information about employee objects
 *
 * @version 1.0
 */
public class EmployeeIO {
   private String fileName;
   private BufferedReader infile;
   private Employee nextOne;

   /**
    * Initializes a newly-created EmployeeIO object
    *
    * @param filename Name of a text file containing ascii representations of
    *   employees. <P></P>
    *   Each employee is represented by six lines of text:
    *   <PRE>
    *   type (x, X, e, E, h, H)<BR>
    *   name<BR>
    *   address<BR>
    *   telephone number<BR>
    *   social security number<BR>
    *   pay<BR>
    *   </pre>
    *   <P></P>For example:
    *   <PRE>
    *   x <BR>
    *   Mary Jones<BR>
    *   123 Main Line<BR>
    *   555-0469<BR>
    *   123-45-6789<BR>
    *   1923.07<BR>
    *   </PRE>
    *   <P></P>
    *    represents an executive named Mary Jones.
    */
   public EmployeeIO(String filename) {
      fileName = filename;
      openFile();
      nextOne = getNext();
   }

   /**
    * returns true if there is another employee to be read from the file
    *
    * @return true if another employee can be read from the file or <BR>false
    *   if at the end of the file or an error occurred
    */
   public boolean hasNext() {
      return nextOne != null;
   }

   /**
    * returns an Employee (or one of its subclasses) constructed from the
    * information about the next employee in the file
    *
    * @return next Employee object in the file
    */
   public Employee next() {
      if (nextOne == null)
         throw new NoSuchElementException("No more staff members");
      Employee temp = nextOne;
      nextOne = getNext();
      return temp;
   }

   /**
    * returns a String representation of EmployeeIO
    *
    * @return String containing information about the file
    */
   public String toString() {
      return "[" + fileName + "]";
   }
   
   private Employee getNext() {
      if (infile == null)
         return null;
      try {
         String typeString = infile.readLine().trim();
         char type = typeString.charAt(0);
         String name = infile.readLine().trim();
         String address = infile.readLine();
         String phone = infile.readLine().trim();
         String socialSecurity = infile.readLine().trim();
         double pay = Double.valueOf(infile.readLine().trim()).doubleValue();
         switch (type) {
            case 'e':
            case 'E':
               return new Employee(name, address, phone, socialSecurity, pay);
            case 'x':
            case 'X':
               return new Executive(name, address, phone, socialSecurity, pay);
            case 'h':
            case 'H':
               return new Hourly(name, address, phone, socialSecurity, pay);
         }
      } catch (Exception e) { }
      closeFile();
      return null;
   }

   private void closeFile() {
      if (infile == null)
         return;
      try {
         infile.close();
      } catch (IOException e) {}
   }

   private void openFile() {
      infile = null;
      try {
         FileReader fr = new FileReader(fileName);
         infile = new BufferedReader(fr);
      } catch (IOException e) {System.err.println("Didn't open " + fileName);
      }
   }
}
