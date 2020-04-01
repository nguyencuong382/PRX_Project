/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.service;

import com.prx.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 *
 * @author nc
 */
public interface IOrderService {

    Page<Order> findAll(PageRequest pageRequest);
    Page<Order> findByCustomer(String customerID, PageRequest pageRequest);

    Order findByID(Integer ID);
    Order saveOrder(Order order);

}
