package au.com.anz.assignment;

public class Truck implements Vechicle {
	
	private static final int SLOT_SIZE = 2;


	@Override
	public int getSlotSize() {
		return SLOT_SIZE;
	}

}
