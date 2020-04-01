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
        <!--        <div class="banner-top">
                    <div class="container">
                        <h3 >Cart</h3>
                        <h4><a href="index.html">Home</a><label>/</label>Cart</h4>
                        <div class="clearfix"> </div>
                    </div>
                </div>-->

        <!-- contact -->
        <c:if test="${not empty carts}">
            <div class="check-out">	 
                <div class="container">	 
                    <table class="table ">
                        <tr>
                            <th class="t-head head-it">Products</th>
                            <th class="t-head">Price</th>
                            <th class="t-head">Quantity</th>
                            <th class="t-head">Subtotal</th>
                        </tr>
                        <c:set var="total" value="${0}"/>
                        <c:forEach items="${carts}" var="cart" varStatus="loop">
                            <c:import url="${api}/products/${cart.productID}" var="product" charEncoding="UTF-8"/>
                            <x:parse xml="${product}" var="productDOM" />
                            <c:set var="image">
                                <x:out select="$productDOM/prx/product/image"/>
                            </c:set>
                            <c:set var="priceDOM">
                                <x:out select="$productDOM/prx/product/unitPrice"/>
                            </c:set>
                            <tr class="cross">
                                <td class="ring-in t-data">
                                    <a href="<mt:st/>/product?productID=${cart.productID}" class="at-in">
                                        <mt:st type="img" path="${image}" cls="img-responsive"/>
                                    </a>
                                    <div class="sed">
                                        <h5><x:out select="$productDOM/prx/product/productName"/></h5>
                                    </div>
                                    <div class="clearfix"> </div>
                                    <form action="<mt:st/>/cart" method="POST" onsubmit="return confirm('Do you really want to delete the product?')">
                                        <input type="hidden" name="from" value="<mt:st/>/cart">
                                        <input type="hidden" value="${cart.productID}" name="productID"/>
                                        <div class="close1 mr-5"> 
                                            <button class="btn-link" type="submit" name="submit" value="delete" >
                                                <i class="fa fa-times" aria-hidden="true"></i>
                                            </button>
                                        </div>
                                    </form>
                                </td>
                                <td class="t-data">$<x:out select="$productDOM/prx/product/unitPrice"/></td>
                                <td class="t-data"><div class="quantity"> 
                                        <div class="quantity-select">            
                                            <form action="<mt:st/>/cart" method="POST">
                                                <input type="hidden" name="productID" value="${cart.productID}">
                                                <input type="hidden" name="from" value="<mt:st/>/cart">
                                                <button type="submit" name="submit" value="sub" class="btn btn-link" ${cart.quantity < 2 ? "disabled":""}><div class="entry value-minus">&nbsp;</div></button>
                                            </form>

                                            <div class="entry value"><span class="span-1">${cart.quantity}</span></div>	

                                            <form action="<mt:st/>/cart" method="POST">
                                                <input type="hidden" name="productID" value="${cart.productID}">
                                                <input type="hidden" name="from" value="<mt:st/>/cart">
                                                <button type="submit" name="submit" value="add" class="btn btn-link"><div class="entry value-plus active">&nbsp;</div></button>
                                            </form>

                                        </div>
                                    </div>
                                </td>
                                <td class="t-data t-w3l">
                                    <c:set var="total" value="${total + priceDOM * cart.quantity}" />
                                    <b>$${priceDOM * cart.quantity}</b>
                                </td>
                                <!--<td class="t-data t-w3l"><a class=" add-1" href="single.html">Add To Cart</a></td>-->
                            </tr>
                        </c:forEach>

                    </table>
                    <div class="cart-total">
                        <h3>Total: <b>$${total}</b></h3>
                        <form action="<mt:st/>/cart" method="POST">
                            <button type="submit" name="submit" value="checkout" class="btn add-1 btn-checkout" href="single.html">Checkout</button>
                        </form>
                    </div>

                </div>
            </div>
        </c:if>
        <c:if test="${empty carts}">
            <div class="container">
                <h3>Your cart is empty :( . Go <a href="<mt:st/>/">HOME</a> to continue shopping</h3>
            </div>

            <c:import url="${api}/categories/1/products" var="products" charEncoding="UTF-8"/>
            <x:parse doc="${products}" var="productsDOM" />

            <div class="content-mid">
                <div class="container">
                    <div class="con-w3l">                        
                        <h3>Top product</h3>

                        <div class="row">
                            <x:forEach select="$productsDOM/prx/products/product" var="product" varStatus="loop">
                                <c:set var="image">
                                    <x:out select="$product/image"/>
                                </c:set>

                                <c:set var="productID">
                                    <x:out select="$product/productID"/>
                                </c:set>

                                <div class="col-md-3 m-wthree">
                                    <div class="col-m">
                                        <a href="#" data-toggle="modal" data-target="#myModal${productID}" class="offer-img">
                                            <mt:st type="img" path="${image}" cls="img-responsive"/>
                                            <div class="offer">
                                                <p><span>Offer</span></p>
                                            </div>
                                        </a>
                                        <div class="mid-1">
                                            <div class="women">
                                                <h6><a href="${contextPath}/product?productID=${productID}"><x:out select="$product/productName"/></a></h6>
                                            </div>
                                            <div class="mid-2">
                                                <p><label>$<x:out select="$product/unitPrice"/></label><em class="item_price">$<x:out select="$product/unitPrice"/></em></p>
                                                <div class="block">
                                                    <div class="starbox small ghosting"> </div>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                            <form action="<mt:st/>/cart" method="POST">
                                                <input type="hidden" name="productID" value="${productID}">
                                                <input type="hidden" name="from" value="<mt:st/>/cart">
                                                <button type="submit" name="submit" value="add" class="btn btn-danger my-cart-btn my-cart-b ">Add to Cart</button>
                                            </form>

                                        </div>
                                    </div>
                                </div>



                                <div class="modal fade" id="myModal${productID}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content modal-info">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                                        aria-hidden="true">&times;</span></button>
                                            </div>
                                            <div class="modal-body modal-spa">
                                                <div class="col-md-5 span-2">
                                                    <div class="item">
                                                        <mt:st type="img" path="${image}" cls="img-responsive"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-7 span-1 ">
                                                    <h3><x:out select="$product/productName"/></h3>
                                                    <p class="in-para"> There are many variations of passages of Lorem Ipsum.</p>
                                                    <div class="price_single">
                                                        <span class="reducedfrom "><del>$2.00</del> $<x:out select="$product/unitPrice"/></span>

                                                        <div class="clearfix"></div>
                                                    </div>
                                                    <h4 class="quick">Quick Overview:</h4>
                                                    <p class="quick_desc"> Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet
                                                        doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; es</p>
                                                    <div class="add-to">
                                                        <button class="btn btn-danger my-cart-btn my-cart-btn1 " data-id="1" data-name="Moong"
                                                                data-summary="summary 1" data-price="1.50" data-quantity="1"
                                                                data-image="images/of.png">Add to Cart</button>
                                                    </div>
                                                </div>
                                                <div class="clearfix"> </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </x:forEach>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
        </c:if>


    </jsp:attribute>
</t:_layout>

