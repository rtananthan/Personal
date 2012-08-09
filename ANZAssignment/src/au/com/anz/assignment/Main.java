package au.com.anz.assignment;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import au.com.anz.assignment.util.Utility;

public class Main {
	
	public static void main(String args[])
	{
		
		 String parkSize = "";
		 CarParkController cp = null;
		 
		do
		{
		  parkSize =  getUserInput("Program: How many spaces does the car park have?:");
		  
		  if(!Utility.isValidInt(parkSize))
		  {
			  System.err.println("Invalid input\n");
		  }
		  else
		  {
			  try {
				 cp = new CarParkController(Integer.parseInt(parkSize));
				
			} catch (NumberFormatException e) {
				System.err.println("Invalid capacity for car park.Car Park not created.");
				parkSize = "";
				e.printStackTrace();
			} catch (InstantiationException e) {
				System.err.println("Error creating Car Park.");
				parkSize = "";
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				System.err.println("Error creating Car Park.");
				parkSize = "";
				e.printStackTrace();
			}
		  }
		  
		}while(!Utility.isValidInt(parkSize));
		
		QueryParser parser = new QueryParser(cp);
			
		while(true)
		{
			String userInput = getUserInput("USER:");
	
			
			   if(userInput.toUpperCase().equals("QUIT"))
			   {
				   
                   System.exit(0);
			   }
			   
			   System.out.println(parser.parse(userInput));
			   
		}
		
	}
	
	   private static String getUserInput(String message) {
	        String input = "";
	        try {
	            System.out.print(message);

	            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	            input = in.readLine();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return input.toUpperCase();
	    }

}
