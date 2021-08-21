package labFileInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.*;

/**
 * Reads in data records from the csv file and prints the lakes.
 * 
 * @author Brittany Pruneau
 *
 */
public class LakeApp
{
	public static void main(String[] args)
	{
		List<Lake> lakes = new ArrayList<>();		

		try(Scanner reader = new Scanner(LakeApp.class.getResourceAsStream("Lakes.csv"))) 
		{
			 while(reader.hasNextLine())
			 {
				Lake lake = getLake(reader.nextLine());
				
				if(lake != null)
				{
					lakes.add(lake); // Lake is a class dont we need to create an new lake object? 
				}
			 }
		}
		lakes.forEach(n-> System.out.println(n+ " "));
		
		System.out.println("New output with Scanner");
	     String input = "1 fish 2 fish red fish blue fish";
	     Scanner s = new Scanner(input);
	     s.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");
	     MatchResult result = s.match();
	     for (int i=1; i<=result.groupCount(); i++)
	         System.out.println(result.group(i));
	     s.close();
	}

	/**
	* Creates a Lake object based on the data record passed as an argument.
	* The data record is expected to be of the following format: <br/>
	* {name of the lake},{depth},{has marina}<br/>
	* <p>
	* If the argument <code>line</code> doesn't match the expected format 
	* and the instance of Lake cannot be created, then the string "Error: " 
	* followed by the line should be printed to the standard error stream 
	* (<code>System.err</code>) and the method should return null.
	* 
	* @param line 	A line from a csv file that includes data about a lake
	* @return Lake 	Object corresponding to the argument <code>line</code> 
	* 				or null if <code>line</code> didn't match the expected format.
	*/
	private static Lake getLake(String nextLine)
	{
		int depth;
		Lake lake = null; 
		boolean hasMarina;
		
		String[] lakeInfo = nextLine.split(",");
		String name = lakeInfo[0]; 
		try
		{
			depth = Integer.parseInt(lakeInfo[1]); 
			hasMarina = Boolean.parseBoolean(lakeInfo[2]);
			lake = new Lake(name, depth, hasMarina);
			return lake;
		}
		catch(NumberFormatException e)
		{
			System.err.println("Error:" +nextLine);
		}	
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.err.println("Error:" +nextLine);
		}
		return lake;
	}
}
