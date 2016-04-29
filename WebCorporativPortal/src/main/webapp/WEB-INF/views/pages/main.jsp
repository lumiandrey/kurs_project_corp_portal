<%@ page import="by.bsuir.ief.corporativ_portal.model.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Yuliya
  Date: 26.04.2016
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../jspf/header.jspf"%>

<%@include file="../jspf/left-navigator.jspf"%>


<div style="float:left; margin-top: 20px; "style="margin-top: 1em">
    <h3>
        <% User user = (User) session.getAttribute("user");
        out.print(user.getPerson().toString());
    %>
    </h3>
</div>

<%@include file="../jspf/footer.jspf" %>