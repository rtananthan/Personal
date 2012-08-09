package au.com.anz.assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import au.com.anz.assignment.constants.VechicleType;
import au.com.anz.assignment.exception.ParkFullException;

public class QueryParser {
	
	private CarParkController cpc = null;
	private Map<String,String> qryVechicleTypeMap ;
	
	/**TODO Remove coupling between the controller and the QueryParser*/
	public QueryParser(CarParkController cpc)
	{
		this.cpc = cpc;
		qryVechicleTypeMap = new HashMap<String, String>();
		qryVechicleTypeMap.put("CAR", VechicleType.CAR);
		qryVechicleTypeMap.put("TRUCK", VechicleType.TRUCK);
	}
	
	
	public String parse(String qry)
	{
		qry = qry.trim();
		
		 if (qry.startsWith("ENTER ")) {
	            if (!isValidEnter(qry)) {
	                return "Query syntax error";
	            }
	            else
	            {
	            	String[] splits = qry.split(" ");
	            	try {
	            		 if(qryVechicleTypeMap.get(splits[1].toUpperCase()) == null){
	            			 return "Invalid vechicle type.";
	            		 }
						cpc.enterVechicle(qryVechicleTypeMap.get(splits[1].toUpperCase()));
						return "";
					} catch (ParkFullException e) {
						return e.getMessage();
					}
	            }
		 }
		 
		 if (qry.startsWith("EXIT ")) {
	            if (!isValidExit(qry)) {
	                return "Query syntax error";
	            }
	            else
	            {
	            	String[] splits = qry.split(" ");
	            	try {
	            		if(qryVechicleTypeMap.get(splits[1].toUpperCase()) == null){
	            			 return "Invalid vechicle type.";
	            		 }
	            		String vechcileType = qryVechicleTypeMap.get(splits[1].toUpperCase()).toString();
						cpc.exitVechile(vechcileType,Integer.parseInt(splits[2]));
						return "";
					} catch (Exception e) {
						return "Error occured exiting";
					}
	            }
		 }
		 
		 if (qry.startsWith("REPORT")) {
			 
			 
			 if(!qry.equalsIgnoreCase("REPORT"))
			 {
				 return "Query syntax error"; 
			 }
			 else
			 {
				return cpc.generatereport(); 
			 }
			 
		 }
		 
		 return "Invalid Command.";
	}

	private boolean isValidEnter(String qry) {
		String regex = "^ENTER *[A-Za-z]+$";//^ADD *[A-Za-z]+ *\\, *[0-9]+$

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(qry);

        if (matcher.find())
            return true;

        return false;
	}
	
	private boolean isValidExit(String qry) {
		String regex = "^EXIT *[A-Za-z]+ *\\ *[0-9]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(qry);

        if (matcher.find())
            return true;

        return false;
	}

}
