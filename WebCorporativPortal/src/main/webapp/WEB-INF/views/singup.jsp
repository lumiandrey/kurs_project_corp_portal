<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sing up</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="../../resources/css/login.css" />
</head>
<body>
<!-- Header -->
<header id="header">
    <h1>Добро пожаловать</h1>
    <p>Шаг 1</p>
</header>

<!-- Signup Form -->
<form:form id="signup-form" method="POST" commandName="person" action="check-fio" role="form">
    <ul>
        <li><div style="margin-top: 1em"><form:input type="text" name="F"  placeholder="F" path="lastName"/>
            <form:errors cssStyle="color: #ac2925" path="lastName" cssClass="error"/>
        </div></li>
        <li><div style="margin-top: 1em"><form:input type="text" name="I"  placeholder="I"  path="name"/>
            <form:errors cssStyle="color: #ac2925" path="name" cssClass="error"/>
        </div></li>
        <li><div style="margin-top: 1em"><form:input type="text" name="O"  placeholder="O"  path="firtsName"/>
            <form:errors cssStyle="color: #ac2925" path="firtsName" cssClass="error"/>
        </div></li>
        <li><div style="margin-top: 1em"><form:input id="age" type="date" min="1920-01-01" max="1998-01-01" path="dateOfBirth"/>
            <form:errors cssStyle="color: #ac2925" path="dateOfBirth" cssClass="error"/>
        </div></li>
        <li><div style="margin-top: 2em" style="width: 91px"><input type="submit" id="send" value="Сохранить"/><a style="margin-left: 2em" href="#">Registration</a>/<a href="login">Autorization</a></div>
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
