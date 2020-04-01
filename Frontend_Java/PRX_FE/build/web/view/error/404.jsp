<%-- 
    Document   : index
    Created on : Oct 22, 2018, 9:38:04 AM
    Author     : smart
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mt" uri="/WEB-INF/tlds/static"%>

<t:_layout>
    <jsp:attribute name="body">
        <div style="height:400px">
            ${error}
        </div>
    </jsp:attribute>
</t:_layout>

