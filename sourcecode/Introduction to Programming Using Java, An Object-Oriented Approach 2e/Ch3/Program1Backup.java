import java.io.*;
class Program1Backup {
    public static void main(String[] arg) throws Exception {
	PrintStream backup;
	FileOutputStream backupFileStream;
	File backupFile;
	backupFile = new File("backup");
	backupFileStream = new FileOutputStream(backupFile);
	backup = new PrintStream(backupFileStream);
	System.out.println("This is my first Java program");
	backup.println("This is my first Java program");
	System.out.println("... but it won't be my last.");
	backup.println("... but it won't be my last.");
    }
}
