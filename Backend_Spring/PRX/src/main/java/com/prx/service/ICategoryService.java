/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.service;

import com.prx.model.Category;
import java.util.List;

/**
 *
 * @author nc
 */
public interface ICategoryService {
    List<Category> findAll();
    Category findByID(Integer ID);
}
