<%--
  Created by IntelliJ IDEA.
  User: Adamos
  Date: 25-Apr-21
  Time: 3:01 PM
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
        .blue-button{
            background: #25A6E1;
            filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);
            padding:3px 5px;
            color:#fff;
            font-family:'Helvetica Neue',sans-serif;
            font-size:12px;
            border-radius:2px;
            -moz-border-radius:2px;
            -webkit-border-radius:4px;
            border:1px solid #1A87B9
        }
        table {
            font-family: "Helvetica Neue", Helvetica, sans-serif;
            width: 50%;
        }
        th {
            background: SteelBlue;
            color: white;
        }
        td,th{
            border: 1px solid gray;
            width: 25%;
            text-align: left;
            padding: 5px 10px;
        }
    </style>
</head>
<body>
<form:form method="post" modelAttribute="room" action="/addRoom">
    <table>
        <tr>
            <th colspan="2">Add Room</th>
        </tr>
        <tr>
            <form:hidden path="id" />
            <td><form:label path="numberOfRoom">Number of room: </form:label></td>
            <td><form:input path="numberOfRoom" size="30" maxlength="30"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="hotel">Hotel: </form:label></td>
            <td>
                <form:select path="hotel.id">
                    <c:forEach items="${listOfHotels}" var="hotel">
                        <form:option value="${hotel.id}">${hotel.name} ${hotel.address}</form:option>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   class="blue-button" /></td>
        </tr>
    </table>
</form:form>
<c:if test="${!empty listOfRooms}">
    <table class="tg">
        <tr>
            <th width="80">Room ID</th>
            <th width="120">Number of room</th>
            <th width="120">Hotel of room</th>
        </tr>
        <c:forEach items="${listOfRooms}" var="room">
            <tr>
                <td>${room.id}</td>
                <td>${room.numberOfRoom}</td>
                <td>${room.hotel.name} ${room.hotel.address}</td>
                <td><a href="<c:url value='/updateRoom/${room.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/deleteRoom/${room.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
