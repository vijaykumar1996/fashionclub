package com.niit.fashionclubbackend;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.bean.CartItem;
import com.niit.dao.CartDao;
public class CartTestcases {

static CartDao cartDao;
	
	@BeforeClass
	public static void executeFirst()
	{
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    context.scan("com.niit");
	    context.refresh();
	    
	    cartDao=(CartDao)context.getBean("cartDao");
	}

	@Ignore
	@Test
	public void addCartItemtest() 
	{
		CartItem cartItem=new CartItem();
		cartItem.setProId(451);
		cartItem.setProName("jkvf");
		cartItem.setQuantity(2);
		cartItem.setProprice(2000);
		cartItem.setPaymentStatus("NP");
		cartItem.setUsername("kumar");
		
		assertTrue("problem in adding Item into Cart",cartDao.addCartItem(cartItem));
	}
	
	@Ignore
	@Test
	public void listAllCartItems()
	{
		
		List<CartItem> listCartItems=cartDao.listCartItems("kumar");
		
		assertTrue("Problem in listing the CartItems",listCartItems.size()>0);
		
		for(CartItem cartItem:listCartItems)
		{
			System.out.print(cartItem.getProId()+"\t");
			System.out.print(cartItem.getProName()+"\t");
			System.out.print(cartItem.getProprice()+"\t");
			System.out.print(cartItem.getQuantity()+"\t");
			
		}
		
	}
	
	@Ignore
	@Test
	public void updateCartItemTest()
	{
		CartItem cartItem=cartDao.getCartItem(449);
		cartItem.setQuantity(5);
		assertTrue("Problem occured while updating cartItem",cartDao.updateCartItem(cartItem));
	}
	
	@Ignore
	@Test
	public void deleteCartItemTest()
	{
		CartItem cartItem=cartDao.getCartItem(449);
		
		assertTrue("Problem occured while deleting cartItem",cartDao.deleteCartItem(cartItem));
	}

}