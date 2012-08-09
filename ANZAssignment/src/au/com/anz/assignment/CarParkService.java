package au.com.anz.assignment;

import java.util.ArrayList;
import java.util.List;

import au.com.anz.assignment.constants.VechicleType;

import au.com.anz.assignment.exception.ParkFullException;

public class CarParkService extends ParkService {
	
	private static final double CAR_HOURLY_RATE = 2.0;
	
	private static final double TRUCK_HOURLY_RATE = 3.0;
	
	private  int  capacity = 0;
	

	private List<Vechicle> slots;
	
	private double totalCollection = 0;
	
	private List<Vechicle> exitVechicles;
	
	private List<Vechicle> enteredVechicles;
	
	private final String NEW_LINE = "\n";

	
	public double getTotalCollection() {
		return totalCollection;
	}

	public CarParkService()
	{
		slots = new ArrayList<Vechicle>(capacity);	
		enteredVechicles = new ArrayList<Vechicle>();
		exitVechicles = new ArrayList<Vechicle>();
	}
	
	public CarParkService(int capacity)
	{
	   this.capacity = capacity;
	   slots = new ArrayList<Vechicle>(capacity);
	   enteredVechicles = new ArrayList<Vechicle>();
	   exitVechicles = new ArrayList<Vechicle>();
	}


	@Override
	public  synchronized void parkVechicle(Vechicle vechile) throws ParkFullException {
      
		if(capacity <= calculateOccupiedSlots())
		{
			
			throw new ParkFullException();
		}
		else
		{
		  enteredVechicles.add(vechile); 	
		  slots.add(vechile);
		}
	}

	@Override
	public synchronized void removeVechicle(Vechicle vechile,int hrs) {
		if(vechile instanceof Car)
		{
			totalCollection = totalCollection + CAR_HOURLY_RATE*hrs;
		}
		
		if(vechile instanceof Truck)
		{
			totalCollection = totalCollection + TRUCK_HOURLY_RATE*hrs;
		}
		exitVechicles.add(vechile);
		boolean isValidRemove =false;
		for (int i = 0; i < slots.size(); i++) {
			if((slots.get(i) instanceof Car) && (vechile instanceof Car))
			{
				isValidRemove = true;
				slots.remove(i);
			}
			if((slots.get(i) instanceof Truck) && (vechile instanceof Truck))
			{
				

				isValidRemove = true;
				slots.remove(i);
			}
		}

		if(!isValidRemove)
		{
			throw new RuntimeException("Invalid Vechicle Exit.");
		}

	}
	
	public int exitVechicleCountByType(String type)
	{
		int count = countVechicle(exitVechicles, type);
		
		return count; 
		
	}
	
	public int enterVechicleCountByType(String type)
	{
		int count = countVechicle(enteredVechicles,type);
		return count; 
	}
	
	private int countVechicle(List<Vechicle> list,String type)
	{
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			 //System.err.println("enteredVechicles.get(i).getClass().getName():"+list.get(i).getClass().getName());
			if(list.get(i).getClass().getName().equals(type))
			{
				count++;
			}
			
		}
		
		return count;
	}
	
	public int countParkedVechicles(String type)
	{
		int count = countVechicle(slots, type);
		return count; 
		
	}
	
	public int calculateOccupiedSlots()
	{
		int currentSize = 0;
		for (int i = 0; i < slots.size(); i++) {
			currentSize = currentSize + slots.get(i).getSlotSize();
		}
		
		return currentSize;
	}

	@Override
	public String generateReport() {
		StringBuffer strReport = new StringBuffer();
		strReport.append("Cars Entered       :"+enterVechicleCountByType(VechicleType.CAR)+NEW_LINE);
		strReport.append("Trucks Entered     :"+enterVechicleCountByType(VechicleType.TRUCK)+NEW_LINE);
		
		strReport.append("Cars Exited        :"+exitVechicleCountByType(VechicleType.CAR)+NEW_LINE);
		strReport.append("Trucks Exited      :"+exitVechicleCountByType(VechicleType.TRUCK)+NEW_LINE);
		
		strReport.append("Parking Cars       :"+countParkedVechicles(VechicleType.CAR)+NEW_LINE);
		strReport.append("Parking Truck      :"+countParkedVechicles(VechicleType.TRUCK)+NEW_LINE);
		
		strReport.append("Spaces Available   :"+(capacity - calculateOccupiedSlots())+NEW_LINE);
		
		strReport.append("Fees Paid          :"+getTotalCollection()+NEW_LINE);
		
		return strReport.toString();
	}
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	

}
