/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.util;

import java.security.MessageDigest;
import java.sql.Date;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Admin
 */
public class Encrypt {

    public static String parseMD5(String str_) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str_.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        
        return hash;
    }
}
