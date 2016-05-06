<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="../../../resources/css/login.css" />


    <!-- Font Awesome -->
    <link href="../../../resources/css/font-awesome.min.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="../../../resources/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- jVectorMap -->
    <link href="../../../resources/css/jquery-jvectormap-2.0.3.css" rel="stylesheet"/>

    <!-- iCheck -->
    <link href="../../../resources/css/icheck/green.css" rel="stylesheet">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body>
<!-- Header -->
<header id="header">
    <h1>Добро пожаловать</h1>
    <p>в компанию "ДВА Ю"</p>
</header>



<form:form id="signup-form" commandName="user" method="POST" action="user-control/log-in">
    <ul>
        <li>
            <div style="margin-top: 1em"><form:input type="text" name="login" id="login" placeholder="Login" path="login"/></div>
            <form:errors cssStyle="color: #ac2925" path="login" cssClass="error"/>
        </li>
        <li>
            <div style="margin-top: 1em"><form:input type="password" name="password" id="password" placeholder="Password" path="password"/>
                <form:errors cssStyle="color: #ac2925" path="password" cssClass="error"/>
            </div>
        </li>

        <li>
            <div style="margin-top: 2em" style="width: 91px"><input type="submit" value="Вход"/>
                <a style="margin-left:  2em" href="signup-control/signup">Регистрация</a>
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
