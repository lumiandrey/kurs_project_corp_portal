<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="../../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../../resources/css/style.css">
    <script src="../../../resources/js/bootstrap.min.js"></script>
</head>
<body>
<!--header-->
<header class = "upper">
</header>
<div class="container">
    <!--context-->
    <div class="row">
        <div class="col-md-3 form-group">
            <!--form-->
            <form:form method="POST" commandName="user" action="check-user" role="form">
                <fieldset>
                    <br>
                    <br>
                    <form:label path="login">Логин:</form:label><br>
                    <form:input class="col-md-8" path="login"/><br><br>

                    <form:label path="password">Пароль:</form:label><br>
                    <form:password class="col-md-8" path="password"/><br><br>
                </fieldset>
                <!--Submits-->
                    <input class="btn btn-primary col-md-8" type="submit" value="Вход"><br><br>
            </form:form>
            <form:form method="POST" commandName="user" action="sing-up" role="form">
                <input class="btn btn-primary col-md-8" type="submit" value="Регистрация">
            </form:form>
        </div>
        <div class="col-md-6">
            <!--context-->
            <h2>Добро пожаловать в корпоративный портал компании "ДВА Ю"</h2><br>
            <p>Мы рады приветствовать вас на корпоративном портале нашей компании. Все пользователи данного портала
                являются сотрудниками компании. </p><br>
            <p>Если вы являетесь сотрудником компании, пожалуйста, войдите в систему или зарегистрируйтесь. Если вы
                попали на этот сайт случайно, извините, но дальше путь вам закрыт.</p>
            <!--footer-->
        </div>
        <div class="col-md-3"></div>
    </div>
</div>

<footer class="col-md-offset-5">
    <p>Copyright &copy; 2016, Коропоративный портал "ДВА Ю"</p>
</footer>
    
</body>
</html>
