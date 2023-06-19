<%--
  Created by IntelliJ IDEA.
  User: quand
  Date: 6/19/2023
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="container">
    <h3>Add Phone</h3>
    <form action="phoneControllerServlet" method="GET">
        <input type="hidden" value="ADD" name="command">
        <table>
            <tbody>
            <tr>
                <td><label>Name:</label></td>
                <td><input type="text" name="name" required></td>
            </tr>
            <tr>
                <td><label>Brand:</label></td>
                <td><input type="text" name="brand" required></td>
            </tr>
            <tr>
                <td><label>Description:</label></td>
                <td><input type="text" name="description" required></td>
            </tr>
            <tr>
                <td><label>Price:</label></td>
                <td><input type="text" name="price" required></td>
            </tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"></td>
            </tr>
            </tbody>
        </table>
    </form>
    <div style="clear: both"></div>
    <p>
        <a href="phoneControllerServlet">Back to List</a>
    </p>
</div>
</body>
</html>
