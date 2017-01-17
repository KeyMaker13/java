package directories;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("CS 2123 Lab 8 part I:" + "Written by Ivan Capistran");
		// TODO Auto-generated method stub
		
		boolean check = true;
		
		while(check){
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter a string");
			String s = scan.next();
			File f = new File(s);
			System.out.println("-----File Info for " +s+ "------");
			System.out.println("Name " + f.getName());
			System.out.println("Full Name : " + f.getPath());
			System.out.println("Absolute Path : " + f.getAbsolutePath());
			System.out.println("Read ? : " + f.canRead());
			System.out.println("Write ? :"+f.canWrite());
			System.out.println("Length? : " + f.length());
			Date dt = new Date(f.lastModified());
			System.out.println("Last Write : " + DateFormat.getDateTimeInstance().format(dt));
			
			if (f.isDirectory()){
				System.out.println("\nListing Directory Contents: ");
				String [] list = f.list();
				for (int i = 0; i < list.length; i++){
					System.out.println(list[i]+ " ");
				}
			}
			
			System.out.println("Do you want to continue checking ?" + " type y or n");
			String s1 = scan.next();
			
			if (s1.equals("n")){
				check = false;
			}
		}
		
	

	}

}
