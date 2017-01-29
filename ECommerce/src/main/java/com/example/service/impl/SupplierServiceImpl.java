package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.SupplierDao;
import com.example.model.Supplier;
import com.example.service.SupplierService;

public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	SupplierDao supplierDao;
	

	@Override
	public void addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		supplierDao.addSupplier(supplier);
	}

	@Override
	public void updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		supplierDao.updateSupplier(supplier);
	}

	@Override
	public boolean deleteSupplier(int supplier_id) {
		// TODO Auto-generated method stub
		return supplierDao.deleteSupplier(supplier_id);
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		// TODO Auto-generated method stub
		return supplierDao.getAllSuppliers();
	}

	@Override
	public Supplier getSupplierById(int supplier_id) {
		// TODO Auto-generated method stub
		return supplierDao.getSupplierById(supplier_id);
	}
}