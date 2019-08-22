 package com.niit.daoimpl;
import java.util.*;

import javax.transaction.Transactional;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

import com.niit.bean.Supplier;
import com.niit.dao.*;
@Repository("supplierDao") 
@Transactional
public class SupplierDaoImpl implements SupplierDao {
	@Autowired
SessionFactory sessionfactory;
	public boolean adddetails(Supplier supplier) {
		try{
			sessionfactory.getCurrentSession().save(supplier);
			return true;
		}
		catch (Exception e )
		{
			return false;
		}
		
	}

	public boolean deletedetails(Supplier supplier) {
		try{
			sessionfactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch (Exception e )
		{
			return false;
		}
	}

	public boolean updatedetails(Supplier supplier) {
		try{
			sessionfactory.getCurrentSession().update(supplier);
			return true;
		}
		catch (Exception e )
		{
			return false;
		}
	}

	public List<Supplier> listsupplier(Supplier supplier) {
		Session session =sessionfactory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> list=query.list();
		return list;
	}

	public Supplier getbyId(int supplierId) {
		 Session session=sessionfactory.openSession();
		Supplier id=session.get(Supplier.class,supplierId);
		return id;
	}

}
