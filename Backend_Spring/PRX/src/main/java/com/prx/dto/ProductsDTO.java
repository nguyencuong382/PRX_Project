/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.prx.model.Product;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author nc
 */
public class ProductsDTO extends PageDTO<Product> {

    @JacksonXmlElementWrapper(localName = "products")
    @JacksonXmlProperty(localName = "product")
    private List<Product> content;

    public ProductsDTO(Page<Product> page) {
        super(page);
        content = page.getContent();
    }

    public List<Product> getContent() {
        return content;
    }

    public void setContent(List<Product> content) {
        this.content = content;
    }
}
