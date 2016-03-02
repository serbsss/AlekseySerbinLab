<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <c:url value="/task/" var="showTaskUrl" />
    <a href="${showTaskUrl}">Posmotret Vse</a>
    <br>
    <c:url value="/task/add/" var="create" />
    <a href="${create}">Add</a>
</body>
</html>