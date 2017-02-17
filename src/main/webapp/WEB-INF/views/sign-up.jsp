<%--
  Created by IntelliJ IDEA.
  User: Al
  Date: 1/17/2017
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration. Al's Ads System</title>
</head>
<body>
<div id="register-form">
  <form action="sign-up-controller" method="post">
    Login name:
    <input type="text" name="firstname" placeholder="Login name">
    <br><br>
    E-mail:
    <input type="text" name="email" placeholder="E-mail">
    <br><br>
    Password:
    <input type="password" name="password" placeholder="password">
    <br><br>
    Repeat password:
    <input type="password" name="password-renew" placeholder="password">
    <br><br>
    Register:
    <input type="submit" value="Register">
  </form>

</div>

</body>
</html>
