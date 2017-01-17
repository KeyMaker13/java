    package collections;
     
    import java.util.ArrayList;
    import java.util.Iterator;
    import java.util.Random;
     
    public class ArrayListTester {
     
            /**
             * @param args
             */
            public static void main(String[] args) {
                    ArrayList<Integer> a2 = new ArrayList<Integer>();
                    Random rand = new Random();
                   
                    for(int i = 0; i < 10; i++) {
                            a2.add(new Integer(rand.nextInt()));
                    }
                   
                    for(int i = 0; i < a2.size(); i++) {
                            System.out.println(a2.get(i).intValue());
                    }
                   
                    // Print out the array using an iterator
                    Iterator<Integer> iter = a2.iterator();
                    while(iter.hasNext())
                            System.out.println(iter.next());
                           
                    // compute the sum using iterator
            }
     
    }
