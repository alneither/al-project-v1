<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>New ad creation</title>
</head>
<body>
<script>
    function reportError() {
        alert("${requestScope.errorMessage}");
    }
</script>
<c:if test="${not empty requestScope.errorMessage}">
    <body onload="reportError()"></body>
</c:if>
<div class="new-add-compose">
    <form action="add-new-ad" name="new-add-form" method="post">
        <textarea name="ad-header" rows="2" cols="50" placeholder="Header"></textarea>
        <textarea name="ad-body" rows="5" cols="51" placeholder="Your ad body"></textarea>
        <textarea name="ad-contact" rows="2" cols="50" placeholder="Contacts"></textarea>
        <input type="submit"/>
    </form>
</div>
</body>
</html>
