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
    <style>
        /* CSS cho bảng */
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        /* CSS cho nút "Add Phone" */
        .add-phone-button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin: 10px 0;
            cursor: pointer;
        }
    </style>
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
