/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.prx.context.DBContext;
import entity.Feature;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class FeatureDAO extends DAO {

    public List<Feature> getFeaturesByUserId(int roleId) throws Exception {
        List<Feature> features = null;

        Connection conn = null;
        String query = "select F.id, F.url from [User] U\n"
                + "inner join RoleFeature RF on RF.roleid = U.roleid\n"
                + "inner join Feature F on F.id = RF.featureid\n"
                + "where U.id = ?";

        try {
            conn = DBContext.getInstace().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, roleId);

            ResultSet resultSet = ps.executeQuery();
            features = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String url = resultSet.getString("url");

                features.add(new Feature(id, url));
            }

            this.close(conn);

        } catch (Exception ex) {
            this.close(conn);
            throw ex;
        }
        return features;
    }
}
