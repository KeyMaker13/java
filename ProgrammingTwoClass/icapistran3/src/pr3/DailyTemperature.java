package pr3;

public class DailyTemperature extends Temperature {

	
	public DailyTemperature(int month, int day){
		
		sMonth = month;
		sDay = day;
		high = new int[DATA_SIZE];
		low = new int[DATA_SIZE];
		
		for(int i=0; i<DATA_SIZE; i++)
		{
			high[i] = UNKNOWN_TEMP;
			low[i] = UNKNOWN_TEMP;
		}

	}


}

