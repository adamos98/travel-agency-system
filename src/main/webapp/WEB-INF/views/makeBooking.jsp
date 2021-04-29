<%--
  Created by IntelliJ IDEA.
  User: Adamos
  Date: 29-Apr-21
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
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
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#checkIn" ).datepicker({ dateFormat: "yy-mm-dd" });
        } );
        $( function() {
            $( "#checkOut" ).datepicker({ dateFormat: "yy-mm-dd" });
        } );
    </script>
</head>
<body>

<form:form method="post" modelAttribute="bookingParameters" action="/addBooking">
<c:if test="${!empty listOfAllRooms}">
    <table class="tg">
        <tr>
            <th width="120">Number of room</th>
            <th width="120">Hotel name</th>
            <th><a href="${pageContext.request.contextPath}/homePage">Go to homepage</a></th>
        </tr>
        <c:forEach items="${listOfAllRooms}" var="room">
            <tr>
                <form:hidden path="hotelId" value="${room.hotel.id}"/>
                <form:hidden path="checkIn" value="${bookingParameters.checkIn}"/>
                <form:hidden path="checkOut" value="${bookingParameters.checkOut}"/>
                <form:hidden path="roomId" value="${room.id}"/>

                <td>${room.numberOfRoom}</td>
                <td>${room.hotel.name} ${room.hotel.address}</td>
                <td><input type="submit"
                           class="blue-button" value="Book a room" /></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</form:form>
</body>
</html>
