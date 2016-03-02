<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table> 
            <thead> 
            <th>#</th> 
            <th>Название</th> 
            <th>Описание</th> 
            <th>Срок выполнения</th> 
            <th>Действия</th> 
        </thead> 
        <c:choose>
            <c:when test="${fn:length(taskList) gt 0}">
                <c:forEach var="task" items="${taskList}" varStatus="status">
                    <tr> 
                        <td><c:out value="${status.count}" /></td> 
                        <td><c:out value="${task.name}" /></td> 
                        <td><c:out value="${task.description}" /></td>
                        <td><c:out value="${task.dueDate}" /></td>
                        <td><a href="<c:url value="${task.id}"/>">Посмотреть</a></td>
                        <td><a href="<c:url value="${task.id}/edit"/>">Редактировать</a></td>
                        <td><a href="<c:url value="${task.id}/remove"/>">Удалить</a></td>
                    </c:forEach>
                </c:when>
                <c:otherwise> 
                <tr> 
                    <td colspan="5">Список пуст</td> 
                </tr> 
            </c:otherwise> 
        </c:choose>
    </table>
</body>
</html>