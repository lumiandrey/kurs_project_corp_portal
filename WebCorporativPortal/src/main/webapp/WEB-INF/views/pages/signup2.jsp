<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%--
  Created by IntelliJ IDEA.
  User: Yuliya
  Date: 26.04.2016
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sing Up</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="../../../resources/css/login.css" />
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

    <script type="text/javascript">
        function doAjax() {
            $.ajax({
                url: 'checkStrength',
                type: "POST",
                data: ({password : $('#password').val()}),
                success: function(data) {
                    $('#strengthValue').html(data);
                }
            });
        }
        function doAjaxCheckLogin() {
            $.ajax({
                url: 'checkLogin',
                type: "POST",
                data: ({login : $('#login').val()}),
                success: function(data) {
                    $('#checkLogin').html(data);
                }
            });
        }
    </script>
</head>
<body>
<header id="header">
    <h1>Регистрация</h1>
    <p>Шаг 2</p>
</header>
<form:form id="signup-form" modelAttribute="user" method="POST" action="/signup-control/registration">
    <ul>

        <li>
            <div style="margin-top: 1em"><form:input type="text" path="login" placeholder="логин"  onkeyup="doAjaxCheckLogin()"/></div>
            <form:errors cssStyle="color: #ac2925" path="login" cssClass="error"/>
            <span style="float: right" id="checkLogin">
			</span>

        </li>
        <li>
            <div style="margin-top: 1em"><form:input type="password" placeholder="password" path="password" onkeyup="doAjax()"/></div>
            <form:errors cssStyle="color: #ac2925" path="password" cssClass="error"/>
            <span style="float: right" id="strengthValue">
			</span>

        </li>

        <li>
            <div style="margin-top: 2em" style="width: 91px"><input type="submit" value="готово"/>

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
