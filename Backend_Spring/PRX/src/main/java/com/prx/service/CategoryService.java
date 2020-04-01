/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.service;

import com.prx.model.Category;
import com.prx.repository.ICategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author nc
 */
@Service
public class CategoryService implements ICategoryService {

    @Autowired
    ICategoryRepository repository;
    
    @Override
    public List<Category> findAll() {
        return (List<Category>) repository.findAll();
    }

    @Override
    public Category findByID(Integer ID) {
        return repository.findById(ID).orElse(new Category());
    }
    
}
