package com.fs.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fs.entity.Critirion;
import com.fs.entity.Product;
import com.fs.entity.User;
import com.fs.mapper.ProductMapper;
import com.fs.service.ProductService;

@Service("productservice")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMapper mapper;
	
	
	@Override
	public  List<Product>  findByPname(String pname) {
		try {
			List<Product> pl=this.mapper.findByPname(pname);
			if(pl!=null){
				return pl;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addProductInfo(Product p) {
		
		
		try {
			if(this.mapper.addProductInfo(p)==1){
				return true;
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> findByPnSn(Integer pn,Integer sn) {
		try {
			List<Product> pl=this.mapper.searchProductByPnSn(new Critirion(pn, sn));
			if(pl!=null){
				return pl;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> findByuid(Integer uid) {
		try {
			List<Product> pl=this.mapper.searchProductByuid(uid);
			if(pl!=null){
				return pl;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> findBytname(String tname) {
		try {
			List<Product> pl=this.mapper.searchProductBytname(tname);
			if(pl!=null){
				return pl;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	

}
