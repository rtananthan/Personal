package au.com.anz.assignment;

import au.com.anz.assignment.exception.ParkFullException;

public abstract class ParkService {
   
	private  int  capacity = 0;
	
	public abstract void parkVechicle(Vechicle vechile) throws ParkFullException;
	
	public abstract void removeVechicle(Vechicle vechile,int hrs);
	
	public abstract String generateReport();

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	
}
