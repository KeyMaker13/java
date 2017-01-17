import java.math.*;
public class BigIntProgram {
    public static void main(String[] arg) {
	BigInteger codeKey1 = new
	    BigInteger("5647335678535677546787654356778555433");
	BigInteger codeKey2 = new
	    BigInteger("1234561234535677546787654356778555433");
	BigInteger dividend = codeKey1.multiply(codeKey2);
	BigInteger bigThree = new BigInteger("3");
	BigInteger result = dividend.divide(bigThree);
	System.out.println(result);
    }
}
