package com.niit.daoimpl;

import java.util.*;
import javax.transaction.Transactional;
import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import com.niit.bean.Product;
import com.niit.dao.InterfaceMethods;
@Repository("interfacemethods") 
@Transactional
public class MethodImpl implements InterfaceMethods {
@Autowired
SessionFactory sessionfactory;
	public boolean insertdetails(Product product) {
		try{
			sessionfactory.getCurrentSession().save(product);
			return true;
		}
		catch (Exception e){
			return false;
		}
		}

	public boolean deletedetails(Product product) {
		try{
			sessionfactory.getCurrentSession().delete(product);
			
			return true;
		}
		catch (Exception e){
			return false;
		}
	}

	public boolean updatedetails(Product product) {
		try{
			sessionfactory.getCurrentSession().update(product);
			return true;
		}
		catch (Exception e){
			return false;
		}
	}

	public List<Product> alldetails() {
      Session s=sessionfactory.openSession();
      Query q=s.createQuery("from product");
      List<Product> alldetails=q.list();
      s.close();
		return alldetails;
	}

	public Product getById(int proId) {
		Session s=sessionfactory.openSession();
		Product p=s.get(Product.class ,proId);
		return p;
	}

}
