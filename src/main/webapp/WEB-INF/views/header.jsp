<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="style/styles.css">
</head>
<body>
<div class="header">
    <div id="search-form">
        <form action="search-controller" method="get">
            <input type="text" placeholder="search">
            <br>
            <input type="submit" value="search">
        </form>
    </div>
    <c:if test="${empty sessionScope.user}">
        <div id="login-form">
            <form action="login" method="post">
                <input type="text" name="login" placeholder="login">
                <br>
                <input type="password" name="password" placeholder="password">
                <br>
                <input type="submit" value="enter">
            </form>
            <a href="sign-up.jsp">sign-up</a>
        </div>
    </c:if>
</div>
</body>
</html>
