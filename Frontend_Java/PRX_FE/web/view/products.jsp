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
        <c:import url="${api}/categories/${param.categoryID}/products?size=12" var="products" charEncoding="UTF-8"/>
        <x:parse xml="${products}" var="productsDOM" />

        <c:import url="${api}/categories/${param.categoryID}" var="category" charEncoding="UTF-8"/>
        <x:parse xml="${category}" var="categoryDOM" />

        <div class="content-mid">
            <div class="container">
                <div class="category-title">
                    <c:set var="image">
                        <x:out select="$categoryDOM/Category/image"/>
                    </c:set>
                    <mt:st type="img" path="${image}" cls="img-responsive"/>
                    <h3> <x:out select="$categoryDOM/Category/categoryName"/></h3>
                </div>
                <div class="con-w3l">                        
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
                                            <input type="hidden" name="from" value="<mt:st/>/product?productID=${productID}">
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
                                                <form action="<mt:st/>/cart" method="POST">
                                                    <input type="hidden" name="productID" value="${productID}">
                                                    <input type="hidden" name="from" value="<mt:st/>/product?productID=${productID}">
                                                    <button type="submit" name="submit" value="add" class="btn btn-danger my-cart-btn my-cart-b ">Add to Cart</button>
                                                </form>
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
    </jsp:attribute>
</t:_layout>

