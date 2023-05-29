<%--
  Created by IntelliJ IDEA.
  User: quand
  Date: 5/26/2023
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Book list</h1>
    <a href="books?action=new">Add new Book</a>
    <form action="books" method="GET">
        <input type="hidden" name="action" value="search">
        <input type="text" name="searchTerm" placeholder="Tìm kiếm theo tên sáchhh">
        <button type="submit">Tìm kiếm</button>
    </form>

<table border="1">
    <tr>
        <td>ID</td>
        <td>Name Book</td>
        <td>Name Author</td>
        <td>Price</td>
        <td>Quantity</td>
    </tr>
    <c:forEach var="bookArr" items="${bookList}">
        <tr>
            <td>${bookArr.id}</td>
            <td>${bookArr.nameBook}</td>
            <td>${bookArr.nameAuthor}</td>
            <td>${bookArr.price}</td>
            <td>${bookArr.quantity}</td>

            <td>
                <a href="books?action=edit&id=${bookArr.id}">Edit</a>
                <a href="books?action=delete&id=${bookArr.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
