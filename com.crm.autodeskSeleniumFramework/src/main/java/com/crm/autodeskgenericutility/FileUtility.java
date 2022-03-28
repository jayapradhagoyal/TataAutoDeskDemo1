package com.crm.autodeskgenericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author jayapradha
 *
 */
public class FileUtility {
	
	public String getPropertyKeyVAlue(String key) throws Throwable
	{
		FileInputStream fin=new FileInputStream ("./data/commonsdata.properties");
		Properties properties=new Properties ();
		properties.load(fin);
		String value = properties.getProperty(key);
		return value;
		
	}

}
