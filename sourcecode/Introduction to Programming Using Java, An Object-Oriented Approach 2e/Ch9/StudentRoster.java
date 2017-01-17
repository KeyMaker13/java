import java.io.*;
import java.util.*;

class  StudentRoster  {
    
	StudentRoster(String rosterFileName) throws Exception { 
		studentColl  =  new Vector();
		BufferedReader  br =
			new BufferedReader(
							   new  InputStreamReader(
													  new FileInputStream(rosterFileName)));
		int  total  =  0;  // accumulated total of averages
		int  count  =  0;  // count of students
		Student  student  =  Student.read(br);
		while  (student  !=  null)  {
			total  +=  student.getAverage();
			count++;
			studentColl.add(student);
			student  =  Student.read(br);
		}
		classAverage  =  total  /  count;
	}
	
	public void  evaluate()  {
		for (int i=0; i<studentColl.size(); i++) {
			Student student  =  (Student) studentColl.elementAt(i);
			System.out.print(student.getName());
			System.out.print("  is  performing  ");
			if  (student.getAverage()  >=  classAverage)
				System.out.println("above average.");
			else
				System.out.println("below average.");
		}
	}
	
	private Vector  studentColl;
	private int  classAverage;
}
