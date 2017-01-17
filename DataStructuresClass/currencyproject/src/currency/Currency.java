package currency;

public class Currency {
	
	private int value;
	private String name;
	private String countryCode;
	
	public Currency()
	{
		value = 0;
		name = "";
		countryCode = "";
	}
	
	public Currency(int v, String n, String cc){
		value = v;
		name = n;
		countryCode = cc;
	}

	public void setValue (int v){
		
		value = v;
	}
	
	public void setName (String s){
		name = s;

	}
	
	public void setCountryCode (String cc){
		countryCode = cc;	
		
	}
	
	public int getValue()
	{
		return value;	
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getCountryCode()
	{
		return countryCode;
	}
	
	public String toString()
	{
		String s = "Value : " + getValue() + "\nName: " + getName() + "\nCountry Code: " + getCountryCode();
		
		return s;
	}
	
	public boolean equals (Currency c)
	{
		int comp = 0;
		comp = this.getValue() - c.getValue();
		
		if (comp == 0)
		{
			if (this.getName().equals(c.getName()))
			{
				if (this.countryCode.equals(c.countryCode))
				{
					return true;
				}
				
			}
		}
		return false;
		
	}
}
