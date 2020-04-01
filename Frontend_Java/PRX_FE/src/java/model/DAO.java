/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DAO {
    public void close(Connection con) throws Exception {
        if(con != null && !con.isClosed()) {
            con.close();
        }
    }
}
