package datadrivendatbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class sample5 {
	@Test
	public static void main(String[] args) throws Throwable  {
		
		Connection conn=null;
		String expectedfirstname="khailash";
		try {
			Driver driverRef=new Driver();
			
			DriverManager.registerDriver(driverRef);
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
			Statement stat = conn.createStatement();
			String query="select * from students_info";
			ResultSet res = stat.executeQuery(query);
			boolean flag=false;
			//System.out.println(expectedfirstname);
			
			while(res.next())
			{
			String actualfirstname=res.getString(2);
				
				if(actualfirstname.equals(expectedfirstname))
				{
					System.out.println(expectedfirstname);
					System.out.println(actualfirstname);
				
					
					System.out.println("pass");
					flag=true;
				}
			 
			}
			
		
			
			
			
		
		
		}
		
		
	
		
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
	
		}
		finally
		{
conn.close();
		}
		
		
	}

}
