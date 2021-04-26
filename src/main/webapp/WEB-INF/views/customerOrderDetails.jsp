<%--
  Created by IntelliJ IDEA.
  User: Adamos
  Date: 25-Apr-21
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Title</title>
    <style>
        .blue-button {
            background: #25A6E1;
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#25A6E1', endColorstr='#188BC0', GradientType=0);
            padding: 3px 5px;
            color: #fff;
            font-family: 'Helvetica Neue', sans-serif;
            font-size: 12px;
            border-radius: 2px;
            -moz-border-radius: 2px;
            -webkit-border-radius: 4px;
            border: 1px solid #1A87B9
        }

        table {
            font-family: "Helvetica Neue", Helvetica, sans-serif;
        }

        th {
            background: SteelBlue;
            color: white;
        }

        td, th {
            border: 1px solid gray;
            text-align: left;
            padding: 5px 10px;
        }
    </style>
</head>
<body>
<c:if test="${!empty listOfCustomers}">
    <table class="tg">
        <tr>
            <th >Customer e-mail</th>
            <th >First name</th>
            <th >Last name</th>
            <th >Phone number</th>
            <th >Orders</th>
        </tr>
        <c:forEach items="${listOfCustomers}" var="customer">
            <tr>
                <td>${customer.email}</td>
                <td>${customer.fname}</td>
                <td>${customer.lname}</td>
                <td>${customer.phoneNumber}</td>
                <td><c:forEach items="${customer.bookings}" var="booking">
                    ----------------------------ORDER--------------------------------<br>
                  Booking date placed: ${booking.dateOfOrderPlaced}<br>
                    Booking check in: ${booking.checkIn}<br>
                    Booking check out: ${booking.checkOut}<br>
                    Booking price: ${booking.price}<br>
                Hotel details: ${booking.room.hotel.name} ${booking.room.hotel.address}<br>
                    ------------------------------------------------------------------------<br>
                </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
