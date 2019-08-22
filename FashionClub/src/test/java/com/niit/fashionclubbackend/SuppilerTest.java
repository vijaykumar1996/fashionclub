package com.niit.fashionclubbackend;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.bean.*;
import com.niit.bean.Supplier;
import com.niit.dao.SupplierDao;
public class SuppilerTest {
	@Autowired
	static SupplierDao supplierDao;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    
	    context.scan("com.niit");
	    context.refresh();
	    
	    supplierDao=(SupplierDao) context.getBean("supplierDao");
	}

	 @Ignore
		@Test
		public void addSupplier()  
		{
			Supplier s=new Supplier();
			s.setSupplierName("vijay");
			s.setSupplierDesc("dress");
			assertTrue("Problem in adding the supplier",supplierDao.adddetails(s));
		
}
		@Ignore
		@Test
		public void deletesupplier()
		{
			Supplier s=supplierDao.getbyId(194);
			assertTrue("Problem in deleting supplier",supplierDao.deletedetails(s));
		}
		@Ignore
		@Test
		public void updatesupplier()
		{
			Supplier s=supplierDao.getbyId(195);
			s.setSupplierName("kumar");
			assertTrue("Problem in deleting supplier",supplierDao.updatedetails(s));
		}
}
