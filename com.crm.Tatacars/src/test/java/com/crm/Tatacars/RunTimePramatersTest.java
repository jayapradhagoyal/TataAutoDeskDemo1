package com.crm.Tatacars;

import org.testng.annotations.Test;

public class RunTimePramatersTest{
		@Test
	public void getDataTest() {
			
			String browserName=System.getProperty("browser");
			String url=System.getProperty("url");
			String username=System.getProperty("username");
			String password=System.getProperty("password");
			System.out.println(browserName);
			System.out.println(url);
			System.out.println(username);
			System.out.println(password);
			
			
		}

	}



