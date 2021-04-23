<%--
  Created by IntelliJ IDEA.
  User: Adamos
  Date: 23-Apr-21
  Time: 3:19 PM
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
<form:form method="post" modelAttribute="country" action="/travel_agency_system_war_exploded/addCountry">
    <table>
        <tr>
            <th colspan="2">Add Country</th>
        </tr>
        <tr>
            <form:hidden path="id" />
            <td><form:label path="countryCode">Country code:</form:label></td>
            <td><form:input path="countryCode" size="30" maxlength="30"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="name">Country name:</form:label></td>
            <td><form:input path="name" size="30" maxlength="30"></form:input></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   class="blue-button" /></td>
        </tr>
    </table>
</form:form>
<c:if test="${!empty listOfCountries}">
    <table class="tg">
        <tr>
            <th width="80">Country ID</th>
            <th width="120">Country Code</th>
            <th width="120">Country Name</th>
        </tr>
        <c:forEach items="${listOfCountries}" var="country">
            <tr>
                <td>${country.id}</td>
                <td>${country.countryCode}</td>
                <td>${country.name}</td>
                <td><a href="<c:url value='/updateCountry/${country.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/deleteCountry/${country.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
