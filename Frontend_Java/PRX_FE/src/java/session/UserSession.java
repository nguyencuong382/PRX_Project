/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Feature;
import entity.User;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class UserSession {

    public User getCurrentUser(HttpServletRequest request) {
        User currentUser = (User) request.getSession().getAttribute("userx");
        return currentUser;
    }

    public void setCurrentUser(HttpServletRequest request, User user) {
        request.getSession().setAttribute("userx", user);
    }

    public void logoutUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("userx");
    }

    public void authen(HttpServletRequest request, HttpServletResponse response) {
        User u = this.getCurrentUser(request);
        request.setAttribute("user", u);
    }

    public boolean author(HttpServletRequest request, User user) throws Exception {
        List<Feature> features = user.getFeatures();
        String currentUri = request.getRequestURI();

        for (Feature feature : features) {
            System.out.println(feature.getUrl());
            System.out.println(feature.getUrl() + request.getContextPath());
            if (currentUri.equalsIgnoreCase(request.getContextPath() + feature.getUrl())) {
                return true;
            }
        }

        return false;
    }
}
