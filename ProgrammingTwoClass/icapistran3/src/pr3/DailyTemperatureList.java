package pr3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DailyTemperatureList implements TemperatureConstants {


	private ArrayList<DailyTemperature> dailyList;

	public DailyTemperatureList() {

		dailyList = new ArrayList<DailyTemperature>();

	}

	public String toString() {
		String toPrint = "";

		for(int i=1; i<=12; i++)
		{
			for(int j=1; j<=31; j++)
			{
				DailyTemperature aDT = find(i, j);
				
				if(aDT != null)
					toPrint += aDT.toString();
			}
		}

		return toPrint;
	}
	
	public DailyTemperature find(int month, int day)
	{
		for(int i=0; i<dailyList.size(); i++)
		{
			DailyTemperature aDT = dailyList.get(i);
			
			if(aDT.getMonth() == month && aDT.getDay() == day)
				return aDT;
		}
		
		return null;
	}

	public void print() {
		System.out.println(toString());
	}

	public int size() {
		return dailyList.size();
	}

	public DailyTemperature get(int n) {
		return dailyList.get(n);
	}

	public DailyTemperature createFromData(TemperaturePrediction d) {

		return new DailyTemperature(d.getMonth(), d.getDay());
	}

	public void addData(TemperaturePrediction d, TemperaturePredictionList pList) {

		int month = d.getMonth();
		int day = d.getDay();

		DailyTemperature n;

		n = new DailyTemperature(month, day);

		n.setActualHigh(d.getActualHigh());
		n.setActualLow(d.getActualLow());
		
		for(int i = 1; i<DATA_SIZE; i++)
		{
			GregorianCalendar calendar = new GregorianCalendar(1999, month, day);
			calendar.add(Calendar.DAY_OF_MONTH, -i);
			
			int newMonth = calendar.get(Calendar.MONTH);
			int newDay = calendar.get(Calendar.DAY_OF_MONTH);
			
			TemperaturePrediction priorPred = pList.find(newMonth, newDay);
			
			if(priorPred != null)
			{
				n.setPredictedHigh(i, priorPred.getPredictedHigh(i));
				n.setPredictedLow(i, priorPred.getPredictedLow(i));
			}
		}
		
		dailyList.add(n);
	}
}
