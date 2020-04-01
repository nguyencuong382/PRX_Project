/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.prx.context.DBContext;
import entity.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class RoleDAO extends DAO {
     public List<Role> getRoles() throws Exception {
        List<Role> roles = null;

        Connection conn = null;
        String query = "select * from Role";

        try {
            conn = DBContext.getInstace().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            roles = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String rolename = resultSet.getString("rolename");

                roles.add(new Role(id, rolename));
            }

            this.close(conn);

        } catch (Exception ex) {
            this.close(conn);
            throw ex;
        }
        return roles;
    }
}
