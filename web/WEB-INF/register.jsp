<%-- 
    Document   : register.jsp
    Created on : Oct 16, 2021, 7:27:21 PM
    Author     : hazco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="POST" action="ShoppingList">
            <div>
                <label>Username:</label>
                <input type="text" name="name" value="">
                <input type="hidden" name="action" value="register">
                <input type="submit" value="Register name">
            </div>
        </form>
        <div>
            <c:if test="${missingUser}">
                <span>Username is required.</span>
            </c:if>
        </div>
    </body>
</html>
