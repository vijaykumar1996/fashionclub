package com.niit.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.bean.Supplier;
import com.niit.dao.SupplierDao;



@Controller
public class SupplierController 
{
	@Autowired
    SupplierDao supplierDao;
	
	
	@RequestMapping("/supplier")
	public String showSupplier(Model m)
	{
		List<Supplier> listSuppliers=supplierDao.listsupplier();
		m.addAttribute("listSuppliers",listSuppliers);
		m.addAttribute("pageinfo","Manage Supplier");
		return "Supplier";
	}
	@RequestMapping(value="/AddSupplier",method=RequestMethod.POST)
	public String addSupplier(Model m,@RequestParam("sName")String supplierName,@RequestParam("sDesc")String supplierDesc)
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName(supplierName);
		supplier.setSupplierDesc(supplierDesc);
		supplierDao.adddetails(supplier);
		
		List<Supplier> listSuppliers=supplierDao.listsupplier();
		m.addAttribute("listSuppliers", listSuppliers);
		
		m.addAttribute("pageinfo","Manage Supplier");
		return "Supplier";
	}
	
	@RequestMapping(value="/deleteSupplier/{supplierId}")
	public String deleteSupplier(Model m,@PathVariable("supplierId")int supplierId)
	{
		Supplier supplier=supplierDao.getbyId(supplierId);
		supplierDao.deletedetails(supplier);

		List<Supplier> listSuppliers=supplierDao.listsupplier();
		m.addAttribute("listSuppliers", listSuppliers);
		m.addAttribute("pageinfo","Manage Supplier");
		return "Supplier";
	}
		@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	public String updateSupplier(Model m,@RequestParam("sId")int supplierId,@RequestParam("sName")String supplierName,@RequestParam("sDesc")String supplierDesc)
	{
		Supplier supplier=supplierDao.getbyId(supplierId);
		supplier.setSupplierName(supplierName);
		supplier.setSupplierDesc(supplierDesc);
		supplierDao.updatedetails(supplier);
		
		List<Supplier> listSuppliers=supplierDao.listsupplier();
		m.addAttribute("listSuppliers", listSuppliers);
		
		m.addAttribute("pageinfo","Manage Supplier");
		return "Supplier";
	}
		@RequestMapping(value="/editSupplier/{supplierId}")
		public String editSupplier(Model m,@PathVariable("supplierId")int supplierId)
		{
			Supplier supplier=supplierDao.getbyId(supplierId);
			
			m.addAttribute("supplier",supplier);
			m.addAttribute("pageinfo","Manage Supplier");
			return "UpdateSupplier";
		}

}