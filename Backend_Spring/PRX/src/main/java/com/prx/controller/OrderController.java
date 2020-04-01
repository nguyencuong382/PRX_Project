/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.controller;

import com.prx.ErrorResponse;
import com.prx.dto.OrderDTO;
import com.prx.model.Order;
import com.prx.service.IOrderService;
import com.prx.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nc
 */
@RestController
public class OrderController {

    @Autowired
    private IOrderService service;

    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_XML_VALUE)
    public OrderDTO finds(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        size = size == null ? 5 : size <= 10 ? size : 10;
        page = page == null ? 0 : page;
        Page<Order> re = service.findAll(PageRequest.of(page, size, Sort.by("OrderID").descending()));
        return new OrderDTO(re);
    }

    @GetMapping(value = "/orders/{ID}", produces = MediaType.APPLICATION_XML_VALUE)
    public Object find(@PathVariable Integer ID) {
        return service.findByID(ID);
    }
    
    @GetMapping(value = "/customers/{customerID}/orders", produces = MediaType.APPLICATION_XML_VALUE)
    public OrderDTO findByCustomer(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size,
            @PathVariable String customerID) {
        size = size == null ? 5 : size <= 10 ? size : 10;
        page = page == null ? 0 : page;
        PageRequest pag = PageRequest.of(page, size, Sort.by("OrderID").descending());
        return new OrderDTO(service.findByCustomer(customerID, pag));
    }
    
    @PostMapping(value = "/orders", consumes = MediaType.APPLICATION_XML_VALUE)
    public Object createOrder(@RequestBody Order order) {
        if(order.getCustomer() == null) {
            String customerID = order.getCustomer().getCustomerID();
            if(customerID == null || customerID.trim().length() == 0) {
                return new ErrorResponse("Customer ID is required");
            } 
        }
        
        if(order.getOrderDetails() == null || order.getOrderDetails().size() == 0) {
            return new ErrorResponse("No product in order");
        }
//        try {
            return service.saveOrder(order);
//        } catch (Exception e) {
//            System.out.println(e);
//            return new ErrorResponse(e.getMessage());
//        }
    }
}
