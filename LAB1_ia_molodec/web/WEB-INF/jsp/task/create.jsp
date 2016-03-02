<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 class="title">${title}</h1>
        <form action="<c:url value="${sendURL}"/>" method="POST">
            <c:if test="${task.id != null}">
                <input type="hidden" name="id" value="${task.id}"/>
            </c:if>
            <table> 
                <tr>
                    <td><label for="name">Название</label></td>
                    <td><input id="name" name="name" type="text" value="${task.name}"/></td>
                </tr>
                <tr>
                    <td><label for="description">Описание</label></td>
                    <td><input id="description" name="description" type="text" value="${task.description}"/></td>
                </tr>
                <tr>
                    <td><label for="dueDate">Срок выполнения</label></td>
                    <td><input id="dueDate" name="dueDate" type="text" value="${task.dueDate}"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Добавить"/></td>
                </tr>
            </table>
        </form>
        <a href="<c:url value="/task/"/>">Вернуться</a>
    </body>
</html>
