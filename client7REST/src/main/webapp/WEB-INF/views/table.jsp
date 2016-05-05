<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Table</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="../../resources/css/bootstrap.css" />
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
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
                <tr>
                    <td>${cell.firstName}</td>
                    <td>${cell.name}</td>
                    <td>${cell.disability}</td>
                    <td>${cell.nationality}</td>
                    <td><a href="/edit/${cell.idpersonPisl}">Редактировать</a></td>
                    <td><a href="/delete/${cell.idpersonPisl}">Удаление</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <a href="/add">добавление</a>
    </div>
</div>
</body>
</html>
