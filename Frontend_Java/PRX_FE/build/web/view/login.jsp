<%-- 
    Document   : index
    Created on : Mar 28, 2020, 2:53:20 AM
    Author     : nc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mt" uri="/WEB-INF/tlds/static"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:_layout>
    <jsp:attribute name="body">
       	<div class="login">

            <div class="main-agileits">

                <div class="form-w3agile">
                    <h3>Login</h3>
                    <c:if test="${not empty errors}">
                        <div class="text-danger">
                            <c:forEach var="e" items="${errors}">
                                <p>${e}</p>
                            </c:forEach>
                        </div>
                    </c:if>
                    <form class="form form-table" action="<mt:st/>/login?redirect=${param.redirect}" method="post">
                        <div class="key">
                            <i class="fa fa-user" aria-hidden="true"></i>
                            <input   type="text" name="username" value="johnsteel" required="">
                            <div class="clearfix"></div>
                        </div>
                        <div class="key">
                            <i class="fa fa-lock" aria-hidden="true"></i>
                            <input  type="password" value="123456" name="password" required="">
                            <div class="clearfix"></div>
                        </div>
                        <input type="submit" value="Login">
                    </form>
                </div>
                <div class="forg">
                    <!--<a href="#" class="forg-left">Forgot Password</a>-->
                    <!--<a href="register.html" class="forg-right">Register</a>-->
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </jsp:attribute>
</t:_layout>

