package com.niit.dao;

import java.util.List;

import com.niit.bean.*;
public interface InterfaceMethods {
public boolean insertdetails(Product product);
public boolean deletedetails(Product product);
public boolean updatedetails(Product product);
public List<Product> alldetails();
public Product getById(int proId);
}
