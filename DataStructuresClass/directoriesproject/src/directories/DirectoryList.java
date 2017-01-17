package directories;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DirectoryList {
	
	
	
	public static void showDirectoryTree(File file)
	{
		//System.out.println(file.getAbsolutePath());
		System.out.println(getFileInfo(file));
		if (file.isDirectory()){
			File[] children = file.listFiles();
			if (null!=children){
				for (int i = 0; i < children.length; i++)
				{
					showDirectoryTree(children[i]);
				}
			}
		}
	}
	
	public static void showDirectoryTreeIndented(File aFile, String prefix, String level)
	{
		//System.out.println(prefix+aFile.getAbsolutePath());
		System.out.println(prefix+getFileInfo(aFile));
		if(aFile.isDirectory())
		{ 
			prefix = prefix + level;
			File[] children = aFile.listFiles();
			if(null!=children)
			{
				for(int i = 0; i<children.length; i++)
				{
					
					if(children[i].isDirectory())
					{
						prefix = level;
					}							
					showDirectoryTreeIndented(children[i], prefix, level);
				}
			}
		}
	}
	
	public static String getFileInfo(File aFile){
		String reTurn = "";
// if a directory do this
		if (aFile.isDirectory()){
			String r = "";
			String w = "";
			String x = "";
			String h = "";
			String space = "";
			String format = "";
			space = "(" + aFile.length() + ")bytes";
			long datetime = aFile.lastModified();
			Date d = new Date(datetime);
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            String dateString = sdf.format(d);
            format = " last modified:" + dateString;
			
			if (aFile.canRead()){
				r = "R";
			}
			if (aFile.canWrite()){
				w = "W";
			}
			if (aFile.canExecute()){
				x = "X";
			}
			if (aFile.isHidden()){
				h = "H";
			}
			
			reTurn = "" + aFile.getAbsolutePath() + " [D" + r + w + x + h + "] " + space + format ;
		}
// if a file do this
		if (aFile.isFile()){
			String r = "";
			String w = "";
			String x = "";
			String h = "";
			String space = "";
			String format = "";
			space = "(" + aFile.length() + ")bytes";
			long datetime = aFile.lastModified();
			Date d = new Date(datetime);
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            String dateString = sdf.format(d);
            format = " last modified:" + dateString;
			
			if (aFile.canRead()){
				r = "R";
			}
			if (aFile.canWrite()){
				w = "W";
			}
			if (aFile.canExecute()){
				x = "X";
			}
			if (aFile.isHidden()){
				h = "H";
			}
			
			reTurn = "" + aFile.getAbsolutePath() + " [" + r + w + x + h + "] " + space + format ;
		}
		
	
	return reTurn;
	}
	
	
}


