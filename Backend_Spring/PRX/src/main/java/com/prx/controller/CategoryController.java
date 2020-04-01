/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.controller;

import com.prx.model.Category;
import com.prx.service.ICategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nc
 */
@RestController
public class CategoryController {
    @Autowired
    private ICategoryService service;

    @GetMapping(value = "/categories", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Category> finds() {
        return service.findAll();
    }

    @GetMapping(value = "/categories/{ID}", produces = MediaType.APPLICATION_XML_VALUE)
    public Object find(@PathVariable Integer ID) {
        return service.findByID(ID);
    }
}
