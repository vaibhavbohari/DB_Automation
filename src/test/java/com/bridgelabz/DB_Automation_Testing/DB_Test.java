package com.bridgelabz.DB_Automation_Testing;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.bridgelabz.DB_Automation.Base_Class;


public class DB_Test extends Base_Class{
	@Test(priority=1)
	public void getTableData() throws SQLException {
		con = this.setUp();
		//Statement Object to send queries.
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from student");
		while (rs.next())
	    {
	        int Id =rs.getInt(1);
	        String FirstName=rs.getString(2);
	        String LastName =rs.getString(3);
	        String City =rs.getString(4);
	        System.out.println(Id+"  "+FirstName+"  "+LastName+ " "+City);
	        System.out.println("-------------------------------------------------");
	    }
	}
		@Test(priority=2)
		 public void insertData() throws SQLException {
			 con=this.setUp();
			 PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?)");
			 ps.setInt(1,8);
			 ps.setString(2, "Vaibhav");
			 ps.setString(3, "Bohari");
			 ps.setString(4, "Akola");
			 ps.executeUpdate();
			 getTableData();
			 
		 }
		
		@Test (priority=3)
		 
		 public void updateTableData () throws SQLException {
			con=this.setUp();
			 PreparedStatement ps = con.prepareStatement("update student set FirstName = ? where Id = ?");
			 ps.setString(1, "Raj");
			 ps.setInt(2, 8);
			 ps.executeUpdate();
			 getTableData(); 
			
		 }
		
		@Test(priority=4)
		
		public void deleteTaleData() throws SQLException {
			 con=this.setUp();
			 PreparedStatement ps = con.prepareStatement("delete from student where Id= ?");
			 ps.setInt(1, 8);
			 ps.executeUpdate();
			 getTableData();
			 
			
		}
		
			
		



		
	

}
