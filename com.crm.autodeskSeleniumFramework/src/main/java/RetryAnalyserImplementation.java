import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation  implements IRetryAnalyzer{

	public boolean retry(ITestResult result) {
	       int count=0;
	       int retrycount=5;
	       if(count<retrycount)
	       {
	    	   count++;
	    	   return true;
	       }
		return false;
	}
	

}
