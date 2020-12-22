package com.fs.service;

import java.util.List;

import com.fs.entity.Product;

public interface ProductService {
	public List<Product> findByPnSn(Integer pn,Integer sn);
	
	public  List<Product>  findByPname(String pname);
	
	public boolean addProductInfo(Product p);
	
	public List<Product> findByuid(Integer uid);
	
	public List<Product> findBytname(String tname);
	
	
	
}
