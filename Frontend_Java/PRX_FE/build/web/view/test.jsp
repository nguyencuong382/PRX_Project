<%-- 
    Document   : test
    Created on : Mar 29, 2020, 8:01:07 AM
    Author     : nc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mt" uri="/WEB-INF/tlds/static"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%--<c:import url="http://www.prx.is:8086/products/1" var="product" charEncoding="UTF-8"/>--%>
                <c:import url="http://www.lemon.casa/products/1" var="product" charEncoding="UTF-8"/>

        <x:parse xml="${product}" var="productDOM" />
        <h1>${product}</h1>
    </body>
</html>
