import java.io.*;

class MakeMayor {
    public static void main(String[] arg) throws Exception {
	Name mayor;
	mayor = Name.read(new BufferedReader(
		              new InputStreamReader(System.in)));
	mayor.setTitle("His Honor, the Mayor");
	mayor.print(System.out);
    }
}
