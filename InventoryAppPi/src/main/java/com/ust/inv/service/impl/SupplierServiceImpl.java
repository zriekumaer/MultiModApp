package com.ust.inv.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ust.inv.domain.SupplierDomain;
import com.ust.inv.entity.Supplier;
import com.ust.inv.service.SupplierService;

@Transactional
@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierDomain supplierDomain;

    public void insert(Supplier supplier) {
    	supplierDomain.insert(supplier);
    }


    public Optional<Supplier> findById(int id) {
        return supplierDomain.findById(id);
    }

    public Iterable<Supplier> findAll() {
        return supplierDomain.findAll();
    }

    public void updateSupplier(Supplier supplier) {
    	supplierDomain.updateSupplier(supplier);
    }

    public void deleteSupplier(Supplier supplier) {
    	supplierDomain.deleteSupplier(supplier);
    }
}