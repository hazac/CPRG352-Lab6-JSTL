<%-- 
    Document   : shoppingList.jsp
    Created on : Oct 16, 2021, 7:27:43 PM
    Author     : hazco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <div>
            <p>${message}</p> 
            <a href="ShoppingList?logout">Log out</a>
        </div>
        <div>
            <h2>List</h2>
            <form method="POST" action="ShoppingList">
                <div>
                    <label>Add item:</label>
                    <input type="text" name="item" value="">
                    <input type="submit" value="Add">
                </div>
            </form>
        </div>
        <div>

        </div>    
    </body>
</html>