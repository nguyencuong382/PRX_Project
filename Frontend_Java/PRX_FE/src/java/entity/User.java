/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import model.FeatureDAO;

/**
 *
 * @author Admin
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    @XmlElement(name = "customerID")
    private String id;
    @XmlTransient 
    public String username;
    @XmlTransient 
    public String password;
    @XmlTransient 
    public int roleId;

    public User() {
    }

    public User(String id, String username, String password, int roleId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Feature> getFeatures() throws Exception {
        return new FeatureDAO().getFeaturesByUserId(roleId);
    }
}
