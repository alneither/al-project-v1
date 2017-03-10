<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="/style/styles.css">
</head>
<body>
<div class="header">
    <div id="search-form">
        <form action="search" method="get">
            <input type="text" placeholder="search">
            <br>
            <input type="submit" value="search">
        </form>
    </div>
    <c:choose>
    <c:when test="${empty sessionScope.username}">
        <div id="login-form">
            <form action="login" method="post">
                <input type="text" name="login" placeholder="login">
                <br>
                <input type="password" name="password" placeholder="password">
                <br>
                <input type="submit" value="enter">
            </form>
            <a href="/registration">sign-up</a>
        </div>
    </c:when>
        <c:otherwise>
            <h4>Welcome ${sessionScope.username}</h4>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
