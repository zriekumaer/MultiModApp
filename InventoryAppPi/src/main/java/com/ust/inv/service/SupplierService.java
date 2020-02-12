package com.ust.inv.service;

import java.util.Optional;

import com.ust.inv.entity.Supplier;

public interface SupplierService {

	public void insert(Supplier supplier);

    public Optional<Supplier> findById(int id);

    public Iterable<Supplier> findAll();

    public void updateSupplier(Supplier supplier);

    public void deleteSupplier(Supplier supplier);
}
