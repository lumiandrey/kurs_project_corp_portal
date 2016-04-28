<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="../../resources/css/login.css" />
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body>
<!-- Header -->
<header id="header">
    <h1>Добро пожаловать</h1>
    <p>в компанию "ДВА Ю"</p>
</header>

<!-- Signup Form -->
<form:form id="signup-form" commandName="user" method="POST" action="check-user">
    <ul>
        <li>
            <div style="margin-top: 1em"><form:input type="text" name="email" id="email" placeholder="Login" path="login"/></div>
            <form:errors cssStyle="color: #ac2925" path="login" cssClass="error"/>
        </li>
        <li>
            <div style="margin-top: 1em"><form:input type="password" name="password" id="password" placeholder="Password" path="password"/>
                <form:errors cssStyle="color: #ac2925" path="password" cssClass="error"/>
            </div>
        </li>

        <li>
            <div style="margin-top: 2em" style="width: 91px"><input type="submit" value="Вход"/>
                <a style="margin-left: 2em" href="/sing-up">Регистрация</a>/<a href="#">Авторизация</a>
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
