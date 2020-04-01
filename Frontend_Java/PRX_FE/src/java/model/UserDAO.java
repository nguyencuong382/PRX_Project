/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.prx.context.DBContext;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class UserDAO extends DAO {

    public User getUser(String username, String password) throws Exception {
        User user = null;

        Connection conn = null;
        String query = "select * from [Users] where username = ? and password = ?";

        try {
            conn = DBContext.getInstace().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("CustomerID");
                username = resultSet.getString("username");
                password = resultSet.getString("password");
                int roleId = resultSet.getInt("roleId");
                user = new User(id, username, password, roleId);
                return user;
            }

            this.close(conn);

        } catch (Exception ex) {

            this.close(conn);

            throw ex;
        }
        this.close(conn);
        return user;
    }

    public User getUser(String username) throws Exception {
        User user = null;

        Connection conn = null;
        String query = "select * from [Users] where username = ?";

        try {
            conn = DBContext.getInstace().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("CustomerID");
                String password = resultSet.getString("password");
                int roleId = resultSet.getInt("roleId");

                user = new User(id, username, password, roleId);
                return user;
            }

            this.close(conn);

        } catch (Exception ex) {

            this.close(conn);

            throw ex;
        }
        this.close(conn);
        return user;
    }

    public boolean insert(User u) throws Exception {

        Connection conn = null;
        String query = "INSERT INTO [Users]([username],[password],[roleid]) VALUES(?,?,?,?)";

        int rowEffect = 0;

        try {
            conn = DBContext.getInstace().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setInt(4, u.getRoleId());

            rowEffect = ps.executeUpdate();
            this.close(conn);

        } catch (Exception ex) {
            this.close(conn);
            throw ex;
        }
        return rowEffect == 1;
    }
}
