/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.service;

import com.prx.model.Product;
import com.prx.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author nc
 */
@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository repository;

    @Override
    public Page<Product> findAll(PageRequest pageRequest) {
        Page<Product> pagePs = repository.findAll(pageRequest);
        return pagePs;
    }

    @Override
    public Product findByID(Integer ID) {
        return repository.findById(ID).orElse(new Product());
    }

    @Override
    public Page<Product> findByOrder(PageRequest pageRequest) {
//        return repository.
        return null;
    }

    @Override
    public Page<Product> findByCategory(int categoryID, PageRequest pageRequest) {
        Page<Product> pagePs = repository.findByCategory(categoryID, pageRequest);
        return pagePs;
    }

  
   
}
