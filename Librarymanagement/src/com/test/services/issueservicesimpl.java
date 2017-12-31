package com.test.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import com.test.database.Dbconnection;
import com.test.models.Issue;

public class issueservicesimpl implements Issueservices
{

	 Connection con = null;
	public issueservicesimpl() 
	
	{
		con = Dbconnection.getdbconnnection();
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public boolean Checkbook(String bookcallno) 
	{
		
		boolean status = false;
		
		String sql = "select * from books where Callno=?";
		
		
		
		try {
			PreparedStatement	pstm = con.prepareStatement(sql);
			
			pstm.setString(1, bookcallno);
			ResultSet rs = pstm.executeQuery();
			status = rs.next();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return status;
	}

	@Override
	public int Save(String Bookcallno, int Studentid, String Studentname, String Studentcontact) 
	{
		
		int status =0;
		status = update(Bookcallno);
		
		if(status > 0)
		{
			String sql = "insert into issue(Bookcallno,Studentid,Studentname,Studentcontact) values(?,?,?,?)";
			
			try {
				PreparedStatement pstm = con.prepareStatement(sql);
				
				pstm.setString(1, Bookcallno);
				pstm.setInt(2, Studentid);
				pstm.setString(3, Studentname);
				pstm.setString(4, Studentcontact);
				
				status = pstm.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			
		}
		
		
		
		
		return status;
	}

	@Override
	public int update(String Bookcallno)
	{
		
		int status=0;
		int quantity=0,issued=0;
		
		String sql = "SELECT Quantity,Issue FROM books WHERE Callno=?";
		
		
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			
			
			pstm.setString(1, Bookcallno);
			
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next())
			{
				
				quantity = rs.getInt("Quantity");
				issued = rs.getInt("Issue");
				
				
				
			}
				if(quantity>0)
				
				{
					String sql1= "update books set Quantity =?,Issue=? where Callno=?";
					PreparedStatement pst= con.prepareStatement(sql1);
					
					pst.setInt(1, quantity-1);
					pst.setInt(2, issued+1);
					pst.setString(3, Bookcallno);
					status =pst.executeUpdate();
					
					
					
					
				}
				
				
				
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		return status;
	}










	@Override
	public List<Issue> getissued() 
	{
		
		List<Issue> lis = new ArrayList<Issue>();
		
		String sql ="select * from issue";
		
	Statement stm;
	try {
		stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		while(rs.next())
		{
			
			
			Issue is = new Issue();
			is.setId(rs.getInt("Id"));
			
			is.setStudentid(Integer.parseInt(rs.getString("Studentid")));
			is.setStudentname(rs.getString("Studentname"));
			is.setStudentcontact(rs.getString("Studentcontact"));
			
		}
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
		return null;
		
	}

	
	
	private void Populatedata()
	{
		
		String sql ="select * from issue";
		
		
		
		try {
			PreparedStatement	pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
