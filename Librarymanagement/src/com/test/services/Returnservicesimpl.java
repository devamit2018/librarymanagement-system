package com.test.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.database.Dbconnection;

public class Returnservicesimpl implements Returnservices 
{

	Connection con = null;
	public Returnservicesimpl() 
	{
		
		con = Dbconnection.getdbconnnection();
		
		
		
		
		
		
		
		
	}
	
	@Override
	public int delete(String Bookcallno, int Studentid) 
	
	{
		
		int status = 0;
		
		status = updatebook(Bookcallno);
		
		if(status>0)
		{
		String sql = "delete from issue where Bookcallno=? and Studentid=?";
		
		
		
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, Bookcallno);
			pstm.setInt(2, Studentid);
			status=pstm.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
		
		return status;
		
	}

	@Override
	public int updatebook(String Bookcallno) 
	{
		
		
		int status=0;
		int quantity=0,issued=0;
		
		
		
		String sql= "select Quantity,Issue from books where Callno=?";
		
		
		
		try {
			PreparedStatement	pstm = con.prepareStatement(sql);
			pstm.setString(1, Bookcallno);
			
			ResultSet rs = pstm.executeQuery();
			if(rs.next())
			{
				quantity = rs.getInt("Quantity");
				issued = rs.getInt("Issue");
				
			}
			if(issued>0)
			{
				
				String sql1 = "update books set Quantity=?,Issue=? where Callno=?";
				
				PreparedStatement pst = con.prepareStatement(sql1);
				pst.setInt(1,quantity+1);
				pst.setInt(2,issued-1);
				pst.setString(3,Bookcallno);
				
				status=pst.executeUpdate();

				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		return status;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
