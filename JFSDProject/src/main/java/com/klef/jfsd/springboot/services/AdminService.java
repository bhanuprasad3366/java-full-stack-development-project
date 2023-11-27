package com.klef.jfsd.springboot.services;

import java.util.List;

import com.klef.jfsd.springboot.models.Admin;
import com.klef.jfsd.springboot.models.Producer;

public interface AdminService 
{

	public String addproducer(Producer pro);
	public List<Producer> viewallproducers();
	public Admin checkAdminLogin(String name,String password);

}
