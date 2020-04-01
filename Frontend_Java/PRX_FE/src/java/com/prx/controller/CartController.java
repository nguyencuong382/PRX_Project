/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.controller;

import com.prx.service.OrderService;
import com.prx.util.AppContext;
import entity.Cart;
import entity.OrderRequest;
import entity.User;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXB;
import session.UserSession;

/**
 *
 * @author nc
 */
public class CartController extends HttpServlet {

    CartMapper objectMapper = new CartMapper();
    UserSession userSession = new UserSession();
    OrderService orderService = new OrderService();

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
        Cookie[] cookies = request.getCookies();
        Cookie cartCookie = null;

        for (Cookie cooky : cookies) {
            if ("cart".equals(cooky.getName())) {
                cartCookie = cooky;
            }
        }

        if (cartCookie != null) {
            List<Cart> carts = objectMapper.deserialize(cartCookie.getValue());
            request.setAttribute("carts", carts);
        }
        AppContext ac = new AppContext();
        request.setAttribute("api", ac.env("apiURL"));

        User currentUser = userSession.getCurrentUser(request);
        if (currentUser != null) {
            userSession.authen(request, response);
        }
        request.getRequestDispatcher("/view/cart.jsp").forward(request, response);
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
        String requestName = request.getParameter("submit");
        if (requestName.equals("delete")) {
            deleteFromCart(request, response);
        } else if (requestName.equals("sub")) {
            subFromCart(request, response);
        } else if (requestName.equals("checkout")) {
            checkout(request, response);
        } else {
            addToCart(request, response);
        }
    }

    private void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            User currentUser = userSession.getCurrentUser(request);
            System.out.println(currentUser);
            if (currentUser == null) {
                response.sendRedirect(request.getContextPath() + "/login?redirect=" + "https://www.lemon.casa/PRX_FE/cart");
                return;
            }

            Cookie[] cookies = request.getCookies();
            Cookie cartCookie = null;
            Cookie numProduct = null;

            for (Cookie cooky : cookies) {
                if ("cart".equals(cooky.getName())) {
                    cartCookie = cooky;
                } else if ("numProduct".equals(cooky.getName())) {
                    numProduct = cooky;
                }
            }

            if (cartCookie != null && numProduct != null) {
                List<Cart> carts = objectMapper.deserialize(cartCookie.getValue());

                orderService.sendOrder(new OrderRequest(currentUser, carts));
                cartCookie.setMaxAge(0);
                cartCookie.setValue("");
                response.addCookie(cartCookie);
                
                numProduct.setValue("");
                numProduct.setMaxAge(0);
                response.addCookie(numProduct);
            }
            response.sendRedirect(request.getContextPath() + '/');
        } catch (Exception e) {
            System.out.println(e);
            request.getRequestDispatcher("/view/error/404.jsp").forward(request, response);
        }
    }

    private void deleteFromCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd;
        String productIDStr = request.getParameter("productID");
        String from = request.getParameter("from");
        if (from == null) {
            from = request.getContextPath() + "/";
        }
        try {
            Cookie[] cookies = request.getCookies();
            Cookie cartCookie = null;
            Cookie numProduct = null;

            for (Cookie cooky : cookies) {
                if ("cart".equals(cooky.getName())) {
                    cartCookie = cooky;
                } else if ("numProduct".equals(cooky.getName())) {
                    numProduct = cooky;
                }
            }

            int productID = Integer.parseInt(productIDStr);
            if (cartCookie != null && numProduct != null) {
                List<Cart> carts = objectMapper.deserialize(cartCookie.getValue());
                int i = 0;
                for (; i < carts.size(); i++) {
                    Cart cart = carts.get(i);
                    if (cart.getProductID() == productID) {
                        carts.remove(i);
                        break;
                    }
                }
                numProduct.setValue(carts.size() + "");
                cartCookie.setValue(objectMapper.serialize(carts));
                response.addCookie(cartCookie);
                response.addCookie(numProduct);
            }
            response.sendRedirect(from);
        } catch (Exception e) {
            System.out.println(e);
            rd = request.getRequestDispatcher("/view/error/404.jsp");
            rd.forward(request, response);
        }
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd;
        String productIDStr = request.getParameter("productID");
        String from = request.getParameter("from");
        if (from == null) {
            from = request.getContextPath() + "/";
        }
        try {
            Cookie[] cookies = request.getCookies();
            Cookie cartCookie = null;
            Cookie numProduct = null;

            for (Cookie cooky : cookies) {
                if ("cart".equals(cooky.getName())) {
                    cartCookie = cooky;
                } else if ("numProduct".equals(cooky.getName())) {
                    numProduct = cooky;
                }
            }

            int productID = Integer.parseInt(productIDStr);

            if (cartCookie == null || numProduct == null) {
                List<Cart> cart = new ArrayList<>();
                cart.add(new Cart(productID, 1));
                cartCookie = new Cookie("cart", objectMapper.serialize(cart));
                numProduct = new Cookie("numProduct", "1");
                cartCookie.setMaxAge(604800); // 7 days;
                numProduct.setMaxAge(604800);
                response.addCookie(cartCookie);
                response.addCookie(numProduct);
            } else {
                List<Cart> carts = objectMapper.deserialize(cartCookie.getValue());
                int i = 0;
                for (; i < carts.size(); i++) {
                    Cart cart = carts.get(i);
                    if (cart.getProductID() == productID) {
                        cart.setQuantity(cart.getQuantity() + 1);
                        break;
                    }
                }
                if (i == carts.size()) {
                    carts.add(new Cart(productID, 1));
                }
                numProduct.setValue(carts.size() + "");
                cartCookie.setValue(objectMapper.serialize(carts));
                response.addCookie(cartCookie);
                response.addCookie(numProduct);
            }
            response.sendRedirect(from);
        } catch (Exception e) {
            System.out.println(e);
            rd = request.getRequestDispatcher("/view/error/404.jsp");
            rd.forward(request, response);
        }
    }

    private void subFromCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd;
        String productIDStr = request.getParameter("productID");
        String from = request.getParameter("from");
        if (from == null) {
            from = request.getContextPath() + "/";
        }
        try {
            Cookie[] cookies = request.getCookies();
            Cookie cartCookie = null;
            Cookie numProduct = null;

            for (Cookie cooky : cookies) {
                if ("cart".equals(cooky.getName())) {
                    cartCookie = cooky;
                } else if ("numProduct".equals(cooky.getName())) {
                    numProduct = cooky;
                }
            }

            int productID = Integer.parseInt(productIDStr);

            if (cartCookie != null && numProduct != null) {
                List<Cart> carts = objectMapper.deserialize(cartCookie.getValue());
                int i = 0;
                for (; i < carts.size(); i++) {
                    Cart cart = carts.get(i);
                    if (cart.getProductID() == productID) {
                        if (cart.getQuantity() > 1) {
                            cart.setQuantity(cart.getQuantity() - 1);
                        }
                        break;
                    }
                }
                if (i == carts.size()) {
                    carts.add(new Cart(productID, 1));
                }
                numProduct.setValue(carts.size() + "");
                cartCookie.setValue(objectMapper.serialize(carts));
                response.addCookie(cartCookie);
                response.addCookie(numProduct);
            }
            response.sendRedirect(from);
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
