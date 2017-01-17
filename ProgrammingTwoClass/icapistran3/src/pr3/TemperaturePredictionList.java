package pr3;

import java.util.ArrayList;


public class TemperaturePredictionList implements TemperatureConstants {
	
	private static ArrayList<TemperaturePrediction> predList;

	private static String[] MONTHS = { "Jan", "Feb", "Mar", "Apr", "May",
			"Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

	public TemperaturePredictionList() {
		predList = new ArrayList<TemperaturePrediction>();
	}

	public static TemperaturePrediction getTemperaturePredictionObject(int n) {

		return predList.get(n);
	}

	public int size() {
		return predList.size();
	}

	public String toString() {
		String toPrint = "";

		for (int i = 0; i < predList.size(); i++)
			toPrint += predList.get(i).toString();

		return toPrint;
	}

	public void print() {
		System.out.println(toString());
	}

	public void addFromDescriptor(String s) {

		TemperaturePrediction createdFromDescriptor = createFromDescriptor(s);
		ArrayList<String> words = splitString(cleanupString(s));

		for (int i = 2; i < DATA_SIZE; i++) {
			qualityCheck(words.get(i), words.get(i + 1));
		}

		try {
			for (int i = 1; i < DATA_SIZE; i++) {
				int predLow = Integer.parseInt(words.get(i * 2));
				int predHigh = Integer.parseInt(words.get(i * 2 + 1));

				createdFromDescriptor.setPredictedLow(i, predLow);
				createdFromDescriptor.setPredictedHigh(i, predHigh);

			}

			predList.add(createdFromDescriptor);

		} catch (NumberFormatException exception) {
		}
	}

	public static TemperaturePrediction createFromDescriptor(String s) {

		Boolean run = false;
		String sMonth = "";
		int month = 0;
		sMonth = s.substring(0, 3);
		int day = 0;

		for (int i = 0; i < MONTHS.length; i++) {
			if (sMonth.equals(MONTHS[i])) {
				month = (i + 1);
				run = true;
			}
		}
		String sDay = "";
		char test = s.charAt(4);
		if (test == ' ') {
			sDay = s.substring(5, 6);
			day = Integer.parseInt(sDay);
		} else {
			sDay = s.substring(4, 6);
			day = Integer.parseInt(sDay);
		}

		if (run) {
			return new TemperaturePrediction(month, day);
		} else {
			return null;
		}
		
	}

	public TemperaturePrediction find(int month, int day)
	{
		for(int i=0; i<predList.size(); i++)
		{
			TemperaturePrediction aPred = predList.get(i);
			
			if(aPred.getMonth() == month && aPred.getDay() == day)
				return aPred;
		}
		
		return null;
	}
	
	public void setActualTemperature(String s) {

		TemperaturePrediction createdFromDescriptor = createFromDescriptor(s);
		ArrayList<String> words = splitString(cleanupString(s));
		for (int i = 2; i < 4; i++) {
			qualityCheck(words.get(2), words.get(3));
		}

		int day = createdFromDescriptor.getDay();
		int month = createdFromDescriptor.getMonth();
		int aLow = Integer.parseInt(words.get(2));
		int aHigh = Integer.parseInt(words.get(3));

		try {
			for (int i = 0; i < predList.size(); i++) {

				if ((predList.get(i).getMonth() == month)
						&& (predList.get(i).getDay() == day)) {
					predList.get(i).setActualHigh(aHigh);
					predList.get(i).setActualLow(aLow);
				}
			}
		} catch (NumberFormatException exception) {
		}

	}
	
	

	public static String cleanupString(String s) {
		String clean = "";
		boolean previousWasSpace = false;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c != ' ') {
				clean += c;
				previousWasSpace = false;
			} else if (c == ' ' && !previousWasSpace) {
				clean += c;
				previousWasSpace = true;
			}
		}

		return clean;
	}

	public static ArrayList<String> splitString(String s) {
		ArrayList<String> segments = new ArrayList<String>();

		int begin = 0;
		int end = s.indexOf(' ', begin);

		if (end == -1)
			segments.add(s);
		else {
			while (end != -1) {
				segments.add(s.substring(begin, end));
				begin = end + 1;
				end = s.indexOf(' ', begin);
			}

			segments.add(s.substring(begin, s.length()));
		}

		return segments;
	}

	public static void qualityCheck(String a, String b) {

		int low = Integer.parseInt(a);
		int high = Integer.parseInt(b);
		int temp = 0;
		
		

		if (low > high) {
			temp = low;
			high = low;
			high = temp;
			

			a = Integer.toString(low);
			b = Integer.toString(high);
		}
		

	}

}
