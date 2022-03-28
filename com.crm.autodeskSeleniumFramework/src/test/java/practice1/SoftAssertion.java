package practice1;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert ;

public class SoftAssertion {
	@Test
	
	public void softAssertion()
	{
		
		SoftAssert soft = new SoftAssert();
		
		//verifing String
				String company="TestYantra";
				String company1="TestYatra";
				soft.assertEquals(company, company1);
				
				//verifing int
				int a=20;
				int b=20;
				soft.assertEquals(a, b);
			
			   //Verifing List 	
				List<String>list=new ArrayList<String>();
				
				list.add("hello");
				list.add("hii");
				list.add("heyy");
				list.add("Bye");
				
				List<String>list1=new ArrayList<String>();
				list1.add("hello");
				list1.add("hi");
				list1.add("heyy");
				list1.add("Bye");
				soft.assertEquals(list, list1, "True");
				
				//verifing String Array
				Object[] student= {"Mohan","Rohan","sohan","johan"};
				Object[] student1= {"Mohan","Roh","sohan","johan"};
				soft.assertEquals(student, student1);
				
				//verifing boolean
				Boolean value=true;
				Boolean value1=true;
				soft.assertEquals(value,value1);
				
			
				
			}

		

		
		
		
	}


