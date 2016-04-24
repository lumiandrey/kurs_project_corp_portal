<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SingUp</title>
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <script src="../../resources/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../../resources/css/style.css">
</head>
<body>
<!--header-->
<header class = "upper">
</header>
<div class="container">
    <!--context-->
    <div class="row">
        <div class="col-md-3">
        </div>
        <div class="col-md-6 form-group">
            <h2>Шаг 2 </h2><br>
            <form:form class="center" method="POST" commandName="person" action="sing-up-2" role="form">
                <%--<fieldset>
                    <form:label style="font-size: 14pt" path="login">Логин:</form:label><br>
                    <form:input class="col-md-6 input-lg" path="login" onkeyup="findEqualsLogin()"/>
                    <span style="float: right" id="isBeing"></span><br><br><br>

                    <form:label style="font-size: 14pt" path="password">Пароль:</form:label><br>
                    <form:password class="col-md-6 input-lg" path="password" onkeyup="checkStrength()"/>
                    <span style="float: right" id="strengthValue"></span><br><br>

                </fieldset><br><br>--%>

                 <fieldset>
                     <form:label path="lastName">Фамилия:</form:label><br>
                     <form:input class="form-control" path="lastName"/><br>
                     <form:errors path="lastName" cssClass="error"/><br>

                     <form:label path="firtsName">Имя:</form:label><br>
                     <form:input class="form-control" path="firtsName"/><br>
                     <form:errors path="firtsName" cssClass="error"/><br>

                     <form:label path="name">Отчество:</form:label><br>
                     <form:input class="form-control" path="name"/><br>
                     <form:errors path="name" cssClass="error"/><br>

                     <form:label path="dateOfBirth">Дата рождения:</form:label>
                     <div class="container">
                         <div class="col-sm-6" style="height:130px;">
                             <div class="form-group">
                                 <div class='input-group date' id='datetimepicker9'>
                                     <form:input type='text' class="form-control" path="dateOfBirth"/>
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar">
                    </span>
                </span>
                                 </div>
                             </div>
                         </div>
                         <script type="text/javascript">
                             $(function () {
                                 $('#datetimepicker9').datetimepicker({
                                     viewMode: 'years'
                                 });
                             });
                         </script>
                     </div>

                 </fieldset>
                <!--Submits-->
                <input style="float: right" class="btn btn-primary col-md-3" type="submit" value="Шаг 2">
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
