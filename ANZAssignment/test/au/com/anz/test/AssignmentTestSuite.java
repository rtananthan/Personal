package au.com.anz.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import au.com.anz.test.assignment.CarParkServiceTest;

public class AssignmentTestSuite {

	public static void main(String args[])
	{
		Result result = JUnitCore.runClasses(CarParkServiceTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}		
	}
}
