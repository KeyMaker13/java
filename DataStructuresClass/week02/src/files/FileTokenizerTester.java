package files;

/**
 * <p>Title: FileTokenizerTester </p>
 *
 * <p>Description: Illustrate the use of file tokenizer </p>
 *
 * <p>Company: UTSA </p>
 * @author Weining Zhang
 * @version 1.0
 */
public class FileTokenizerTester {
   public static void main(String[] args) {
      FileTokenizer afile = new FileTokenizer("home.html");
      System.out.println("Processing " + afile.getName());
      while (afile.hasNext())
         System.out.println(afile.next());
       System.out.println("finish processing " + afile.getName());


      FileTokenizer junkfile = new FileTokenizer("junk");
      System.out.println("Processing " + junkfile.getName());
      while (junkfile.hasMoreElements())
         System.out.println(junkfile.nextElement());
       System.out.println("Finish processing " + junkfile.getName());

      FileTokenizer nullfile = new FileTokenizer(null);
      System.out.println("Processing " + nullfile.getName());
      while (nullfile.hasMoreElements())
         System.out.println(nullfile.nextElement());
       System.out.println("Finish processing " + nullfile.getName());
   }
}
