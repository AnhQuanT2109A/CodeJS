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
    <h1>Book form</h1>
    <c:choose>
        <c:when test="${empty book.id}">
            <form action="books?action=create" method="POST">
                <label for="nameBook">Name Book:</label>
                <input type="text" id="nameBook" name="nameBook">
                <br><br>
                <label for="nameAuthor">Name Author:</label>
                <input type="text" id="nameAuthor" name="nameAuthor">
                <br><br>
                <label for="price">Price: </label>
                <input type="text" id="price" name="price">
                <br><br>
                <label for="quantity">Quantity:</label>
                <input type="text" id="quantity" name="quantity">
                <br><br>
                <input type="submit" value="Create">
                <a href="books" class="button">Cancel</a>
            </form>
        </c:when>

        <c:otherwise>
            <form action="books?action=update" method="POST">
                <input type="hidden" name="id" value="${book.id}">
                <label for="nameBook">Name Book:</label>
                <input type="text" id="nameBook" name="nameBook" value="${book.nameBook}">
                <br><br>
                <label for="nameAuthor">Name Author:</label>
                <input type="text" id="nameAuthor" name="nameAuthor" value="${book.nameAuthor}">
                <br><br>
                <label for="price">Price:</label>
                <input type="text" id="price" name="price" value="${book.price}">
                <br><br>
                <label for="quantity">Quantity:</label>
                <input type="text" id="quantity" name="quantity" value="${book.quantity}">

                <input type="submit" value="Update">
                <a href="books">Cancel</a>
                <br><br>
            </form>
            <form action="books?action=delete" method="POST">
                <input type="hidden" name="id" value="${book.id}">
                <input type="submit" value="Delete">
            </form>
        </c:otherwise>
    </c:choose>
</body>
</html>
