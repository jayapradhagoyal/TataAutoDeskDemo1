package datadrivendatbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class sample4 {
	
		public static void main(String[] args) throws SQLException {
			Connection conn=null;
			try
			{
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
			String sqlquery="select * from students_info";
			Statement smt = conn.createStatement();
			ResultSet res = smt.executeQuery(sqlquery);
			while(res.next())
			{
System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getString(3));
			}
			}
			catch(Exception e)
			{
			}
			finally
			{
				conn.close();
			}
		}


}
