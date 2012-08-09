package au.com.anz.assignment.util;

public class Utility {
	
	public static boolean isValidInt(String input)
	{
		try {

            Integer.parseInt(input);
        
        } catch (NumberFormatException ex) {
            return false;
        }
        
        return true;	}

}
