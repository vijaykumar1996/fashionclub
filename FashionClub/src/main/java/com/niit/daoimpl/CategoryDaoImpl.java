package com.niit.daoimpl;

import java.util.*;
import javax.transaction.*;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.niit.bean.Category;
import com.niit.dao.CategoryDao;
@Repository("categoryDao") 
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
    SessionFactory sessionFactory;
    
	public boolean addCategory(Category category) {
		
		 try
	        {
	        sessionFactory.getCurrentSession().save(category);
	        return true;
	        }
	        catch(Exception e)
	        {
	        return false;
		}
	}

	public boolean deleteCategory(Category category) {
	
		try
        {
        sessionFactory.getCurrentSession().delete(category);
        return true;
        }
        catch(Exception e)
        {
        return false;
        }
	}

	public boolean updateCategory(Category category) {
		
		try
        {
        sessionFactory.getCurrentSession().update(category);
        return true;
        }
        catch(Exception e)
        {
        return false;
	}
	}

	public List<Category> listCategories() {
		
		 Session session=sessionFactory.openSession();
	        Query query=session.createQuery("from Category");
	        List<Category> listCategories=query.list();
	        session.close();
			return listCategories;
	}

	public Category getCategory(int categoryID) {
		
		   Session session=sessionFactory.openSession();
	        Category category=session.get(Category.class,categoryID);        
			return category ;
	}

}
