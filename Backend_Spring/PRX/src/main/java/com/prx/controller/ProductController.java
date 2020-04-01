/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.controller;

import com.prx.dto.ProductDTO;
import com.prx.dto.ProductsDTO;
import com.prx.model.Product;
import com.prx.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nc
 */
@RestController
public class ProductController {

    @Autowired
    private IProductService service;

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_XML_VALUE)
    public ProductsDTO finds(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        size = size == null ? 5 : size <= 10 ? size : 10;
        page = page == null ? 0 : page;
        return new ProductsDTO(service.findAll(PageRequest.of(page, size, Sort.by("ProductID"))));
    }

    @GetMapping(value = "/products/{ID}", produces = MediaType.APPLICATION_XML_VALUE)
    public ProductDTO find(@PathVariable Integer ID) {
        return new ProductDTO(service.findByID(ID));
    }

    @GetMapping(value = "/categories/{categoryID}/products", produces = MediaType.APPLICATION_XML_VALUE)
    public ProductsDTO findByCategory(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size,
            @PathVariable Integer categoryID) {
        size = size == null ? 4 : size <= 10 ? size : 10;
        page = page == null ? 0 : page;
        PageRequest pag = PageRequest.of(page, size, Sort.by("ProductID"));
        return new ProductsDTO(service.findByCategory(categoryID, pag));
    }
}
