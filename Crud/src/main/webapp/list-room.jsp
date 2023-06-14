<%--
  Created by IntelliJ IDEA.
  User: quand
  Date: 6/12/2023
  Time: 3:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <title>My Room</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="wrapper">
    <header id="header">
        <h1>CodeLean Academy</h1>
    </header>
</div>

<div id="container">
    <div id="content">
        <input type="button" value="Add Room" onclick="window.location.href='add-room-form.jsp'; return false;" class="add-room-button" />
        <table>
            <tr>
                <th>Room ID</th>
                <th>Room Type</th>
                <th>Price</th>
                <th>Availability</th>
                <th>Detail</th>
            </tr>
            <c:forEach var="room" items="${ROOM_LIST}">
                <tr>
                    <td>${room.roomId}</td>
                    <td>${room.roomType}</td>
                    <td>${room.price}</td>
                    <td>${room.availability}</td>
                    <td>${room.detail}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
