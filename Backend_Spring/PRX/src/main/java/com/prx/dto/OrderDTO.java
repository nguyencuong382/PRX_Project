/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.prx.model.Order;
import com.prx.model.OrderDetail;
import com.prx.model.Product;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author nc
 */
public class OrderDTO extends PageDTO<Order> {
    @JacksonXmlElementWrapper(localName = "orders")
    @JacksonXmlProperty(localName = "order")
    private List<Order> content;


    public OrderDTO(Page<Order> page) {
        super(page);
        content = page.getContent();
    }

    public List<Order> getContent() {
        return content;
    }

    public void setContent(List<Order> content) {
        this.content = content;
    }
}
