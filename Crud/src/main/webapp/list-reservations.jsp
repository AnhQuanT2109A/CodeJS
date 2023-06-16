<%--
  Created by IntelliJ IDEA.
  User: quand
  Date: 6/16/2023
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Đặt phòng</h1>
<form action="ReservationServlet" method="POST">
    <label for="room_id">ID phòng:</label>
    <input type="text" name="room_id" id="room_id"><br><br>

    <label for="user_id">ID người dùng:</label>
    <input type="text" name="user_id" id="user_id"><br><br>

    <label for="check_in_date">Ngày nhận phòng:</label>
    <input type="date" name="check_in_date" id="check_in_date"><br><br>

    <label for="check_out_date">Ngày trả phòng:</label>
    <input type="date" name="check_out_date" id="check_out_date"><br><br>

    <label for="num_guests">Số lượng khách:</label>
    <input type="text" name="num_guests" id="num_guests"><br><br>

    <label for="total_price">Tổng giá:</label>
    <input type="text" name="total_price" id="total_price"><br><br>

    <input type="submit" value="Đặt phòng">
</form>
</body>
</html>
