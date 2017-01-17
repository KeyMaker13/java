// 3/26/2012 on part 3
// 3/27/2012 on part 3
// 3/28/2012 finished part 3 working on part 4
// 3/30/2012 did part 5 and finishing up part 4
// 3/30/2012 did part 6 and still working on part 4

package pr3;

import java.awt.Color;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFrame;




public class TemperatureMain {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	private static TemperaturePredictionList list;
	private static DailyTemperatureList dList;

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws FileNotFoundException {

		JFrame frame = new JFrame("Project 3 By Ivan Capistran, Predicted highs and lows and actual temperature for month of March 2012");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		list = new TemperaturePredictionList();
		dList = new DailyTemperatureList();

		System.out.println("Project 3 by Ivan Capistran\n");

		Scanner scan = new Scanner(new FileInputStream("daily_predictions.txt"));
		Scanner scanA = new Scanner(new FileInputStream("daily_temperature.txt"));

		String fileName = "";
		String source = "";

		String fileNameA = "";
		String sourceA = "";

		try {
			fileName = scan.nextLine();
			source = scan.nextLine();

			fileNameA = scanA.nextLine();
			sourceA = scanA.nextLine();

			while (scan.hasNextLine()) {
				list.addFromDescriptor(scan.nextLine());
			}
			while (scanA.hasNextLine()) {
				list.setActualTemperature(scanA.nextLine());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("daily_temperature.txt");
		System.out.println(fileName);
		System.out.println(source);
		System.out.println();
		System.out.println("daily_temperature.txt");
		System.out.println(fileNameA);
		System.out.println(sourceA);
		System.out.println();
		list.print();
		
		// quality check method wont work so I am doing it manually here
		for (int i = 0; i<list.size();i++){
			int temp = 0;
			if( list.getTemperaturePredictionObject(i).getActualLow() > list.getTemperaturePredictionObject(i).getActualHigh()){
				temp =	list.getTemperaturePredictionObject(i).getActualLow();
				list.getTemperaturePredictionObject(i).setActualLow(list.getTemperaturePredictionObject(i).getActualHigh());
				list.getTemperaturePredictionObject(i).setActualHigh(temp);
			}
			//list.qualityCheck(Integer.toString(list.getTemperaturePredictionObject(i).getActualLow()),Integer.toString(list.getTemperaturePredictionObject(i).getActualHigh()));
			int tempA = 0;
			for (int j = 1 ; j <list.DATA_SIZE; j++){
				if ( list.getTemperaturePredictionObject(i).getPredictedLow(j) > list.getTemperaturePredictionObject(i).getPredictedHigh(j)){
					tempA = list.getTemperaturePredictionObject(i).getPredictedLow(j);
					list.getTemperaturePredictionObject(i).setPredictedLow(j, list.getTemperaturePredictionObject(i).getPredictedHigh(j));
					list.getTemperaturePredictionObject(i).setPredictedHigh(j, tempA);
				}
				//list.qualityCheck(Integer.toString(list.getTemperaturePredictionObject(i).getPredictedLow(j)),Integer.toString(list.getTemperaturePredictionObject(i).getPredictedHigh(j)));
			}
		}


		for (int i = 0; i < list.size(); i++) {
			dList.addData(list.getTemperaturePredictionObject(i), list);	
		}
		dList.print();

		// Working on graphPanel here
		String yLabel[] = {"20","30","40","50","60","70","80","90","100"};
		GraphPanel g = new GraphPanel(30,25,35,22);
		g.setYLabels(yLabel);
		String lows = "Actual Lows";
		String highs = "Actual Highs";
		g.addKey(0, 50, lows, Color.blue);
		g.addKey(0, 20, highs, Color.red); 

		lows = "Predicted Lows 1";
		highs = "Predicted highs 1";
		g.addKey(100, 50, lows, Color.green);
		g.addKey(100, 20, highs, Color.black);

		lows = "Predicted Lows 2";
		highs = "Predicted highs 2";
		g.addKey(200, 50, lows, Color.orange);
		g.addKey(200, 20, highs, Color.orange);

		lows = "Predicted Lows 3";
		highs = "Predicted highs 3";
		g.addKey(300, 50, lows, Color.black);
		g.addKey(300, 20, highs, Color.black);

		lows = "Predicted Lows 4";
		highs = "Predicted highs 4";
		g.addKey(400, 50, lows, Color.lightGray);
		g.addKey(400, 20, highs, Color.lightGray);

		lows = "Predicted Lows 5";
		highs = "Predicted highs 5";
		g.addKey(500, 50, lows, Color.cyan);
		g.addKey(500, 20, highs, Color.cyan);

		lows = "Predicted Lows 6";
		highs = "Predicted highs 6";
		g.addKey(600, 50, lows, Color.gray);
		g.addKey(600, 20, highs, Color.gray);

		lows = "Predicted Lows 7";
		highs = "Predicted highs 7";
		g.addKey(700, 50, lows, Color.yellow);
		g.addKey(700, 20, highs, Color.yellow);

		lows = "Predicted Lows 8";
		highs = "Predicted highs 8";
		g.addKey(800, 50, lows, Color.DARK_GRAY);
		g.addKey(800, 20, highs, Color.DARK_GRAY);

		lows = "Predicted Lows 9";
		highs = "Predicted highs 9";
		g.addKey(900, 50, lows, Color.magenta);
		g.addKey(900, 20, highs, Color.magenta);

		// creating graph objects from values in the list
		Graph actualLows;
		Graph actualHighs;
		Graph predictedHighs;
		Graph predictedLows;
		int[] valuesL = new int[dList.size()];
		int[] valuesH = new int[dList.size()];
		int[] valuesPL = new int[dList.size()];
		int[] valuesPH = new int[dList.size()];

		// grabs actual low and high from each day and stores it an array to be passed into one graph object 
		for (int j = 0; j<dList.size();j++){
			valuesL[j] = dList.get(j).getActualLow();
			valuesH[j] = dList.get(j).getActualHigh();
		}
		actualLows = new Graph(valuesL, Color.blue);
		actualHighs = new Graph(valuesH, Color.red);
		g.addGraph(actualLows);
		g.addGraph(actualHighs);


		for (int k = 1; k<dList.DATA_SIZE; k++){
			for (int j = 0; j<dList.size();j++){
				valuesPL[j] = dList.get(j).getPredictedLow(k);
				valuesPH[j] = dList.get(j).getPredictedHigh(k);
			}
			if (k == 1){
				predictedLows = new Graph(valuesPL, changeColor(k));
				predictedHighs = new Graph(valuesPH, changeColor(10));
			}
			else{
				predictedLows = new Graph(valuesPL, changeColor(k));
				predictedHighs = new Graph(valuesPH, changeColor(k));
			}
			g.addGraph(predictedLows);
			g.addGraph(predictedHighs);
			valuesPL = new int[dList.size()];
			valuesPH = new int[dList.size()];

		}
		//////////////////////////
		/////////////////////////
		///////////////////////
		///////////////////////
		// PART 2
		
		String l2 ="";
		
		
		// going to graph the average of predictions high/ low for each day
		int[] average = new int[dList.size()];
		Graph av;
		int avg =0;
		int aC = 0;
		int a=0;
		
		for (int i = 0 ; i < dList.size(); i ++){
			
			for (int k = 1; k< dList.DATA_SIZE; k++){
				if (dList.get(i).getPredictedHigh(k) == Integer.MIN_VALUE ){
				
				}
				else{
				a += dList.get(i).getPredictedHigh(k);
				aC++;
				}
	
			}
			if (aC == 0){
				aC +=1;
			}
			else{
			
			}
			avg = (a/(aC));
			average[i] = avg;	
			
			
		}
		l2 = "Average Temperatures High";
		g.addKey(200, 80, l2 , new Color(200,100,200));
		av = new Graph(average, changeColor(12));
		g.addGraph(av);
		average = new int[dList.size()];
		aC = 0;
		a=0;
		// low values
	
for (int i = 0 ; i < dList.size(); i ++){
			for (int k = 1; k< dList.DATA_SIZE; k++){
			if (dList.get(i).getPredictedLow(k) == Integer.MIN_VALUE ){
					
			}
			else{
			a += dList.get(i).getPredictedLow(k);
			aC++;
			}
			}
			if (aC == 0){
				aC +=1;
			}
			else{
			}
			avg = (a/(aC));
			average[i] = avg;	
		}
		l2 = "Average Temperatures Low";
		g.addKey(400, 80, l2 , new Color(80,200,80));
		av = new Graph(average, changeColor(13));
		g.addGraph(av);
		
		int[] difference = new int[dList.size()];
		Graph diff;
		
		for (int i = 0; i<dList.size(); i++){
			
		difference[i] = (dList.get(i).getActualHigh() - dList.get(i).getActualLow() );
		}
			diff = new Graph(difference, changeColor(11));
			l2 = "Difference of Actual and Low";
			g.addGraph(diff);
			g.addKey(0, 80, l2 , Color.pink);
	



		frame.getContentPane().add(g);
		frame.pack();
		frame.setVisible(true);

		PrintWriter out;
		String filename = "daily_results.txt";

		try {
			out = new PrintWriter(new PrintWriter(filename), true);

			for (int i = 0; i < dList.size(); i++) {
				out.println(dList.get(i).toString());
			}
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("Oh my the file could not be read....it is the end of the world now!!!!");
		}
	}

	public static Color changeColor (int x){
		if (x==1){
			return Color.green;
		}
		else if (x==2){
			return Color.orange;
		}
		else	if (x==3){
			return Color.black;
		}
		else	if (x==4){
			return Color.lightGray;
		}
		else	if (x==5){
			return Color.cyan;
		}
		else if (x==6){
			return Color.gray;
		}
		else if (x==7){
			return Color.yellow;
		}
		else if (x==8){
			return Color.DARK_GRAY;
		}
		else if (x==9){
			return Color.magenta;
		}
		else if (x==10){
			return Color.black;
		}
		else if (x ==11){
			return Color.pink;
		}
		else if (x ==12){
			return new Color(200,100,200);
		}
		else if (x==13){
			return new Color(80,200,80);
		}
		else{
			return Color.black;
		}
	}
}
