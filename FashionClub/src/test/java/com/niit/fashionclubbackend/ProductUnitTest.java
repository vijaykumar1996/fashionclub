package com.niit.fashionclubbackend;

import static org.junit.Assert.assertTrue;

import org.junit.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.bean.Product;
import com.niit.dao.InterfaceMethods;
public class ProductUnitTest {
@Autowired
static InterfaceMethods interfacemethods;
@BeforeClass
public static void firstexecute(){
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
    
    context.scan("com.niit");
    context.refresh();
    interfacemethods=(InterfaceMethods) context.getBean("interfacemethods");
}
@Ignore
@Test
public  void addproduct()
{
	Product p=new Product();
	p.setProName("jeans");
	p.setProDesc("party wear");
	p.setProprice(2000);
	p.setStock(10);
	p.setSupplierId(1);
	p.setCategoryID(2);
	assertTrue("Problem in adding the product",interfacemethods.insertdetails(p));
	
}
@Ignore
@Test
public void deleteproduct(){
	Product s=interfacemethods.getById(226);
	assertTrue("Problem in deleting product",interfacemethods.deletedetails(s));

}
@Test
@Ignore
public void updateproduct(){
	Product s=interfacemethods.getById(194);
	assertTrue("Problem in update product",interfacemethods.updatedetails(s));

}
}
