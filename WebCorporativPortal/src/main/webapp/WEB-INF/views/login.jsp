<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <script src="../../resources/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <!--header-->
        <div class="row">
        </div>
        <!--context-->
        <div class="row">
        <div class="col-md-4">
            <!--form-->
            <form:form method="POST" commandName="user" action="check-user">
                <fieldset>
                    <form:label path="login">Логин:</form:label><br>
                    <form:input path="login" /><br>
                    <form:errors path="login" cssClass="error"/><br>

                    <form:label path="password">Пароль:</form:label><br>
                    <form:password path="password" /><br>
                    <form:errors path="password" cssClass="error"/><br>
                </fieldset>
                <!--Submits-->
                <footer>
                <input type="submit" value="Вход" >
                <input type="submit" value="Регистрация" >
                </footer>
            </form:form>
            </div>
        <div class="col-md-8">
            <h2>Добро пожаловать в корпоративный портал компании "ДВА Ю"</h2><br>

        </div>
        </div>
        <!--footer-->
        <div class="row">
            <footer>
                <p>Copyright &copy; 2016, Коропоративный портал</p>
            </footer>
        </div>
    </div>
    
</body>
</html>
