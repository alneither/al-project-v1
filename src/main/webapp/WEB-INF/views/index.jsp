<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Welcome! Al's Ads System.</title>
    <link rel="stylesheet" type="text/css" href="/style/styles.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>Have a nice learning</h1>
<c:if test="${not empty requestScope.errorMessage}">
    <div class="err-message">
        ${requestScope.errorMessage}
    </div>
</c:if>

</body>
</html>
