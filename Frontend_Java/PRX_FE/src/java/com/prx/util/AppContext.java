package com.prx.util;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class AppContext{
    private static Map<String, String> conf;
    
    private Context initContext;

    public AppContext() {
        conf = new HashMap<>();
        try {
            this.initContext = new InitialContext();
        } catch (NamingException ex) {
        }
    }

    public String env(String name){
        String value = conf.get(name);
        
        if(value == null)
        try {
            value = (String) this.initContext.lookup("java:comp/env/" + name);
        } catch (NamingException ex) {
            
        }
        
        return value;
    }
}
