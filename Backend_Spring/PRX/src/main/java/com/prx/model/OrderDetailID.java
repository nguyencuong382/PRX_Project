/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author nc
 */
@Embeddable
public class OrderDetailID implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Column(name = "OrderID")
    private Integer orderID;

    @Column(name = "ProductID")
    private Integer productID;


    public OrderDetailID(Integer orderID, Integer productID) {
        this.orderID = orderID;
        this.productID = productID;
    }
    
    public OrderDetailID() {
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OrderDetailID that = (OrderDetailID) o;

        if (productID != that.getProductID()) {
            return false;
        }
        return orderID == that.getOrderID();
    }

    @Override
    public int hashCode() {
        int result = productID == null ? 0 : productID.hashCode();
        result = 31 * result + (orderID == null ? 0 : orderID.hashCode());
        return result;
    }

}
