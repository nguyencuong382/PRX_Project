/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.prx.model.OrderDetail;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author nc
 */
public class OrderDetailDTO extends PageDTO<OrderDetail>{
    @JacksonXmlElementWrapper(localName = "order_details")
    @JacksonXmlProperty(localName = "order_detail")
    private List<OrderDetail> content;


    public OrderDetailDTO(Page<OrderDetail> page) {
        super(page);
        content = page.getContent();
    }

    public List<OrderDetail> getContent() {
        return content;
    }

    public void setContent(List<OrderDetail> content) {
        this.content = content;
    }
}
