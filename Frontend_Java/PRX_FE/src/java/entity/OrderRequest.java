/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nc
 */
@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderRequest {

    private User customer;

    @XmlElementWrapper(name = "order_details")
    @XmlElement(name = "order_detail")
    List<Cart> orderDetail;

    public OrderRequest() {
    }

    public OrderRequest(User customer, List<Cart> orderDetail) {
        this.customer = customer;
        this.orderDetail = orderDetail;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public List<Cart> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<Cart> orderDetail) {
        this.orderDetail = orderDetail;
    }

}
