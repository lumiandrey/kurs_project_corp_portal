<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Table</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="../../resources/css/bootstrap.css" />
    <!-- Font Awesome -->
    <link href="../../../resources/css/font-awesome.min.css" rel="stylesheet">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-8 left_col">

            <div class="col-md-12 col-sm-12 col-xs-12">

                <div class="x_panel">

                    <div class="x_title">

                        <h2>Список пользователей<small>Веб-клиент к REST</small></h2>

                        <div class="clearfix"></div>

                    </div>

                    <div class="x_content">

                        <div class="table-responsive">
                            <jsp:useBean id="listPerson" class="java.util.ArrayList" scope="request"/>
                            <table class="table table-striped jambo_table bulk_action">
                                <thead>
                                    <tr class="headings">
                                        <th>Фамилия</th>
                                        <th>Имя</th>
                                        <th>Инвалидность</th>
                                        <th>Национальность</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="cell" items="${listPerson}">
                                    <tr class="even pointer">
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
                            <a href="/add">добавление</a>
                        </div>
                    </div>

                </div>

            </div>

        </div>
    </div>
</div>


    </div>
</div>
</body>
</html>
