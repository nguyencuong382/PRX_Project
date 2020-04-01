/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.service;

import com.prx.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 *
 * @author nc
 */
public interface IProductService {
    Page<Product> findAll(PageRequest pageRequest);
    Page<Product> findByOrder(PageRequest pageRequest);
    Page<Product> findByCategory(int categoryID, PageRequest pageRequest);
    Product findByID(Integer ID);
}
