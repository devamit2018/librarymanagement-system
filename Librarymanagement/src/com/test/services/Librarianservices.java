package com.test.services;

import java.util.List;

import com.test.clients.Addlibrarianframe;
import com.test.models.Addbooks;
import com.test.models.Addlibrarian;

public interface Librarianservices {
	
	public boolean AddLibrarian(Addlibrarian li);
	public boolean deletelibrarian(int id);
	
	public List<Addlibrarian> getlibrarians();
	
public boolean validate(String name,String password);
public boolean addbooks(Addbooks ad);


public List<Addbooks> getbooks();




}
