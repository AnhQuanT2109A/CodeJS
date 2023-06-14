<%--
  Created by IntelliJ IDEA.
  User: quand
  Date: 6/10/2023
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Hotel</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CodeLean Academy</h2>
    </div>
</div>

<div id="container">
    <h3>Add Hotel</h3>
    <form action="hotelsControllerServlet" method="GET">
        <input type="hidden" value="ADD" name="command">
        <table>
            <tbody>
            <tr>
                <td><label>Name:</label></td>
                <td><input type="text" name="name" required></td>
            </tr>
            <tr>
                <td><label>Address:</label></td>
                <td><input type="text" name="address" required></td>
            </tr>
            <tr>
                <td><label>City:</label></td>
                <td><input type="text" name="city" required></td>
            </tr>
            <tr>
                <td><label>Country:</label></td>
                <td><input type="text" name="country" required></td>
            </tr>
            <tr>
                <td><label>Rating:</label></td>
                <td><input type="text" name="rating" required></td>
            </tr>
            <tr>
                <td><label>Facilities:</label></td>
                <td><input type="text" name="facilities" required></td>
            </tr>
<%--            <tr>--%>
<%--                <td><label>Student Img:</label></td>--%>
<%--                <td><input type="file" name="img"></td>--%>
<%--            </tr>--%>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"></td>
            </tr>
            </tbody>
        </table>
    </form>
    <div style="clear: both"></div>
    <p>
        <a href="hotelsControllerServlet">Back to List</a>
    </p>
</div>
</body>
</html>
