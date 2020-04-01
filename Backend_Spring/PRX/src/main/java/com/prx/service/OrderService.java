/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.service;

import com.prx.model.Order;
import com.prx.model.OrderDetail;
import com.prx.model.Product;
import com.prx.repository.IOrderRepository;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author nc
 */
@Service
public class OrderService implements IOrderService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    IOrderRepository repository;

    @Autowired
    IProductService reProductRepo;

    @Override
    public Page<Order> findAll(PageRequest pageRequest) {
        return repository.findAll(pageRequest);
    }

    @Override
    public Order findByID(Integer ID) {
        return repository.findById(ID).orElse(new Order());
    }

    @Override
    public Page<Order> findByCustomer(String customerID, PageRequest pageRequest) {
        return repository.findByCustomer(customerID, pageRequest);
    }

    @Transactional
    public Order save(Order entity) {
        em.persist(entity);
        return entity;
    }

    @Transactional
    @Override
    public Order saveOrder(Order order) throws Error {
        for (OrderDetail orderDetail : order.getOrderDetails()) {
            Product prod = reProductRepo.findByID(orderDetail.getProductID());
            if (prod == null) {
                throw new Error("Product not found in the stock");
            }
            if (prod.getUnitsInStock() < orderDetail.getQuantity()) {
                throw new Error(prod.getProductName() + " in the stock is not enough");
            }
            if (prod.getUnitsOnOrder() > 0 && prod.getUnitsOnOrder() < orderDetail.getQuantity()) {
                throw new Error("Max quantity order of " + prod.getProductName() + " is " + prod.getUnitsOnOrder());
            }
            orderDetail.setUnitPrice(prod.getUnitPrice());
        }
        order.setOrderDate(new Date());
//        repository.save(order);
//        return order;
        List<OrderDetail> orderDetails = order.getOrderDetails();
        order.setOrderDetails(null);
        em.persist(order);
        for (OrderDetail orderDetail : orderDetails) {
            orderDetail.setOrderID(order.getOrderID());
            em.merge(orderDetail);
        }
        
        System.out.println("id " + order.getOrderID());
        em.flush();
        return order;
    }

}
