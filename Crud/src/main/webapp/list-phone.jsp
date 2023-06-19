<%--
  Created by IntelliJ IDEA.
  User: quand
  Date: 6/19/2023
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="container">
    <div id="content">
        <input type="button" value="Add Phone" onclick="window.location.href='add-phone-form.jsp'; return false;" class="add-phone-button" />
        <table>
            <tr>
                <th>Name:</th>
                <th>Brand</th>
                <th>Description:</th>
                <th>Price:</th>
            </tr>
            <c:forEach var="tempPhone" items="${PHONE_LIST}">
                <tr>
                    <td>${tempPhone.name}</td>
                    <td>${tempPhone.brand}</td>
                    <td>${tempPhone.description}</td>
                    <td>${tempPhone.price}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
