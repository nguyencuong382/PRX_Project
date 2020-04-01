/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonManagedReference;

/**
 *
 * @author nc
 */
@Entity(name = "OrderDetails")
@Table(name = "OrderDetails")
@XmlRootElement
@IdClass(OrderDetailID.class)
@NamedQueries({
    @NamedQuery(name = "OrderDetail.findAll", query = "SELECT od FROM OrderDetails od")})
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(value = { "category" })
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    
//    @EmbeddedId
//    private OrderDetailID id;
    @Id
    private Integer orderID;
    
    @Id
    private Integer productID;


    @Basic(optional = false)
    @NotNull
    @Column(name = "UnitPrice")
    private BigDecimal unitPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Quantity")
    private short quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Discount")
    private float discount;
    
    @JsonBackReference
    @JsonIgnore
    @JoinColumn(name = "OrderID", referencedColumnName="OrderID", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Order order;

    @JsonManagedReference
    @JoinColumn(name = "ProductID", referencedColumnName="ProductID", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Product product;
    
    

    public Order getOrder() {
        return order;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

//    public OrderDetailID getId() {
//        return id;
//    }
//
//    public void setId(OrderDetailID id) {
//        this.id = id;
//    }

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


    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

   

}
