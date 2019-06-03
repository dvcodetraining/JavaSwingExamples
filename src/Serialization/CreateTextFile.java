package Serialization;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile
{
	private Formatter output; //object used to output text to file
	
	//enable user to open file
	public void openFile()
	{
		try
		{
			output = new Formatter("clients.txt"); // open the file
		}
		catch (SecurityException serityException) 
		{
			System.err.println("You don't have write acces to this file");
			System.exit(1); //terminate program
		} 
		catch (FileNotFoundException e)
		{
			System.err.println("Error opening or creating File.");
			System.exit(1); //terminate program
		}
	}
	//add records to file
	public void addRecords()
	{
		//Object to be written to file
		AccountRecord record = new AccountRecord();
		Scanner input = new Scanner (System.in);
		
		System.out.printf("%s\n%s\n%s\n%s\n\n",
				"To terminate input, type the end-of-file indicator ",
				"When you are prompted to enter input.",
				"On UNIX/Linux/Mac OS X type <ctrl> d then press Enter",
				"On Windows type <ctrl> z then press Enter");
		System.out.printf("%s\n%s",
				"Enter Account number (> 0), first name, last name and balance",
				"? ");
		// loop until end of file
		while (input.hasNext())
		{
			try // output values to file
			{
				//retrieve values to file
				record.setAccount(input.nextInt());
				record.setFirstName(input.next());
				record.setLastName(input.next());
				record.setBalance(input.nextDouble());
				System.out.println("account: " + record.getAccount());
				System.out.println("First Name: "  + record.getFirstName());
				System.out.println("Last Name: " + record.getLastName());
				System.out.println("Balance: " + record.getBalance());
				
				if (record.getAccount() > 0)
				{
					// write new record
					output.format("%d %s %s %.1f\n", record.getAccount(), record.getFirstName(), record.getLastName(), record.getBalance());
				}
				else
				{
					System.out.println("Account number must be Greater than 0.");
				}
			}
			catch (FormatterClosedException e)
			{
				System.err.println("Error writing to file.");
				return;
			}
			catch (NoSuchElementException e)
			{
				System.err.println("invalid input. Please try again.");
				input.nextLine();
			}
			System.out.printf("%s %s\n%s", "Enter account number (> 0", "fisrt name, last name and balance", "?");
		}
	}
	
	//close file
	public void closeFile()
	{
		if (output != null)
		{
			output.close();
		}
	}
	public static void main(String[] args)
	{
		CreateTextFile c = new CreateTextFile();
		c.openFile();
		c.addRecords();
		c.closeFile();
		
	}
}
