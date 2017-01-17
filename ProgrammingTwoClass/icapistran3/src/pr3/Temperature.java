package pr3;

public abstract class Temperature implements TemperatureConstants{

	protected int[] low = new int[DATA_SIZE];
	protected int[] high = new int[DATA_SIZE];
	protected int sMonth;
	protected int sDay;


	public void setPredictedLow(int n, int temp) {
		if (n > 0 && n < DATA_SIZE) {
			low[n] = temp;
		}
	}

	public void setPredictedHigh(int n, int temp) {
		if (n > 0 && n < DATA_SIZE) {
			high[n] = temp;
		}
	}

	public void setActualLow(int temp) {
		low[0] = temp;
	}

	public void setActualHigh(int temp) {
		high[0] = temp;
	}

	public int getPredictedLow(int n) {
		return low[n];
	}

	public int getPredictedHigh(int n) {
		return high[n];
	}

	public int getActualLow() {
		return low[0];
	}

	public int getActualHigh() {
		return high[0];
	}

	public int getMonth() {
		return sMonth;
	}

	public int getDay() {
		return sDay;
	}

	public String toString() {

		String toPrint = "";
		String month = "";
		String date = "";
		
		String tempHigh = "";

		if(high[0] == UNKNOWN_TEMP)
			tempHigh += "??";
		else
			tempHigh += high[0];
		
		String tempLow = "";
		
		if(low[0] == UNKNOWN_TEMP)
			tempLow += "??";
		else
			tempLow += low[0];
		
		String predictedHigh = "";
		String predictedLow = "";
		// determines what month to print out based on the value number of the
		// variable sMonth declared by user
		if (sMonth == 1) {
			month = "Jan";
		}
		if (sMonth == 2) {
			month = "Feb";
		}
		if (sMonth == 3) {
			month = "Mar";
		}
		if (sMonth == 4) {
			month = "Apr";
		}
		if (sMonth == 5) {
			month = "May";
		}
		if (sMonth == 6) {
			month = "Jun";
		}
		if (sMonth == 7) {
			month = "Jul";
		}
		if (sMonth == 8) {
			month = "Aug";
		}
		if (sMonth == 9) {
			month = "Sep";
		}
		if (sMonth == 10) {
			month = "Oct";
		}
		if (sMonth == 11) {
			month = "Nov";
		}
		if (sMonth == 12) {
			month = "Dec";
		}
		date += month + " " + sDay + ":";

		// checks values to make sure they have values if not they become ??
		for (int i = 1; i<DATA_SIZE; i++)
		{
			if(high[i] == UNKNOWN_TEMP)
				predictedHigh += " ?? ";
			else
				predictedHigh += " " +high[i]+ " ";
		}

		for (int i = 1; i<DATA_SIZE; i++)
		{
			if(low[i] == UNKNOWN_TEMP)
				predictedLow += " ?? ";
			else
				predictedLow += " " +low[i]+ " ";
		}

		toPrint = date + " High=" + tempHigh + " Low=" + tempLow
		+ " Predicted highs:" + predictedHigh + "Lows:" + predictedLow
		+ "\n";

		return toPrint;
	}
}
