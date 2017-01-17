import java.io.*;


class  Entry  {
	public Entry(String name, String number) {/*exercise*/}
	public static Entry read(BufferedReader  br) throws Exception {
		String  name  =  br.readLine();
		if  (name  ==  null)
			return  null;
		String  number  =  br.readLine();
		return  new Entry(name,  number);
	}
	
    public String  getName()  { return "This is an exercise.";}
    public String  getNumber()  {return "This is an exercise.";}
	
	
	private String  name,  number;
}
