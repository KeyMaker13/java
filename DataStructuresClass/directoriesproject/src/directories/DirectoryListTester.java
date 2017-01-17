package directories;

import java.io.File;

public class DirectoryListTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	System.out.println("CS 2123 Lab 8 par II and part III");
	System.out.println("Written by Ivan Capistran");
	
	DirectoryList d = new DirectoryList();
	File aFile = new File("C:\\Users");
	//File bFile =  new File("D:\\Documents\\Fall 2012\\DataStructures");
	File bFile = new File("C:\\Windows");
	File cFile = new File("E:\\Documents\\Fall 2012\\DataStructures\\directoriesproject\\test.txt");
	//File cFile = new File("D:\\Documents\\Fall 2012\\DataStructures\\directoriesproject");
	//File dFile = new File("D:\\Documents");
	System.out.println("-------------showDirectoryTree()---------------");
	//d.showDirectoryTree(aFile);
	System.out.println("------Indented------");
	System.out.println("-------------showDirectoryTreeIndented()---------------");
	d.showDirectoryTreeIndented(bFile, "", "\t");
	//System.out.println(d.getFileInfo(cFile));

	}

}
