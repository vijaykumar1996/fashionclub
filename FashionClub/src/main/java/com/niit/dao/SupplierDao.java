package com.niit.dao;

import java.util.*;

import com.niit.bean.*;

public interface SupplierDao {
	public boolean  adddetails(Supplier supplier); 
	 public  boolean deletedetails(Supplier supplier);
	 public boolean updatedetails(Supplier supplier);
	 public List<Supplier> listsupplier();
	 public Supplier getbyId(int supplierId);
}
