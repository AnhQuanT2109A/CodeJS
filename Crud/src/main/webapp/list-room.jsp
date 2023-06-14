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
        <a href="hotelsControllerServlet">Cancel</a>
        <table>
            <tr>
                <th>Room ID</th>
                <th>Room Type</th>
                <th>Price</th>
                <th>Availability</th>
                <th>Detail</th>
            </tr>
            <c:forEach var="tempRoom" items="${ROOM_LIST}">
                <tr>
                    <td>${tempRoom.room_id}</td>
                    <td>${tempRoom.room_type}</td>
                    <td>${tempRoom.price}</td>
                    <td>${tempRoom.availability}</td>
                    <td>${tempRoom.detail}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
