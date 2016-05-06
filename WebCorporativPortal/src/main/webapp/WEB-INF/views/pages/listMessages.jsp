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

    <!-- begin edit and show detail information from person -->
    <div class="col-md-6 col-sm-12 col-xs-12">

        <div class="x_panel">

            <div class="x_content">
                Hello!
            </div>

        </div>

    </div>
    <!-- end edit and show detail information from person -->

    <!-- begin form detail department and city -->
    <div class="col-md-6 col-sm-12 col-xs-12">
        <div class="x_panel">
            <!--<jsp:useBean id="listMessage" class="java.util.ArrayList" scope="request"/>-->
            <table class="table table-striped jambo_table bulk_action">
                <thead>
                <tr class="headings">
                    <th>Логин</th>
                    <th>Сообщение</th>
                    <th>Дата отправки</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="cell" items="${listMessage}">
                    <a href="/messagesWithOne/${cell.userSender}">
                        <tr class="even pointer">
                            <td>${cell.login}</td>
                            <td>${cell.content}</td>
                            <td>${cell.date}</td>
                        </tr>
                    </a>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <!-- end form detail department and city -->

</div>
<!-- /page content -->



