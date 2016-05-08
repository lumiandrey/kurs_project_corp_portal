<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sing up</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="../../../resources/css/login.css" />
</head>
<body>
<!-- Header -->
<header id="header">
    <h1>Регистрация</h1>
    <p>Шаг 1</p>
</header>

<!-- Signup Form -->

<form:form id="signup-form" modelAttribute="person" method="POST" action="/signup-control/check-fio">
    <ul>

        <li>
            <div style="margin-top: 1em"><form:input type="text" path="lastName" placeholder="фамилия"/></div>
                <form:errors cssStyle="color: #ac2925" path="lastName" cssClass="error"/>

        </li>
        <li>
            <div style="margin-top: 1em"><form:input type="text" placeholder="имя" path="name"/></div>
            <form:errors cssStyle="color: #ac2925" path="name" cssClass="error"/>

        </li>
        <li>
            <div style="margin-top: 1em"><form:input type="text" placeholder="отчество" path="patronymic"/></div>
            <form:errors cssStyle="color: #ac2925" path="patronymic" cssClass="error"/>

        </li>

        <li>
            <div style="margin-top: 2em" style="width: 91px"><input type="submit" value="следующий шаг"/>

            </div>
        </li>
    </ul>
</form:form>
<!-- Footer -->
<footer id="footer">
    <ul class="copyright">
        <li>&copy; "ДВА Ю"</li>
    </ul>
</footer>

<!-- Scripts -->
<script src="assets/jз/main.js"></script>
<script src="main.js"></script>
</body>
</html>
