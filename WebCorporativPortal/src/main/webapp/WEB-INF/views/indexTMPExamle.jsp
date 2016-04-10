<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 20.03.2016
  Time: 1:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Сообщение</title>
</head>

<body>

<form:form method="POST" commandName="employee" action="send-message-employee">

  <fieldset>

    <form:label path="name">Ваше имя:</form:label>
    <form:input path="name" />

    <form:label path="id">ваш id:</form:label>
    <form:textarea path="id"/>

    <form:label path="createdDate">Дата поступления на работу</form:label>
    <form:input path="createdDate"/>

  </fieldset>

  <footer>
    <input type="submit"value="отправить" tabindex="4">
  </footer>

</form:form>


</body>
</html>