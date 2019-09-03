package com.niit.fashionclubbackend;

import static org.junit.Assert.assertTrue;

import org.junit.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.bean.OrderDetail;
import com.niit.dao.OrderDao;
public class OrderDetailsTestcase {

	 static OrderDao orderDao;
	    
	    @BeforeClass    
	    public static void executeFirst()
	    {
	        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		    
		    context.scan("com.niit");
		    context.refresh();
		    
		    orderDao=(OrderDao) context.getBean("orderDao");
	    }
	   
	   @Ignore
		@Test
		public void saveOrdertest() 
		{
			OrderDetail orderDetail=new OrderDetail();
			
			orderDetail.setOrderDate(new java.util.Date());
			orderDetail.setCartId(488);
			orderDetail.setShippingAddr("Mumbai");
			orderDetail.setFinalAmount(2000);
			orderDetail.setTranType("COD");
			orderDetail.setUsername("Lucky");
			
			assertTrue("Problem in saving order",orderDao.saveOrder(orderDetail));
		}
		
		@Test
		public void updateCartTest()
		{
			assertTrue("Problem in updating Cart",orderDao.updateCart("Lucky"));
			
		}

		
}