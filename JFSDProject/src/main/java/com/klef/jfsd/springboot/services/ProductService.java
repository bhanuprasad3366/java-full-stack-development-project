package com.klef.jfsd.springboot.services;

import java.util.List;

import com.klef.jfsd.springboot.models.Product;

public interface ProductService 
{

	public String addproduct(Product product);
	public List<Product> viewallproducts();
	  public List<Product> getProductsByProducerId(int producerId);
	
}
