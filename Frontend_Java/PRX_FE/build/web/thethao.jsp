<%-- 
    Document   : thethao
    Created on : Mar 27, 2020, 5:56:26 PM
    Author     : nc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="https://vnexpress.net/rss/the-thao.rss" var="thethao" charEncoding="UTF-8"/>
        <x:parse doc="${thethao}" var="doc" />
        <x:forEach select="$doc/rss/channel/item" var="item">
            <div>
                <h1>
                   <x:out select="$item/title"/>
                </h1>
                <div> <x:out select="$item/description" escapeXml="yes"/></div>
                <p>
                    <c:set var="pubDate">
                        <x:out select="$item/pubDate"/>
                    </c:set>
                    <fmt:parseDate var="pub" value="${pubDate}" pattern="E, dd MMM yyy"/>
                    <fmt:formatDate value="${pub}" pattern="dd/MM/yyyy"/>
                </p>
            </div>
        </x:forEach>
    </body>
</html>
