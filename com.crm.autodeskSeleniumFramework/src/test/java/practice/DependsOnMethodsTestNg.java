package practice;

import org.testng.annotations.Test;

public class DependsOnMethodsTestNg {
	@Test
	public void addFriend() throws Exception {
		System.out.println("Adding a friend");
		//throw new Exception();
	}
	
	  @Test(dependsOnMethods="addFriend") 
	  public void updatefriend() {
	  System.out.println("updating a friend");
	  }
	 
	 @Test(dependsOnMethods= {"addFriend","updatefriend"}) 
	 public void sendNotification() { 
		 System.out.println("sendingNotification a friend"); 
		 }
	 
	  @Test(dependsOnMethods= {"addFriend","updatefriend","sendNotification"})
	  public void deleteFriend() 
	  { 
		  System.out.println("deleting a friend"); 
		  }
	 

}
