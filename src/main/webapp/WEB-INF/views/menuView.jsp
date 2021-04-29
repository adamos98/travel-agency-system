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
</head>
<body>
<ul class="navbar">
    <sec:authorize access="hasAuthority('MANAGER')">
    <li><a href="${pageContext.request.contextPath}/getAllCustomers">View all users and their orders</a></li>
    </sec:authorize>
    <sec:authorize access="hasAuthority('MANAGER')">
    <li><a href="${pageContext.request.contextPath}/getAllHotels">Manage hotels</a></li>
    </sec:authorize>
        <sec:authorize access="hasAuthority('MANAGER')">
        <li><a href="${pageContext.request.contextPath}/getAllRooms">Manage rooms</a></li>
        </sec:authorize>
        <sec:authorize access="hasAuthority('MANAGER')">
        <li><a href="${pageContext.request.contextPath}/getAllCountries">Manage countries</a></li>
        </sec:authorize>
    <sec:authorize access="isAuthenticated()">
    <li><a href="${pageContext.request.contextPath}/getAllHotelsByCountry">Find hotel in different countries</a></li>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
    <li><a href="${pageContext.request.contextPath}/getAvailableRooms">Check available rooms in hotel in selected period</a></li>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <li><a href="${pageContext.request.contextPath}/logout">LOGOUT</a></li>
        </sec:authorize>
</body>
</html>
