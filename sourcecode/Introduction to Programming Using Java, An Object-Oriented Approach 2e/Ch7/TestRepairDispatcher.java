import java.io.*;

public class TestRepairDispatcher {
	public static void main(String[] s) throws Exception {
		      BufferedReader br = new BufferedReader(new 
													 InputStreamReader(System.in));
		RepairPerson rp1, rp2, rp3;
		rp1 = RepairPerson.read(br);
		rp2 = RepairPerson.read(br);
		rp3 = RepairPerson.read(br);
		Location customer = Location.read(br);
		int d1 = rp1.getDistanceFrom(customer);
		int d2 = rp2.getDistanceFrom(customer);
		int d3 = rp3.getDistanceFrom(customer);
		System.out.print("Send ");
		if (d1<=d2 && d1<=d3) {
			rp1.getName().print(System.out);
			rp1.moveTo(customer);
		} else if (d2<=d1 && d2<=d3) {
			rp2.getName().print(System.out);
			rp2.moveTo(customer);
		} else if (d3<=d1 && d3<=d2) {
			rp3.getName().print(System.out);
			rp3.moveTo(customer);
		}
		System.out.println("");
	}
}
