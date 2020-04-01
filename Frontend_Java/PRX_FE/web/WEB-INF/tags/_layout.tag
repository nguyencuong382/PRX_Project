<%-- 
    Document   : _layout
    Created on : Jan 6, 2019, 11:52:51 PM
    Author     : Admin
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="mt" uri="/WEB-INF/tlds/static"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@attribute name="body" fragment="true" %>

<!DOCTYPE html>
<html>
    <head>
        <title>PRX Market</title>
        <!-- for-mobile-apps -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta data-n-head="ssr" data-hid="description" name="description" content="CUONGNMSE5630 PRX PROJECT IS1207">
        <meta data-n-head="ssr" property="og:image" content="<mt:st/>/static/images/avatar.jpeg">
        <meta data-n-head="ssr" property="og:image:width" content="640">
        <meta data-n-head="ssr" property="og:image:height" content="442">
        <meta property="og:title" content="PRX Market" />
        <meta name="keywords" content="PRX Market" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- //for-mobile-apps -->
        <mt:st type="css" path="bootstrap.css"/>
        <!-- Custom Theme files -->
        <mt:st type="css" path="style.css"/>
        <mt:st type="css" path="custom.css"/>
        <!-- js -->
        <mt:st type="script" path="jquery-1.11.1.min.js"/>
        <!-- //js -->
        <!-- start-smoth-scrolling -->
        <mt:st type="script" path="move-top.js"/>
        <mt:st type="script" path="easing.js"/>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
                });
            });
        </script>
        <!-- start-smoth-scrolling -->
        <mt:st type="css" path="font-awesome.css"/>
        <!-- <link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'> -->
        <!-- <link href='//fonts.googleapis.com/css?family=Noto+Sans:400,700' rel='stylesheet' type='text/css'> -->
        <!--- start-rate---->
        <mt:st type="script" path="jstarbox.js"/>
        <mt:st type="css" path="tarbox.css"/>
        <!--<link rel="stylesheet" href="css/jstarbox.css" type="text/css" media="screen" charset="utf-8" />-->
        <script type="text/javascript">
            jQuery(function () {
                jQuery('.starbox').each(function () {
                    var starbox = jQuery(this);
                    starbox.starbox({
                        average: starbox.attr('data-start-value'),
                        changeable: starbox.hasClass('unchangeable') ? false : starbox.hasClass('clickonce') ? 'once' : true,
                        ghosting: starbox.hasClass('ghosting'),
                        autoUpdateAverage: starbox.hasClass('autoupdate'),
                        buttons: starbox.hasClass('smooth') ? false : starbox.attr('data-button-count') || 5,
                        stars: starbox.attr('data-star-count') || 5
                    }).bind('starbox-value-changed', function (event, value) {
                        if (starbox.hasClass('random')) {
                            var val = Math.random();
                            starbox.next().text(' ' + val);
                            return val;
                        }
                    })
                });
            });
        </script>
        <!---//End-rate---->

    </head>

    <body>
        <div class="header">
            <div class="container">
                <div class="logo">
                    <h1><a href="<mt:st/>">PRX Market</a></h1>
                </div>
                <div class="head-t">
                    <ul class="card">
                        <li><a href="<mt:st/>"><i class="fa fa-home" aria-hidden="true"></i>Home</a></li>


                        <li><a href="<mt:st/>/order"><i class="fa fa-file-text-o" aria-hidden="true"></i>Order History</a></li>
                        <li><a href="<mt:st/>/cart"><i class="fa fa fa-shopping-cart" aria-hidden="true"></i>
                                <span>Cart</span>
                                <span class="badge">${cookie['numProduct'].getValue()}</span>
                            </a>
                        </li>
                        <li><a href="<mt:st/>/api"><i class="fa fa-cog" aria-hidden="true"></i>API</a></li>
                        <c:if test="${not empty user}">
                            <li><a href="<mt:st/>/logout"><i class="fa fa-user" aria-hidden="true"></i>Logout</a></li>
                            </c:if>
                            <c:if test="${empty user}">
                            <li><a href="<mt:st/>/login"><i class="fa fa-user" aria-hidden="true"></i>Login</a></li>
                            </c:if>
                    </ul>
                </div>
            </div>
        </div>

        <jsp:invoke fragment="body"/>
        <!-- smooth scrolling -->
        <script type="text/javascript">
            $(document).ready(function () {
                /*
                 var defaults = {
                 containerID: 'toTop', // fading element id
                 containerHoverID: 'toTopHover', // fading element hover id
                 scrollSpeed: 1200,
                 easingType: 'linear' 
                 };
                 */
                $().UItoTop({easingType: 'easeOutQuart'});
            });
        </script>
        <a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
        <!-- //smooth scrolling -->
        <!-- for bootstrap working -->
        <mt:st type="script" path="bootstrap.js"/>
        <!-- //for bootstrap working -->
        <mt:st type="script" path="jquery.mycart.js"/>
        <script type="text/javascript">
            $(function () {

                var goToCartIcon = function ($addTocartBtn) {
                    var $cartIcon = $(".my-cart-icon");
                    var $image = $('<img width="30px" height="30px" src="' + $addTocartBtn.data("image") + '"/>').css({"position": "fixed", "z-index": "999"});
                    $addTocartBtn.prepend($image);
                    var position = $cartIcon.position();
                    $image.animate({
                        top: position.top,
                        left: position.left
                    }, 500, "linear", function () {
                        $image.remove();
                    });
                }

                $('.my-cart-btn').myCart({
                    classCartIcon: 'my-cart-icon',
                    classCartBadge: 'my-cart-badge',
                    affixCartIcon: true,
                    checkoutCart: function (products) {
                        $.each(products, function () {
                            console.log(this);
                        });
                    },
                    clickOnAddToCart: function ($addTocart) {
                        goToCartIcon($addTocart);
                    },
                    getDiscountPrice: function (products) {
                        var total = 0;
                        $.each(products, function () {
                            total += this.quantity * this.price;
                        });
                        return total * 1;
                    }
                });

            });
        </script>
    </body>
</html>