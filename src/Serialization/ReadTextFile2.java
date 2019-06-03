package Serialization;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadTextFile2
{
	private Scanner input;
	
	//enable user to open file
	public void openFile()
	{
		try
		{
			input = new Scanner(new File("file.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.err.println("Error opening File.");
			System.exit(1); //terminate program
		}
	}
	//add records to file
	public void readRecords()
	{
		// use end of line to separate strings
		input.useDelimiter("/n");
		
		try // read records from file
		{
			while(input.hasNext())
			{
				String frase = input.next();				
				//Display records contents
				System.out.println(frase);
			}
		}
		catch(NoSuchElementException e)
		{
			System.err.println("File improperly formed.");
			input.close();
			System.exit(1);
		}
		catch(IllegalStateException e)
		{
			System.err.println("Error reading from file.");
			System.exit(1);
		}
	}
	
	//close file
	public void closeFile()
	{
		if (input != null)
		{
			input.close();
		}
	}
	public static void main(String[] args)
	{
		ReadTextFile2 c = new ReadTextFile2();
		c.openFile();
		c.readRecords();
		c.closeFile();
		
	}
}
