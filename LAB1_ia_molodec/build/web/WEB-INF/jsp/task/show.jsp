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
        <h1>Просмотр задачи</h1> 
        <table> 
            <tr> 
                <td><label>Название:</label></td> 
                <td>${task.name}</td> 
            </tr> 
            <tr> 
                <td><label>Описание:</label></td> 
                <td>${task.description}</td> 
            </tr> 
            <tr> 
                <td><label>Срок выполнения:</label></td> 
                <td><fmt:formatDate pattern="dd-MM-yyyy" value="${task.dueDate}" /></td> 
            </tr> 
            <tfoot> <th colspan="2" style="padding: 10px 0px;"> 
            <c:url value="/task/${task.id}" var="taskDeleteUrl" /> 
            <form id="deleteForm" action="${taskDeleteUrl}" method="GET"> 
                <input type="hidden" name="delete" /> 
                <input type="submit" value="Удалить" /> 
                </tfoot> 
        </table>
    </body>
</html>