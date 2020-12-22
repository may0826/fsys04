package com.fs.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import com.fs.entity.Product;
import com.fs.entity.User;
import com.fs.service.ProductService;
import com.fs.service.UserService;
import com.fs.util.GlobalVariables;

@Controller("productcontroller")
public class ProductController {
	
	@Autowired
	ProductService productservice;
	@Autowired
	UserService userservice;
	
	@RequestMapping("/ProductReg")
	public String productReg(@RequestParam("title")String title,@RequestParam("price")Float price,@RequestParam("note")String note,
			@RequestParam("type")String type, HttpSession session,@RequestParam MultipartFile file){	
		
		    User u = (User) session.getAttribute(GlobalVariables.USERINFO);
		    
		   Product p = new Product();
		   
		  
		String filePath = session.getServletContext().getRealPath("/images");; //定义图片上传后的路径
		  
			  String name=UUID.randomUUID().toString().replace("-", "");
		
			
			  try {
				file.transferTo(new File(filePath,name+"_430x430.jpg"));
				String lastname=name+"_430x430.jpg";
				p.setImga(lastname);
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  
		
		   p.setPtime(new Date());
		   p.setUid(u.getUid());
		   p.setPprice(price);
		   p.setPname(title);
		   p.setDes(note);
		  p.setTname(type);
		  
		   
		
		if (this.productservice.addProductInfo(p)) {
			System.out.println("publish success");
			return "redirect:publish.html";
		} else {
			System.out.println("publish failed");
			return "redirect:error1.html";
		}
	}
	
	@RequestMapping(path="/searchproduct",method=RequestMethod.GET)
	@ResponseBody
	public  List<Product> search(@RequestParam("pname") String pname, HttpServletRequest request) {
		
		try {
			pname = new String(pname.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(pname);
		List<Product>  p=this.productservice.findByPname(pname);
		
		if (p== null) {
			System.out.println("没能找到这个商品");
			return null;
		} else {
			
           
			return p;
		}
	}
	
	@RequestMapping("/getlistproduct")
	@ResponseBody
	public List<Product> getProduct(@RequestParam("pn") Integer pn,@RequestParam("sn") Integer sn) {
		List<Product> back=this.productservice.findByPnSn(pn, sn);
		return back;
		
	}
	@RequestMapping(path="/mineproduct",method=RequestMethod.GET)
	@ResponseBody
	public  List<Product> search( HttpSession session, HttpServletRequest request) {
		 User u = (User) session.getAttribute(GlobalVariables.USERINFO);
		 Integer  uid=u.getUid();
		 System.out.println(uid);
		List<Product>  p=this.productservice.findByuid(uid.intValue());
		
		if (p== null) {
			System.out.println("这位用户未发布商品");
			return null;
		} else {
			System.out.println("已经找到该用户发布的商品");

			request.setAttribute(GlobalVariables.PRODUCTINFO, p);
			List<Product> pl =  (List<Product>) request.getAttribute(GlobalVariables.PRODUCTINFO);
           
			return pl;
		}
	}
	@RequestMapping("/getproductbytname")
	@ResponseBody
	public List<Product> getProductbypname(@RequestParam("tname") String tname) {
		try {
			tname = new String(tname.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(tname);
		List<Product> back=this.productservice.findBytname(tname);
		return back;
		
	}
}
