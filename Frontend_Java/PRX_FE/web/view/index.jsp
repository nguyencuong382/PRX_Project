<%-- 
    Document   : index
    Created on : Mar 28, 2020, 2:53:20 AM
    Author     : nc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@taglib prefix="mt" uri="/WEB-INF/tlds/static"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:_layout>
    <jsp:attribute name="body">
        <c:import url="${api}/categories" var="categories" charEncoding="UTF-8"/>
        <x:parse doc="${categories}" var="categoriesDOM" />
        <p>${pwd}</p>
        <!--content-->
        <div class="content-mid">
            <div class="container">
                <div class="row">
                    <x:forEach select="$categoriesDOM/List/item" var="item">
                        <div class="col col-md-6 col-lg-3">
                            <div class="col-md1 category">
                                <c:set var="categoryID">
                                    <x:out select="$item/categoryID"/>
                                </c:set>
                                <a href="<mt:st/>/category?categoryID=${categoryID}">
                                    <c:set var="image">
                                        <x:out select="$item/image"/>
                                    </c:set>
                                    <mt:st type="img" path="${image}" cls="img-responsive img"/>
                                    <div class="big-sa">
                                        <h4><x:out select="$item/categoryName"/></h4>
                                        <!--<h3>Season<span>ing </span></h3>-->
                                        <p><x:out select="$item/description"/></p>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </x:forEach>
                </div>
            </div>
            <!--content-->

            <!--content-->
            <div class="content">
                <div class="container ">
                    <div class="spec ">
                        <h3>Special Offers</h3>
                        <div class="ser-t">
                            <b></b>
                            <span><i></i></span>
                            <b class="line"></b>
                        </div>
                    </div>
                    <div class="tab-head ">
                        <nav class="nav-sidebar">
                            <ul class="nav tabs ">
                                <x:forEach select="$categoriesDOM/List/item" var="item" varStatus="loop">
                                    <li class="${loop.index == 0 ? 'active':''}"><a href="#tab${loop.index}" data-toggle="tab"><x:out select="$item/categoryName"/></a></li>
                                    </x:forEach>
                            </ul>
                        </nav>
                        <div class=" tab-content tab-content-t ">
                            <x:forEach select="$categoriesDOM/List/item" var="item" varStatus="loop">
                                <c:set var="categoryID">
                                    <x:out select="$item/categoryID"/>
                                </c:set>
                                <c:import url="${api}/categories/${categoryID}/products" var="products" charEncoding="UTF-8"/>
                                <x:parse doc="${products}" var="productsDOM" />

                                <div class="tab-pane ${loop.index == 0 ? 'active':''} text-style" id="tab${loop.index}">
                                    <div class="con-w3l">
                                        <x:forEach select="$productsDOM/prx/products/product" var="product" varStatus="loop">
                                            <c:set var="image">
                                                <x:out select="$product/image"/>
                                            </c:set>

                                            <c:set var="productID">
                                                <x:out select="$product/productID"/>
                                            </c:set>

                                            <div class="col col-sm-12 col-md-3">
                                                <div class="col-m">
                                                    <a href="#" data-toggle="modal" data-target="#myModal${productID}" class="offer-img">
                                                        <mt:st type="img" path="${image}" cls="img-responsive"/>
                                                        <div class="offer">
                                                            <p><span>Offer</span></p>
                                                        </div>
                                                    </a>
                                                    <div class="mid-1">
                                                        <div class="women">
                                                            <h6><a href="<mt:st/>/product?productID=${productID}"><x:out select="$product/productName"/></a></h6>
                                                        </div>
                                                        <div class="mid-2">
                                                            <p><label>$<x:out select="$product/unitPrice"/></label><em class="item_price">$<x:out select="$product/unitPrice"/></em></p>
                                                            <div class="block">
                                                                <div class="starbox small ghosting"> </div>
                                                            </div>
                                                            <div class="clearfix"></div>
                                                        </div>
                                                        <div class="add">
                                                            <form action="<mt:st/>/cart" method="POST">
                                                                <input type="hidden" name="productID" value="${productID}">
                                                                <input type="hidden" name="from" value="<mt:st/>/">
                                                                <button type="submit" name="submit" value="add" class="btn btn-danger my-cart-btn my-cart-b " data-id="1"
                                                                        data-name="Moong" data-summary="summary 1" data-price="1.50"
                                                                        data-quantity="1" data-image="${image}">Add to Cart</button>
                                                            </form>
                                                        </div>

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
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                            </x:forEach>
                        </div>
                    </div>

                </div>
            </div>

            <div class="content-mid"></div>
        </div>
    </jsp:attribute>
</t:_layout>

