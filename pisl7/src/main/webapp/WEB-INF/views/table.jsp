<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table</title>
</head>
<body>
<div class="container">
    <div class="col-md-10">
        <h2>Список пользователей</h2><br>
        <table>
            <thead>
            <tr><th>Фамилия</th><th>Имя</th><th>Инвалидность</th><th>Национальность</th></tr>
            </thead>
            <tbody>
            <jsp:useBean id="listPerson" class="java.util.ArrayList" scope="request"/>
            <c:forEach var="cell" items="${listPerson}">
                <tr>${cell}</tr>
                <tr><a href="edit/${cell.idpersonPisl}">Редактировать</a></tr>
                <tr><a href="delete/${cell.idpersonPisl}">Удаление</a></tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-md-2">
        <form:form method="POST" commandName="person" action="add">
            <form:button>Добавить</form:button>
        </form:form>
    </div>
</div>
</body>
</html>
