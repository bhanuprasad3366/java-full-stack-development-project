package com.klef.jfsd.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.models.Product;
import com.klef.jfsd.springboot.repositories.ProductRepository;



@Service
public class ProductServiceImpl implements ProductService
{

	@Autowired
	private ProductRepository productRepository;
	
	
	public String addproduct(Product product)
	{
		productRepository.save(product);
		return "Product Added Sucessfully";
	}

	
	public List<Product> viewallproducts() 
	{
		return productRepository.findAll();
	}
	
	public List<Product> getProductsByProducerId(int producerId)
	{
	        return productRepository.findAllProductsByProducerId(producerId);
   }

}
