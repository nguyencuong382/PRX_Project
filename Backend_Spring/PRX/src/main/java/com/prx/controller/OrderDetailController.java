/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.controller;

import com.prx.dto.OrderDetailDTO;
import com.prx.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prx.service.IOrderDetailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 *
 * @author nc
 */
@RestController
public class OrderDetailController {
    
    @Autowired(required = true)
    private IOrderDetailService service;
    
    @GetMapping(value="/order_details", produces=MediaType.APPLICATION_XML_VALUE)
    public OrderDetailDTO findOrders() {
        System.out.println(service);
       
        
        Page<OrderDetail> re =  service.findAll(PageRequest.of(0, 3, Sort.by("ProductID")));
        
        return new OrderDetailDTO(re);
    }
}
