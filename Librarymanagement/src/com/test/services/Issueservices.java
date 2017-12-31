package com.test.services;

import java.util.List;

import com.test.models.Addlibrarian;
import com.test.models.Issue;

public interface Issueservices
{
	
	
	public boolean Checkbook(String Bookcallno);
	
	public int Save(String Bookcallno,int Studentid,String Studentname,String Studentcontact);
	
	public int update(String Bookcallno);
	
	public List<Issue> getissued();
	
	
	

}
