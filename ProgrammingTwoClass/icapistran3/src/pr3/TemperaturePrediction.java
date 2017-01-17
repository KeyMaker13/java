package pr3;

public class TemperaturePrediction extends Temperature
{



	// test this class
	/*
	 * public static void main (String[] args){ // new object
	 * TemperaturePrediction test = new TemperaturePrediction(2, 22); // set
	 * actual high test.setActualHigh(70); //set predicted highs
	 * test.setPredictedHigh(1, 78); test.setPredictedHigh(2, 80);
	 * test.setPredictedHigh(3, 81); test.setPredictedHigh(4, 81); //
	 * test.setPredictedHigh(5, 78); test.setPredictedHigh(6, 75);
	 * test.setPredictedHigh(7, 72); test.setPredictedHigh(8, 75);
	 * test.setPredictedHigh(9, 72); // set predicted lows
	 * test.setPredictedLow(1, 63); test.setPredictedLow(2, 48);
	 * test.setPredictedLow(3, 55); //test.setPredictedLow(4, temp);
	 * test.setPredictedLow(5, 58); test.setPredictedLow(6, 43);
	 * //test.setPredictedLow(7, temp); test.setPredictedLow(8, 48);
	 * test.setPredictedLow(9, 45);
	 * 
	 * System.out.println(test.getDay()); System.out.println(test.getMonth());
	 * System.out.println(test.getActualHigh());
	 * System.out.println(test.getActualLow());
	 * 
	 * System.out.println(test.getPredictedHigh(1));
	 * System.out.println(test.getPredictedHigh(2));
	 * System.out.println(test.getPredictedHigh(3));
	 * System.out.println(test.getPredictedHigh(4));
	 * System.out.println(test.getPredictedHigh(5));
	 * System.out.println(test.getPredictedHigh(6));
	 * System.out.println(test.getPredictedHigh(7));
	 * System.out.println(test.getPredictedHigh(8));
	 * System.out.println(test.getPredictedHigh(9));
	 * 
	 * System.out.println(test.getPredictedLow(1));
	 * System.out.println(test.getPredictedLow(2));
	 * System.out.println(test.getPredictedLow(3));
	 * System.out.println(test.getPredictedLow(4));
	 * System.out.println(test.getPredictedLow(5));
	 * System.out.println(test.getPredictedLow(6));
	 * System.out.println(test.getPredictedLow(7));
	 * System.out.println(test.getPredictedLow(8));
	 * System.out.println(test.getPredictedLow(9));
	 * 
	 * System.out.println(test.toString()); }
	 */

	public TemperaturePrediction(int month, int dayOfMonth) {
		sMonth = month;
		sDay = dayOfMonth;

		for(int i=0; i<DATA_SIZE; i++)
		{
			high[i] = UNKNOWN_TEMP;
			low[i] = UNKNOWN_TEMP;
		}

	}


}
