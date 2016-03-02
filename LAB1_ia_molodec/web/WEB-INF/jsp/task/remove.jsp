<%-- 
    Document   : remove
    Created on : 24.02.2016, 8:47:20
    Author     : Ceparator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="main">
            <h1 class="title">Удалить задачу</h1>
            <form action="<c:url value="/task/removeConfirm"/>" method="POST">
                <p>Вы дейстительно хотите удалить задачу?</p>
                <input type="hidden" name="id" value="${task.id}"/>
                <input type="submit" value="Удалить"/>
            </form>
            <a class="button" href="<c:url value="/task/list"/>">Вернуться</a>
        </div>
    </body>
</html>
