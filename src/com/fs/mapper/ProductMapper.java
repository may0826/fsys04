package com.fs.mapper;

import java.util.List;

import com.fs.entity.Critirion;
import com.fs.entity.Product;

public interface ProductMapper {
	/*添加商品信息信息*/
	public int addProductInfo(Product product) throws Exception;
	
	/*根据主键查询某条商品信息记录*/
	public  List<Product>  findByPname(String pname) throws Exception;
	
	/*根据uid查询某条商品信息记录*/
	 public List<Product> searchProductByuid(Integer uid)throws Exception;
	 
	 /*根据ptid查询某条商品信息记录*/
	 public List<Product> searchProductBytname(String tname)throws Exception;
	 
	 /*根据pname查询某条商品信息记录*/
	 public List<Product> searchProductByPnSn(Critirion c)throws Exception;
	 

	/*删除商品信息记录*/
	public void deleteProductInfo(String pname) throws Exception;

}
