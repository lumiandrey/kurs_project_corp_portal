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

<%@include file="../jspf/top-navigators.jspf"%>

<!-- page content -->
<div class="right_col" role="main">

    ${user.person.toString()}

</div>
<!-- /page content -->



<%@include file="../jspf/footer.jspf" %>