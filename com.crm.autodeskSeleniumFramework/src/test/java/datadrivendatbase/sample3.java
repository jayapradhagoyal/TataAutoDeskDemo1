package datadrivendatbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class sample3 {
	public static void main(String[] args) throws SQLException {
		Connection conn =null;
		int res=0;
	
		try
		{
			Driver driverref=new Driver();
		
		DriverManager.registerDriver(driverref);
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
		
		Statement smt = conn.createStatement();
		String query="insert into students_info values('9','vimal','mali','d')";
		 res = smt.executeUpdate(query);
		}
		catch(Exception e)
		{
		
		}
		finally
		{
		if(res==1)
		{
			System.out.println("pass");
		}
		else
		{
			System.err.println("fail");
		}
		
		conn.close();
		System.out.println("===========close db connection======");
		
	}
	

}
}