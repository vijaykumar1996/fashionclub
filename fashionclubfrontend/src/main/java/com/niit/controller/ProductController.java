package com.niit.controller;
import java.io.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.niit.bean.Category;
import com.niit.bean.Product;
import com.niit.dao.*;


@Controller
public class ProductController {
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
    InterfaceMethods productDao;
	
	
	@RequestMapping("/product")
	public String showProduct(Model m)
	{
		Product product=new Product();
		m.addAttribute(product);
		
		
		List<Product> listProducts=productDao.alldetails();
		m.addAttribute("productList",listProducts);
		m.addAttribute("categoryList",this.getCategories());
		m.addAttribute("pageinfo","Manage Product");
		return "Product";
	}
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product")Product product,@RequestParam("pimage") MultipartFile filedet, Model m)
	{
	    productDao.insertdetails(product);
		
		Product product1=new Product();
	    m.addAttribute(product1);
	    m.addAttribute("pageinfo","Manage Product");
	    m.addAttribute("categoryList",this.getCategories());
	    
	    String imagepath="C:\\Users\\ADMIN\\git\\fashionclub\\fashionclubfrontend\\src\\main\\webapp\\resources\\images\\";
	    imagepath=imagepath+String.valueOf(product.getProId())+".jpg";
	    
	    File image=new File(imagepath);
	    
	    if(!filedet.isEmpty()) 
	    {
	    	try
	    	{
	    	      byte buff[]=filedet.getBytes();
	    	      FileOutputStream fs=new FileOutputStream(image);
	    	      BufferedOutputStream bs=new BufferedOutputStream(fs);
	    	      bs.write(buff);
	    	      bs.close();
	    	    		  }
	    	catch(Exception e)
	    	{
	    		m.addAttribute("Exception message","Exception in uploading the image:"+e.getMessage());
	    }
	    }
	    else
	    {
	          m.addAttribute("error message","problem in uploading the image:");	
	    }
	    
	    List<Product> listProducts=productDao.alldetails();
		m.addAttribute("productList", listProducts);
		
	
		return "Product";
	}
	
		
	@RequestMapping(value="/UpdateProduct",method=RequestMethod.POST)
    public String updateProduct(@ModelAttribute("product")Product product,Model m)
	
	{

        productDao.updatedetails(product);
	    
		Product product1=new Product();
		m.addAttribute(product1);
			
		m.addAttribute("pageinfo","Manage product");
		m.addAttribute("categoryList",this.getCategories());
		
		List<Product> listProducts=productDao.alldetails();
		m.addAttribute("productList", listProducts);

		return "Product";
	}
	
	@RequestMapping(value="/deleteProduct/{proId}")
	public String deleteProduct(Model m,@PathVariable("proId")int proId)
	{
		Product product=productDao.getById(proId);
		productDao.deletedetails(product);
		
		Product product1=new Product();
		m.addAttribute(product1);
			
		m.addAttribute("pageinfo","Manage product");
		m.addAttribute("categoryList",this.getCategories());
		
		List<Product> listProducts=productDao.alldetails();
		m.addAttribute("productList", listProducts);

		return "Product";
		}
	
	@RequestMapping(value="/editProduct/{proId}")
	public String editProduct(Model m,@PathVariable("proId")int proId)
	{
		Product product=productDao.getById(proId);
		
		m.addAttribute(product);
		m.addAttribute("pageinfo","Manage Product");
		
		m.addAttribute("categoryList",this.getCategories());
	
		return "UpdateProduct";
	}
	
	@RequestMapping("/productDisplay")
	public String displayProducts(Model m)
	{
		
		m.addAttribute("pageinfo","Product Gallery");
		
		List<Product> listProducts=productDao.alldetails();
		m.addAttribute("productList", listProducts);
		
		return "ProductDisplay";
	}
	@RequestMapping("/productDetailDisplay/{proId}")
	public String productDetailDisplay(@PathVariable("proId")int proId,Model m)
	{
		m.addAttribute("pageinfo","Product Info");
		Product product=productDao.getById(proId);
		
		m.addAttribute("product",product);	
		return "ProductDetailDisplay";
	}
	
		public LinkedHashMap<Integer,String> getCategories()
	    {
		List<Category> listcategories=categoryDao.listCategories();
	     LinkedHashMap<Integer,String> categoryList=new LinkedHashMap<Integer,String>();
	     
	     for(Category category:listcategories)
	      {
	        categoryList.put(category.getCategoryID(),category.getCategoryName());	
	          }
	    return categoryList;
	}	
     
}
