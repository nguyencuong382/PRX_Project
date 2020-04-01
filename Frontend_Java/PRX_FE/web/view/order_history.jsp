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
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<t:_layout>
    <jsp:attribute name="body">

        <c:import url="${api}/customers/${user.id}/orders" var="orders" charEncoding="UTF-8"/>
        <x:parse xml="${orders}" var="ordersDOM" />

        <div class="check-out">	 
            <div class="container">
                <table class="table">
                    <tr>
                        <th class="t-head head-it">Order ID</th>
                        <th class="t-head">Product</th>
                        <th class="t-head">Order Date</th>
                        <th class="t-head">Total</th>
                    </tr>
                    <x:forEach select="$ordersDOM/prx/orders/order" var="order" varStatus="loop">
                        <c:set var="total" value="${0}"/>
                        <tr class="cross">
                            <td class="t-data">
                                <x:out select="$order/orderID"/>
                            </td>
                            <td class="t-data">
                                <x:forEach select="$order/order_details/order_detail" var="order_detail" varStatus="loop">
                                    <c:set var="image">
                                        <x:out select="$order_detail/product/image"/>
                                    </c:set>
                                    <c:set var="productID">
                                        <x:out select="$order_detail/product/productID"/>
                                    </c:set>
                                    <a href="<mt:st/>/product?productID=${productID}" class="at-in">
                                        <mt:st type="img" path="${image}" cls="img-responsive"/>
                                    </a>
                                    <c:set var="priceDOM">
                                        <x:out select="$order_detail/product/unitPrice"/>
                                    </c:set>
                                    <c:set var="quantity">
                                        <x:out select="$order_detail/quantity"/>
                                    </c:set>
                                    <c:set var="total" value="${total + priceDOM*quantity}" />
                                </x:forEach>
                            </td>
                            <td class="t-data">
                                <c:set var="orderDate">
                                    <x:out select="$order/orderDate"/>
                                </c:set>
                                <fmt:parseDate var="pub" value="${orderDate}" pattern="yyyy-MM-dd"/>
                                <fmt:formatDate value="${pub}" pattern="dd/MM/yyyy"/>
                            </td>
                            <td class="t-data t-w3l">
                                <b>$${total}</b>
                            </td>
                        </tr>
                    </x:forEach>

                </table>
            </div>
        </div>
    </jsp:attribute>
</t:_layout>

