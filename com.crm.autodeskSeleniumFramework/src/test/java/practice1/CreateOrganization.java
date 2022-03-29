package practice1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodeskgenericutility.BaseClass;

public class CreateOrganization extends BaseClass {
	@Test(groups="smokeTest")
	public void createOrg()
	{
		System.out.println("organization is reated");
	}
	@Test
	public void createindustry()
	{
		System.out.println("organization is reated");
	}
	@Test
	public void createContract()
	{
		System.out.println("organization is reated");
	}

}
