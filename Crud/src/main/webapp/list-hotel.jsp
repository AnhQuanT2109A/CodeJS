<%--
  Created by IntelliJ IDEA.
  User: quand
  Date: 6/10/2023
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My Hotel</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript">
        function searchHotels() {
            var keyword = document.getElementById("searchKeyword").value;
            window.location.href = "hotelsControllerServlet?command=SEARCH&keyword=" + encodeURIComponent(keyword);
        }
    </script>
</head>
<body>
<div id="wrapper">
    <header id="header">
        <h1>CodeLean Academy</h1>
    </header>
</div>

<div id="container">
    <div id="content">
        <input type="button" value="Add Hotel" onclick="window.location.href='add-hotel-form.jsp'; return false;" class="add-hotel-button" />
        <div id="search-form">
            <input type="text" id="searchKeyword" placeholder="Search hotels..." />
            <input type="button" value="Search" onclick="searchHotels()" />
            <a href="hotelsControllerServlet">Cancel</a>
        </div>
        <table>
            <tr>
                <th>Name:</th>
                <th>Address</th>
                <th>City:</th>
                <th>Country:</th>
                <th>Rating:</th>
                <th>Facilities</th>
                <th>Rooms</th>
            </tr>
            <c:forEach var="tempHotel" items="${HOTEL_LIST}">
                <c:url var="tempLink" value="hotelsControllerServlet">
                    <c:param name="command" value="LOAD"/>
                    <c:param name="hotelId" value="${tempHotel.hotel_id}"/>
                </c:url>
                <c:url var="deleteLink" value="hotelsControllerServlet">
                    <c:param name="command" value="DELETE"/>
                    <c:param name="hotelId" value="${tempHotel.hotel_id}"/>
                </c:url>
                <tr>
                    <td>${tempHotel.name}</td>
                    <td>${tempHotel.address}</td>
                    <td>${tempHotel.city}</td>
                    <td>${tempHotel.country}</td>
                    <td>${tempHotel.rating}</td>
                    <td>${tempHotel.facilities}</td>
                    <td><a href="hotelsControllerServlet?command=ROOMS&hotelId=${tempHotel.hotel_id}">View Rooms</a></td>

                    <td>
                        <a href="${tempLink}" class="update-link">Update</a>
                        <a href="${deleteLink}" class="delete-link" onclick="if (!(confirm('Are you sure you want to delete this hotel?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
