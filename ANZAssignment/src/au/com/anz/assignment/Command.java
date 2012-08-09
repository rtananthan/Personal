package au.com.anz.assignment;

import au.com.anz.assignment.exception.ParkFullException;

public interface Command {
	
	public void execute() throws ParkFullException;

}
