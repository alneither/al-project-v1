<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Welcome! Al's Ads System.</title>
    <link rel="stylesheet" type="text/css" href="/style/styles.css">
</head>
<body>
<script>
    function reportError() {
        alert("${requestScope.errorMessage}");
    }
</script>
<jsp:include page="header.jsp"/>
<h1>Have a nice learning</h1>
<c:if test="${not empty requestScope.errorMessage}">
    <body onload="reportError()"></body>
</c:if>
<c:if test="${not empty sessionScope.user}">
    <a href="/new-ad">Create new ad</a>
</c:if>

</body>
</html>
