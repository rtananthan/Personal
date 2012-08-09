package au.com.anz.assignment;

import java.lang.reflect.Constructor;

public class ParkFactory {
	
	public static ParkService createPark(Class parkClazz) throws InstantiationException, IllegalAccessException
	{
		return (ParkService)(parkClazz.newInstance());
	}
	

	

}
