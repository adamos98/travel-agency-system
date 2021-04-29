<%--
  Created by IntelliJ IDEA.
  User: Adamos
  Date: 28-Apr-21
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
    <table>
        <tr>
    <sec:authorize access="hasAuthority('MANAGER')">
    <td><a href="${pageContext.request.contextPath}/getAllCustomers">View all users and their orders</a></td>
    </sec:authorize>
        </tr>
        <tr>
    <sec:authorize access="hasAuthority('MANAGER')">
        <td><a href="${pageContext.request.contextPath}/getAllHotels">Manage hotels</a></td>
    </sec:authorize>
        </tr>
        <tr>
        <sec:authorize access="hasAuthority('MANAGER')">
            <td><a href="${pageContext.request.contextPath}/getAllRooms">Manage rooms</a></td>
        </sec:authorize>
        </tr>
        <tr>
        <sec:authorize access="hasAuthority('MANAGER')">
            <td><a href="${pageContext.request.contextPath}/getAllCountries">Manage countries</a></td>
        </sec:authorize>
        </tr>
        <tr>
    <sec:authorize access="isAuthenticated()">
        <td><a href="${pageContext.request.contextPath}/getAllHotelsByCountry">Find hotel in different countries</a></td>
    </sec:authorize>
        </tr>
        <tr>
    <sec:authorize access="isAuthenticated()">
        <td><a href="${pageContext.request.contextPath}/getAvailableRooms">Check available rooms in hotel in selected period</a></td>
    </sec:authorize>
        </tr>
        <tr>
    <sec:authorize access="isAuthenticated()">
        <td><a href="${pageContext.request.contextPath}/chooseBooking">Book a room</a></td>
        </sec:authorize>
        </tr>
        <tr>
            <sec:authorize access="isAuthenticated()">
                <td><a href="${pageContext.request.contextPath}/logout">LOGOUT</a></td>
            </sec:authorize>
        </tr>
    </table>
</body>
</html>
