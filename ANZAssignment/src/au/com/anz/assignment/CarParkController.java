package au.com.anz.assignment;

import au.com.anz.assignment.exception.ParkFullException;

public class CarParkController {
	
	private CarParkService carPark ;
	
	public CarParkController(int capacity) throws InstantiationException, IllegalAccessException
	{
		this.carPark = (CarParkService)ParkFactory.createPark(CarParkService.class);
		carPark.setCapacity(capacity);
	}
	
	public void enterVechicle(String vechicleType) throws ParkFullException{
		EnterCommand ec = new EnterCommand(carPark, VechicleFactory.createVechicle(vechicleType));
		ec.execute();
	}

    public void exitVechile(String vechicleType,int hrs){
		ExitCommand exc= new ExitCommand(carPark, VechicleFactory.createVechicle( vechicleType),hrs);
		exc.execute();
	}
       
    public String generatereport()
    {
    	return carPark.generateReport();
    }
}
