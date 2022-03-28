package practice;

import org.testng.annotations.Test;

public class PriorityTestNG {
	@Test(priority=-2)
	public void sample()
	{
		System.out.println("Running sample testcase");
	}

	@Test
	public void demo()
	{
		System.out.println("Running demo testcase");
	}
	@Test(priority=2)
	public void Tester()
	{
		System.out.println("Running Tester testcase");
	}
	@Test(priority=-1)
	public void Account()
	{
		System.out.println("Running Account testcase");
	}
}
