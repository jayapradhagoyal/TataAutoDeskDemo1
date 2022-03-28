import org.testng.Assert;
import org.testng.annotations.Test;

public class retryanalyser {
	@Test(retryAnalyzer =com.crm.autodeskgenericutility.RetryAnalyserImplementation.class)
	
	
	public void create()
	{
		System.out.println("retry");
		Assert.assertEquals(true, false);
	}

}
