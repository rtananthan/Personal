package au.com.anz.test.assignment;

import static org.junit.Assert.*;

import org.junit.Test;

import au.com.anz.assignment.CarParkService;
import au.com.anz.assignment.ParkFactory;
import au.com.anz.assignment.VechicleFactory;
import au.com.anz.assignment.constants.VechicleType;
import au.com.anz.assignment.exception.ParkFullException;

public class CarParkServiceTest {
	
	
	@Test
	public void testParkVechicle() throws InstantiationException, IllegalAccessException, ParkFullException
	{
		CarParkService carPark = (CarParkService)ParkFactory.createPark(CarParkService.class);
		carPark.setCapacity(5);
		
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.CAR));
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.CAR));
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.TRUCK));	
		
		assertEquals(4,carPark.calculateOccupiedSlots());
		
	}
	
	
	@Test(expected=ParkFullException.class)
	public void testParkVechicleWithParkFull() throws InstantiationException, IllegalAccessException, ParkFullException
	{
		CarParkService carPark = (CarParkService)ParkFactory.createPark(CarParkService.class);
		carPark.setCapacity(4);
		
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.CAR));
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.CAR));
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.TRUCK));
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.CAR));		
		
	}
	

	@Test
	public void testRemoveVechicle() throws InstantiationException, IllegalAccessException, ParkFullException
	{
		CarParkService carPark = (CarParkService)ParkFactory.createPark(CarParkService.class);
		carPark.setCapacity(5);
	
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.CAR));
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.CAR));
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.TRUCK));	
		
		carPark.removeVechicle(VechicleFactory.createVechicle(VechicleType.CAR), 3);
		
		assertEquals(3,carPark.calculateOccupiedSlots());
		
		
	}


	@Test
	public void testEnterVechicleCountByType() throws InstantiationException, IllegalAccessException, ParkFullException
	{
		CarParkService carPark = (CarParkService)ParkFactory.createPark(CarParkService.class);
		carPark.setCapacity(7);
		
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.CAR));
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.CAR));
		
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.TRUCK));
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.TRUCK));
		
		
		assertEquals(2, carPark.enterVechicleCountByType(VechicleType.CAR));
		assertEquals(2, carPark.enterVechicleCountByType(VechicleType.TRUCK));

		
	}
	
	@Test
	public void testExitVechicleCountByType() throws InstantiationException, IllegalAccessException, ParkFullException
	{
		CarParkService carPark = (CarParkService)ParkFactory.createPark(CarParkService.class);
		carPark.setCapacity(7);
		
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.CAR));
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.CAR));
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.TRUCK));
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.TRUCK));
		
		carPark.removeVechicle(VechicleFactory.createVechicle(VechicleType.CAR), 3);
		carPark.removeVechicle(VechicleFactory.createVechicle(VechicleType.CAR), 1);
		carPark.removeVechicle(VechicleFactory.createVechicle(VechicleType.TRUCK), 2);

		assertEquals(2, carPark.exitVechicleCountByType(VechicleType.CAR));
		assertEquals(1, carPark.exitVechicleCountByType(VechicleType.TRUCK));

	}
	
	@Test
	public void testCountParkedParkedVechile() throws InstantiationException, IllegalAccessException, ParkFullException
	{
		
		CarParkService carPark = (CarParkService)ParkFactory.createPark(CarParkService.class);
		carPark.setCapacity(7);
		
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.CAR));
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.CAR));
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.TRUCK));
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.TRUCK));
		
		carPark.removeVechicle(VechicleFactory.createVechicle(VechicleType.CAR), 3);
		carPark.removeVechicle(VechicleFactory.createVechicle(VechicleType.TRUCK), 2);

		assertEquals(1, carPark.countParkedVechicles(VechicleType.CAR));
		assertEquals(1, carPark.countParkedVechicles(VechicleType.TRUCK));

	}
	
	@Test
	public void testCalculateOccupiedSlots() throws InstantiationException, IllegalAccessException, ParkFullException
	{
		
		CarParkService carPark = (CarParkService)ParkFactory.createPark(CarParkService.class);
		carPark.setCapacity(7);
		
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.CAR));
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.CAR));
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.TRUCK));
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.TRUCK));
		
		carPark.removeVechicle(VechicleFactory.createVechicle(VechicleType.CAR), 3);
		carPark.removeVechicle(VechicleFactory.createVechicle(VechicleType.TRUCK), 2);

		assertEquals(3, carPark.calculateOccupiedSlots());
		

	}
	
	@Test
	public void testcalculateTotalCost() throws InstantiationException, IllegalAccessException, ParkFullException 
	{
		CarParkService carPark = (CarParkService)ParkFactory.createPark(CarParkService.class);
		carPark.setCapacity(7);
		
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.CAR));
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.CAR));
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.TRUCK));
		carPark.parkVechicle(VechicleFactory.createVechicle(VechicleType.TRUCK));
		
		carPark.removeVechicle(VechicleFactory.createVechicle(VechicleType.CAR), 3);
		carPark.removeVechicle(VechicleFactory.createVechicle(VechicleType.TRUCK), 2);

		assertEquals((double)12, carPark.getTotalCollection(),0);

	}
}
