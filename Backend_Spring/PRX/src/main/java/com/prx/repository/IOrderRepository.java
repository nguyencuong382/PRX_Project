/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.repository;

import com.prx.model.Order;
import static javafx.scene.input.KeyCode.T;
import javax.transaction.Transactional;
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
public interface IOrderRepository extends PagingAndSortingRepository<Order, Integer> {

    @Query(value = "SELECT * FROM Orders p WHERE p.CustomerID = ?1",
            countQuery = "SELECT count(*) FROM Orders p WHERE p.CustomerID = ?1",
            nativeQuery = true)
    public Page<Order> findByCustomer(String customerID, PageRequest pageRequest);

    

    
}
