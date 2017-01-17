import java.util.Locale;
import java.util.zip.DataFormatException;


public class Currency {
	
	private String name;
	private int value;
	private String country;
	
	public Currency (String aName, int aValue, String aCountry) throws DataFormatException
	{
		name = aName;
		value = aValue;
		
		
		if (validateCountry(aCountry)){
			country = aCountry;
		}
		else{
			throw new DataFormatException("Invalid country code" + aCountry + "(must be a two-letter ISO 3166)");
		}
		
	}

	private boolean validateCountry(String aCountry) {
		// TODO Auto-generated method stub
		String[] validCountry = Locale.getISOCountries();
		
		for (int i = 0; i < validCountry.length; i++){
			if (validCountry[i].equals(aCountry)){
				return true;
			}
		}
		
		return false;
	}
	
	public String toString(){
		
		return getClass().getName() + " {" + name + ", " + value + ", " + country + "} ";
	}

}
