package au.com.anz.assignment;

public class Car implements Vechicle {
	
	private static final int SLOT_SIZE = 1;

	@Override
	public int getSlotSize() {
		return SLOT_SIZE;
	}

}
