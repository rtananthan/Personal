package au.com.anz.assignment;

import au.com.anz.assignment.exception.ParkFullException;

public class EnterCommand implements Command {
	
	private ParkService park;
	
	private Vechicle vechile;
	
	
	public EnterCommand(ParkService park,Vechicle vechile)
	{
		this.park = park;
		this.vechile = vechile;
	}

	@Override
	public void execute() throws ParkFullException {
      park.parkVechicle(vechile);
	}

}
