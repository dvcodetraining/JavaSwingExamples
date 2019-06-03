package Serialization;

import java.io.File;
import java.util.Scanner;

public class Fileinfo
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter file or directory name: ");
		analyzePath(input.nextLine());
	}
	
	public static void analyzePath(String path)
	{
		// create File object based on user input
		File name = new File(path);
		
		// of name exists output information about it
		if(name.exists())
		{
			// display file or directory information
			System.out.printf("%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s",
					name.getName(), " exists",
					(name.isFile() ? "is a file" : "is not a file"),
					(name.isDirectory() ? "is a directory" : "is not a directory"),
					(name.isAbsolute() ? "is aboslute Path" : "is not absolute path"),
					"Last modified: ", name.lastModified(),
					"Length: ", name.length(),
					"Path: ", name.getPath(),
					"Abosulute Path: ", name.getAbsolutePath(),
					"Parent: ", name.getParent());
			if(name.isDirectory())
			{
				String[] directory = name.list();
				System.out.println("\n\nDirectory contents:\n");
				for ( String directoryName : directory)
				{
					System.out.println(directoryName);
				}
			}
		}
		else
		{
			System.out.printf("%s %s", path, "does not exist.");
		}
	}
}
