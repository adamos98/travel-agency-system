<%--
  Created by IntelliJ IDEA.
  User: Adamos
  Date: 23-Apr-21
  Time: 9:23 PM
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
            width: 50%;
        }

        th {
            background: SteelBlue;
            color: white;
        }

        td, th {
            border: 1px solid gray;
            width: 25%;
            text-align: left;
            padding: 5px 10px;
        }
    </style>
</head>
<body>
<form:form method="post" modelAttribute="hotel" action="/travel_agency_system_war_exploded/addHotel">
    <table>
        <tr>
            <th colspan="2">Add Hotel</th>
        </tr>
        <tr>
            <form:hidden path="id"/>
            <td><form:label path="address">Address: </form:label></td>
            <td><form:input path="address" size="30" maxlength="30"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="name">Name: </form:label></td>
            <td><form:input path="name" size="30" maxlength="30"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="phoneNumber">Phone number: </form:label></td>
            <td><form:input path="phoneNumber" size="30" maxlength="30"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="country">Country: </form:label></td>
            <td>
                <form:select path="country.id">
                    <c:forEach items="${listOfCountries}" var="countries">
                        <form:option value="${countries.id}">${countries.name}</form:option>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   class="blue-button"/></td>
        </tr>
    </table>
</form:form>
<c:if test="${!empty listOfHotels}">
    <table class="tg">
        <tr>
            <th width="80">Hotel ID</th>
            <th width="120">Hotel address</th>
            <th width="120">Hotel name</th>
            <th width="120">Hotel phone number</th>
            <th width="120">Country</th>
        </tr>
        <c:forEach items="${listOfHotels}" var="hotel">
            <tr>
                <td>${hotel.id}</td>
                <td>${hotel.address}</td>
                <td>${hotel.name}</td>
                <td>${hotel.phoneNumber}</td>
                <td>${hotel.country.name}</td>
                <td><a href="<c:url value='/updateHotel/${hotel.id}' />">Edit</a></td>
                <td><a href="<c:url value='/deleteHotel/${hotel.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
