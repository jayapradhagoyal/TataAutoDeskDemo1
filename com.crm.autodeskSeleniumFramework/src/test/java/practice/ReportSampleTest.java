package practice;

import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;


import com.crm.autodeskgenericutility.BaseClass;
@Listeners(com.crm.autodeskgenericutility.IListenerImplementain.class)

public class ReportSampleTest extends BaseClass{
	@Test
	public void createOrg()
	{
		System.out.println("organization is created");
	}
	@Test
	public void createProduct()
	{
		System.out.println("product creation is failed");
		Assert.fail();
	}
	
	
	  @Test public void createContact() 
	  { 
		  new SkipException("skippedException");
		  }
	 
}
