/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.controller;

import entity.Cart;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nc
 */
public class CartMapper {

    public String serialize(List<Cart> items) {
        StringBuffer buffer = new StringBuffer();

        for (Cart item : items) {
            buffer.append(item.getProductID());
            buffer.append("-");
            buffer.append(item.getQuantity());
            buffer.append("--");
        }

        return buffer.toString();
    }

    public List<Cart> deserialize(String str) {
        String strs[] = str.split("--");
        List<Cart> carts = new ArrayList<>();
        
        try {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() > 0) {
                    String ps[] = strs[i].split("-");
                    carts.add(new Cart(Integer.parseInt(ps[0]), Integer.parseInt(ps[1])));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return carts;
    }
}
