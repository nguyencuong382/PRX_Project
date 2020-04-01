/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.repository;

import com.prx.model.OrderDetail;
import com.prx.model.OrderDetailID;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nc
 */
@Repository
public interface IOrderDetailRepository extends PagingAndSortingRepository<OrderDetail, OrderDetailID> {
    
}
