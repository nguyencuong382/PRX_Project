/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.util;

/**
 *
 * @author nc
 */
public class Utils {
    public static void validPagination(Integer page, Integer size) {
        size = size == null ? 5 : size <= 10 ? size : 10;
        page = page == null ? 0 : page;
    }
}
