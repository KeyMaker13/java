package balance;

public class BalanceCheckerTester {
  public static void main(String[] args) {
     System.out.println("CS 1723 Lab 5: written by Ivan Capistran");
     
     BalanceChecker test1=new BalanceChecker("(a+(b*c3)+d)");
     BalanceChecker test2=new BalanceChecker("(a+(b+dog+cat)");
     BalanceChecker test3=new BalanceChecker("a+b+(c+d");
     BalanceChecker test4=new BalanceChecker("a+b+(c+d))+e");
     BalanceChecker test5=new BalanceChecker("(((a+b+(c+d)+e");
     BalanceChecker test6=new BalanceChecker("()()(())");
     
     BalanceCheckerAdvance test7 = new BalanceCheckerAdvance("{}[a+(b+c)]{d+e}");
     BalanceCheckerAdvance test8 = new BalanceCheckerAdvance("a+{[a+b}]");
     BalanceCheckerAdvance test9 = new BalanceCheckerAdvance("a+[b+c(");
     BalanceCheckerAdvance test10 = new BalanceCheckerAdvance("a+d+(c-d)]");
     BalanceCheckerAdvance test11 = new BalanceCheckerAdvance("(f+gh+s+[g+g+g]");
     BalanceCheckerAdvance test12 = new BalanceCheckerAdvance("a+b+c[d+s+{d+a+b]");
     BalanceCheckerAdvance test13 = new BalanceCheckerAdvance("{f+i+j)+gj+ab+{}+gh)");
     
    
     

     System.out.println(test1.toString());
     System.out.println(test2.toString());
     System.out.println(test3.toString());
     System.out.println(test4.toString());
     System.out.println(test5.toString());
     System.out.println(test6.toString());

     System.out.println("\n-----Checking Balanced and Index of Delimiter------\n");

     System.out.println(test1.toString()+", Balanced : "+test1.isBalanced()+", Position : "+test1.getPosition());
     System.out.println(test2.toString()+", Balanced : "+test2.isBalanced()+", Position : "+test2.getPosition());
     System.out.println(test3.toString()+", Balanced : "+test3.isBalanced()+", Position : "+test3.getPosition());
     System.out.println(test4.toString()+", Balanced : "+test4.isBalanced()+", Position : "+test4.getPosition());
     System.out.println(test5.toString()+", Balanced : "+test5.isBalanced()+", Position : "+test5.getPosition());
     System.out.println(test6.toString()+", Balanced : "+test6.isBalanced()+", Position : "+test6.getPosition());

     System.out.println();
     System.out.println("-----------------------BalanceCheckerAdvance----------------------");
     System.out.println(test7.toString());
     System.out.println(test8.toString());
     System.out.println(test9.toString());
     System.out.println(test10.toString());
     System.out.println(test11.toString());
     System.out.println(test12.toString());
     System.out.println(test13.toString());
     System.out.println("\n-----Checking Balanced and Index of Delimiter------\n");
     System.out.println(test7.toString()+", Balanced : "+test7.isBalanced()+", Position : "+test7.getPosition());
     System.out.println(test8.toString()+", Balanced : "+test8.isBalanced()+", Position : "+test8.getPosition());
     System.out.println(test9.toString()+", Balanced : "+test9.isBalanced()+", Position : "+test9.getPosition());
     System.out.println(test10.toString()+", Balanced : "+test10.isBalanced()+", Position : "+test10.getPosition());
     System.out.println(test11.toString()+", Balanced : "+test11.isBalanced()+", Position : "+test11.getPosition());
     System.out.println(test12.toString()+", Balanced : "+test12.isBalanced()+", Position : "+test12.getPosition());
     System.out.println(test13.toString()+", Balanced : "+test13.isBalanced()+", Position : "+test13.getPosition());

     
     
     
     
  }
}
