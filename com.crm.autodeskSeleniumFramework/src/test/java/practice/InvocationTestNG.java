package practice;

import org.testng.annotations.Test;
@Test(enabled=false)
public class InvocationTestNG {
	@Test(invocationCount=2)
	public void sample()
	{
		System.out.println(" sample Running");
	}
	
	@Test
	public void Tester()
	{
		System.out.println(" tester Running");
	}
	@Test
	public void demo()
	{
		System.out.println("demo  Running");
	}

}
