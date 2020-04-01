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
        <!--banner-->
        <div class="banner-top">
            <div class="container">
                <h3 >Public API</h3>
                <h4><a href="index.html">Home</a><label>/</label>API</h4>
                <div class="clearfix"> </div>
            </div>
        </div>
        <div class="container">
            <div class="apis">
                <div class="api">
                    <a href="https://api.lemon.casa/products" target="_blank" class="btn btn-link btn-primary">GET</a>
                    <p class="api-link">/rest/products</p>
                    <p class="api-description">(Get list of products)</p>
                </div>
                <div class="api">
                    <a href="https://api.lemon.casa/products/1" target="_blank" class="btn btn-link btn-primary">GET</a>
                    <p class="api-link">/rest/products/{productID}</p>
                    <p class="api-description">(Get product by ID)</p>
                </div>
                <div class="api">
                    <a href="https://api.lemon.casa/categories" target="_blank" class="btn btn-link btn-primary">GET</a>
                    <p class="api-link">/rest/categories</p>
                    <p class="api-description">(Get list of categories)</p>
                </div>
                 <div class="api">
                    <a href="https://api.lemon.casa/categories/1" target="_blank" class="btn btn-link btn-primary">GET</a>
                    <p class="api-link">/rest/categories/{categoryID}</p>
                    <p class="api-description">(Get category by ID)</p>
                </div>
                <div class="api">
                    <a href="https://api.lemon.casa/categories/1/products" target="_blank" class="btn btn-link btn-primary">GET</a>
                    <p class="api-link">/rest/categories/{categoryID}/products</p>
                    <p class="api-description">(Get list of products of a category)</p>
                </div>
                <div class="api">
                    <a href="https://api.lemon.casa/orders" target="_blank" class="btn btn-link btn-primary">GET</a>
                    <p class="api-link">/rest/orders</p>
                    <p class="api-description">(Get list of orders)</p>
                </div>
                <div class="api">
                    <a href="https://api.lemon.casa/customers/LAZYK/orders" target="_blank" class="btn btn-link btn-primary">GET</a>
                    <p class="api-link">/rest/categories/{customerID}/orders</p>
                    <p class="api-description">(Get list of orders of a customer)</p>
                </div>
                <div class="api api-post">
                    <div class="api-wrapper">
                        <a href="#"  class="btn btn-link btn-success">POST</a>
                        <p class="api-link">/rest/orders</p>
                        <p class="api-description">(Create a order)</p>

                    </div>
                    <div class="api-body">
<xmp>
    <order>
        <customer>
            <customerID>VINET</customerID>
        </customer>
        <order_details>
            <order_detail>
                <productID>11</productID>
                <quantity>2</quantity>
            </order_detail>
            <order_detail>
                <productID>12</productID>
                <quantity>1</quantity>
            </order_detail>
        </order_details>
    </order>
</xmp>
                    </div>
                </div>
            </div>
        </div>
    </jsp:attribute>
</t:_layout>

