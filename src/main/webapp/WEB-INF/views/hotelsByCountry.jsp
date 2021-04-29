<%--
  Created by IntelliJ IDEA.
  User: Adamos
  Date: 25-Apr-21
  Time: 4:46 PM
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
<form:form method="get" modelAttribute="country"
           action="/getHotelsByCountryId/">

    <table>
    <tr>
    <th colspan="2">Show hotels by country</th>
    </tr>
    <tr>
        <td>Country: </td>
        <td>
    <form:select path="id">
        <c:forEach items="${listOfCountries}" var="country">
            <form:option value="${country.id}">${country.name}</form:option>
    </c:forEach>
    </form:select>
        </td>
        <td colspan="2"><input type="submit"
                               class="blue-button" />
        </td>
    </tr>
        <tr>
            <td><a href="<c:url value='/getAllHotelsByCountry' />" >Show all hotels</a></td>
        </tr>
    </table>
</form:form>
    <c:if test="${!empty listOfHotels}">
        <table class="tg">
            <tr>
                <th width="120">Hotel address</th>
                <th width="120">Hotel name</th>
                <th width="120">Hotel phone number</th>
                <th width="120">Country</th>
            </tr>
            <c:forEach items="${listOfHotels}" var="hotel">
                <tr>
                    <td>${hotel.address}</td>
                    <td>${hotel.name}</td>
                    <td>${hotel.phoneNumber}</td>
                    <td>${hotel.country.name}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    </body>
    </html>
