/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.controller;

import entity.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserDAO;
import session.UserSession;
import com.prx.util.Encrypt;
import com.prx.util.InputValidation;

/**
 *
 * @author Admin
 */
public class LoginController extends HttpServlet {

    InputValidation val = new InputValidation();
    UserDAO userDAO = new UserDAO();
    UserSession userSession = new UserSession();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("servlet", true);
        request.setAttribute("contextPath", request.getContextPath());
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        request.getRequestDispatcher("/view/login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        RequestDispatcher rd;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        try {
            if (val.validLogin(username, password, request)) {
                
                User user = userDAO.getUser(username, Encrypt.parseMD5(password));

                if (user != null) {
                    userSession.setCurrentUser(request, user);
                    String redirect = request.getParameter("redirect");
                    redirect = redirect != null ? redirect : request.getContextPath() + "/";
                    response.sendRedirect(redirect);
                } else {
                    val.addError(request, "Username or password is not correct!");
                    doGet(request, response);
                }
                
            } else {
                doGet(request, response);
            }
        } catch (Exception e) {
            System.out.println(e);
            rd = request.getRequestDispatcher("/view/error/404.jsp");
            rd.forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
