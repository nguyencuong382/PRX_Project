/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.service;

import com.prx.model.OrderDetail;
import com.prx.model.OrderDetailID;
import com.prx.repository.IOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author nc
 */
@Service
public class OrderDetailService implements IOrderDetailService {
    
    @Autowired
    IOrderDetailRepository repository;
    
    @Override
    public Page<OrderDetail> findAll(PageRequest pageRequest) {
        return repository.findAll(pageRequest);
    }

    @Override
    public OrderDetail findByID(OrderDetailID ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
