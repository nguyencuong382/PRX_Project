/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.repository;

import com.prx.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nc
 */
@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Integer>{
    @Query(value = "SELECT * FROM Products p WHERE p.categoryID = ?1",
           countQuery = "SELECT count(*) FROM Products p WHERE p.categoryID = ?1",
           nativeQuery = true)
    public Page<Product> findByCategory(Integer categoryID, PageRequest pageRequest);
}
