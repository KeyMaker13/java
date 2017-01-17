package graph;
import java.util.*;
import java.io.*;
public class RandomHamlet {
	// class constant for random numbers
	static final Random random = new Random(42);
	
	public static void main(String[] args) 
		throws FileNotFoundException {
		Scanner hamlet =
			new Scanner(new File("hamlet.txt"));
		GraphADT<String> graph =
			new AdjacencyListGraph<String>();
		String previous = hamlet.next();
		while (hamlet.hasNext()) {
			String word = hamlet.next();
			// System.out.println(word);
			graph.addEdge(previous, word);
			previous = word;
		}
		
		// write 50 words from Hamlet
		// start with some word from Hamlet
		// loop 49 times to find next word
		String current = "To";
		System.out.print(current);
		for (int i = 0; i < 49; i++) {
			String next = 
				randomNextWord(graph, current);
			if (i % 8 == 7)
				System.out.println();
			System.out.print(" " + next);
			current = next;
		}
	}
	
	public static String 
		randomNextWord(GraphADT<String> graph,
				       String current) {
		// get size of list
		Iterator<String> iter =
			graph.verticesFrom(current);
		int size = 0;
		while (iter.hasNext()) {
			iter.next();
			size++;
		}
		// generate a random index
		// Random random = new Random();
		int r = random.nextInt(size);
		// iterate through list again to that index
		int i = 0;
		iter = graph.verticesFrom(current);
		while (iter.hasNext()) {
			if (i == r) return iter.next();
			iter.next();
			i++;
		}
		return "fie";
	}

}





