package com.test.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.database.Dbconnection;
import com.test.models.Addbooks;
import com.test.models.Addlibrarian;

public class Librarianservicesimpl implements Librarianservices 
{

	Connection con = null;
	
	public Librarianservicesimpl() 
	{
		
		
		con= Dbconnection.getdbconnnection();
		
		
		
	}
	
	
	
	@Override
	public boolean AddLibrarian(Addlibrarian li) 
	{
		String sql ="insert into Library(Name,Password,Email,Address,City,Phone) values(?,?,?,?,?,?)";
		
		
		try {
			
			PreparedStatement 	pstm = con.prepareStatement(sql);
			pstm.setString(1, li.getName());
			pstm.setString(2, li.getPassword());
			pstm.setString(3, li.getEmail());
			pstm.setString(4, li.getAddress());
			pstm.setString(5, li.getCity());
			pstm.setString(6, li.getPhone());
			
			pstm.execute();
			return true;
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}

	@Override
	public boolean deletelibrarian(int id) 
	{
		String sql ="delete from Library where id='"+id+"'";
		
		
		try {
			
			Statement stm = con.createStatement();
			stm.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}



	@Override
	public List<Addlibrarian> getlibrarians() {
		
		List<Addlibrarian> lis = new ArrayList<Addlibrarian>();
		String sql ="select * from Library";
		
		 
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next())
			{
				Addlibrarian li = new Addlibrarian();
				li.setId(rs.getInt("id"));
				li.setName(rs.getString("Name"));
				li.setPassword(rs.getString("Password"));
				li.setEmail(rs.getString("Email"));
				li.setAddress(rs.getString("Address"));
				li.setCity(rs.getString("City"));
				li.setPhone(rs.getString("Phone"));
				lis.add(li);
				
				
				
				
			}
			return lis;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return null;
	}

	@Override
	public boolean validate(String name,String password)
	{
		boolean status= false;
		
		String sql="select * from Library where Name=? and Password=?";
		
		
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, password);
			
			ResultSet rs = pstm.executeQuery();
			status =rs.next();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}



	@Override
	public boolean addbooks(Addbooks ad) 
	{
String sql ="insert into books(Callno,Name,Author,Publisher,Quantity,Issue) values(?,?,?,?,?,?)";


        
		try {
			PreparedStatement	pstm = con.prepareStatement(sql);
			 pstm.setString(1,ad.getCallno());
			 pstm.setString(2, ad.getName());
			 pstm.setString(3, ad.getAuthor());
			 pstm.setString(4, ad.getPublisher());
			 pstm.setInt(5, ad.getQuantity());
			 pstm.setInt(6, ad.getIssue());
			// pstm.setTimestamp(7, ad.getAddeddate());
			 
			 pstm.executeUpdate();
			 
			 return true;
			 
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

             
              
              
              

		return false;
	}



	@Override
	public List<Addbooks> getbooks() {
		
		List<Addbooks> lad = new ArrayList<>();
		
		String sql ="select * from books";
		
		
		 
		try {
			
			Statement	stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next())
			{
				
				Addbooks ad = new Addbooks();
				ad.setId(rs.getInt("Id"));
				ad.setCallno(rs.getString("Callno"));
				ad.setName(rs.getString("Name"));
				ad.setAuthor(rs.getString("Author"));
				ad.setPublisher(rs.getString("publisher"));
				ad.setQuantity(rs.getInt("Quantity"));
				ad.setIssue(rs.getInt("Issue"));
				ad.setAddeddate(rs.getTimestamp("Addeddate"));
				lad.add(ad);
				
				
			}
			return lad;
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		return null;
	}



	
	
}
