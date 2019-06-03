package Serialization;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadTextFile
{
	private Scanner input;
	
	//enable user to open file
	public void openFile()
	{
		try
		{
			input = new Scanner(new File("clients.txt"));
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
		//Object to be written to screen 
		AccountRecord record = new AccountRecord();
		System.out.printf("%-10s%-12s%-12s%-10s\n", "Account", "First Name", "Last Name", "Balance");
		
		try // read records from file
		{
			while(input.hasNext())
			{
				record.setAccount(input.nextInt());
				record.setFirstName(input.next());
				record.setLastName(input.next());
				record.setBalance(input.nextDouble());
				
				//Display records contents
				System.out.printf("%-10d%-12s%-12s%-10.2f\n",
						record.getAccount(), record.getFirstName(), record.getLastName(), record.getBalance());
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
		ReadTextFile c = new ReadTextFile();
		c.openFile();
		c.readRecords();
		c.closeFile();
		
	}
}
