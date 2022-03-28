package practice1;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion {
	@Test
	public void testAssert()
	{
		//verifing String
		String company="TestYantra";
		String company1="TestYantra";
		Assert.assertEquals(company, company1);
		
		//verifing int
		int a=20;
		int b=20;
		Assert.assertEquals(a, b);
	
	   //Verifing List 	
		List<String>list=new ArrayList<String>();
		
		list.add("hello");
		list.add("hi");
		list.add("heyy");
		list.add("Bye");
		
		List<String>list1=new ArrayList<String>();
		list1.add("hello");
		list1.add("hi");
		list1.add("heyy");
		list1.add("Bye");
		Assert.assertEquals(list, list1, "True");
		
		//verifing String Array
		Object[] student= {"Mohan","Rohan","sohan","johan"};
		Object[] student1= {"Mohan","Rohan","sohan","johan"};
		Assert.assertEquals(student, student1);
		
		//verifing boolean
		Boolean value=true;
		Boolean value1=true;
		Assert.assertEquals(value,value1);
		
		
		
	}

}
