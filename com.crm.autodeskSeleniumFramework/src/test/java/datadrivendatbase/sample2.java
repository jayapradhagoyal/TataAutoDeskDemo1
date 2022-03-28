package datadrivendatbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class sample2 {
	public static void main(String[] args) throws SQLException {
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
		
		Statement smt = conn.createStatement();
		String query="insert into students_info values('8','vimal','mali','d')";
		int res = smt.executeUpdate(query);
		if(res==1)
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		conn.close();
		
	}
	

}
