<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="Пол" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="by.bsuir.ief.corporativ_portal.model.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Darya
  Date: 05.05.16
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../jspf/header.jspf"%>

<%@include file="../jspf/left-navigator.jspf"%>

<%@include file="../jspf/top-navigators.jspf"%>

<!-- page content -->
<div class="right_col" role="messages">

    <div class="page-title">
        <div class="title_left">
            <h3 style="color:#10a3a3">Соообщения <small>с пользователями</small></h3>
        </div>
    </div>

    <!-- begin form detail department and city -->
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_content">
            <table class="table table-striped jambo_table bulk_action">
                <thead>
                <tr class="headings">
                    <th>Логин</th>
                    <th>Сообщение</th>
                    <th>Дата отправки</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <%--@elvariable id="listMessage" type="java.util.List"--%>
                <c:forEach var="cell" items="${listMessage}">

                        <tr class="even pointer">
                            <td>${cell.login}</td>
                            <td>${cell.content}</td>
                            <td>${cell.date}</td>
                            <td><a href="messagesWithOne/${cell.userSender}">Перейти</a></td>
                        </tr>
                    </a>
                </c:forEach>
                </tbody>
            </table>

        </div>
            </div>
    </div>
    <!-- end form detail department and city -->

</div>
<!-- /page content -->

<%@include file="../jspf/footer.jspf" %>