<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration. Al's Ads System</title>
    <link rel="stylesheet" type="text/css" href="style/styles.css">
</head>
<body>
<c:if test="${not empty requestScope.errorMessage}">
    <div class="err-message">
        <h4>${requestScope.errorMessage}</h4>
    </div>
</c:if>
<div id="register-form">
    <form action="add-user" method="post">
        Login (3-20 alphabetical symbols and digits with no spaces):
        <input type="text" name="login" placeholder="login">
        <br><br>
        Password (8-20 symbols with no spaces):
        <input type="password" name="password" placeholder="password">
        <br><br>
        Repeat password:
        <input type="password" name="password-repeat" placeholder="password again">
        <br><br>
        <input type="submit" value="Register">
    </form>
</div>

</body>
</html>
