<%--
  Created by IntelliJ IDEA.
  User: Adamos
  Date: 27-Apr-21
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie-edge">
    <title>Document</title>
</head>
<body>
<form name="signIn" action="/signIn" method="post"
      style="width: 30%; background-color: black;margin:auto">


    <br>
    <label for="Username">
        Email:
        <div>
            <input type="text" placeholder="Email" id="Username" name="username" value=''>
        </div>
    </label>
    <br>
    <label for="Password">
        Password:
        <div>
            <input type="password" placeholder="Password" id="Password" name="password">
        </div>
    </label>

    <br>
    <br>
    <input name="submit" type="submit" value="Log in"
           class="form-control btn" style="background-color: yellowgreen;width:80px;margin-bottom: 8px;">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
