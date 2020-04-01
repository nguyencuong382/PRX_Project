/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.service;

import com.prx.model.OrderDetail;
import com.prx.model.OrderDetailID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 *
 * @author nc
 */
public interface IOrderDetailService {
    Page<OrderDetail> findAll(PageRequest pageRequest);
    OrderDetail findByID(OrderDetailID ID);
}
