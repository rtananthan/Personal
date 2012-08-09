package au.com.anz.assignment;

public class ExitCommand implements Command {
	
	private Vechicle vechile;
	
	private ParkService park;
	
	private int hrs = 0;
	
	public ExitCommand(ParkService park,Vechicle vechile,int hrs)
	{
		this.park = park;
		this.vechile = vechile;
		this.hrs = hrs;
	}

	@Override
	public void execute() {
         park.removeVechicle(vechile,hrs);
	}

}
