package au.com.anz.assignment;

public class VechicleFactory {

	public static Vechicle createVechicle(String vechicleClass) {

		try {
			Vechicle obj = (Vechicle)Thread.currentThread().getContextClassLoader()
					.loadClass(vechicleClass).newInstance();
			return obj;
			
		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		
		return null;

	}

}
