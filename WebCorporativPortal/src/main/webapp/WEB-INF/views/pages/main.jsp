<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="Пол" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="by.bsuir.ief.corporativ_portal.model.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Yuliya
  Date: 26.04.2016
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>



<%@include file="../jspf/header.jspf"%>

<%@include file="../jspf/left-navigator.jspf"%>

<%@include file="../jspf/top-navigators.jspf"%>

<!-- page content -->
<div class="right_col" role="main">

    <div class="col-md-12 col-sm-12 col-xs-12">

        <div class="x_panel">

            <div class="x_content">

                <form:form method="POST" commandName="person" action="#" class="form-horizontal form-label-left">

                    <div class="item form-group">
                        <form:label path="firstName">Фамилия <span class="required">*</span></form:label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <form:input path="firstName" cssClass="form-control col-md-7 col-xs-12" type="text"/>
                            <form:errors path="firstName" cssClass="error"/>
                        </div>
                    </div>

                    <div class="item form-group">
                        <form:label path="name">Имя <span class="required">*</span></form:label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <form:input path="name" cssClass="form-control col-md-7 col-xs-12" type="text"/>
                            <form:errors path="name" cssClass="error"/>
                        </div>
                    </div>


                    <div class="item form-group">
                        <form:label path="lastName">Отчество <span class="required">*</span></form:label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <form:input path="lastName" cssClass="form-control col-md-7 col-xs-12" type="text"/>
                            <form:errors path="lastName" cssClass="error"/>
                        </div>
                    </div>

                    <div class="item form-group">
                        <form:label path="dateOfBirth">Дата рождения: <span class="required">*</span></form:label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <form:input path="dateOfBirth" cssClass="form-control col-md-7 col-xs-12" type="date"/>
                            <form:errors path="dateOfBirth" cssClass="error"/>
                        </div>
                    </div>

                    <div class="item form-group">
                        <form:label path="sex">Пол:<span class="required">*</span></form:label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <form:select path="sex" cssClass="select2_single form-control" tabindex="0">
                                <form:option value="Мужской">Мужской</form:option>
                                <form:option value="Женский">Женский</form:option>
                            </form:select>
                        </div>
                    </div>

                    <div class="item form-group">
                        <form:label path="status">Семейное положение: <span class="required">*</span></form:label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <form:select path="status" cssClass="select2_single form-control" tabindex="0">
                                <form:option value="status">Нет отношений</form:option>
                                <form:option value="status">Женат</form:option>
                                <form:option value="status">Замужем</form:option>
                                <form:option value="status">Холост</form:option>
                                <form:option value="status">В поиске</form:option>
                            </form:select>
                        </div>
                    </div>

                    <div class="item form-group">
                        <form:label path="eMail">Почтовый ящик <span class="required">*</span></form:label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <form:input path="eMail" cssClass="form-control col-md-7 col-xs-12" type="email"/>
                            <form:errors path="eMail" cssClass="error"/>
                        </div>
                    </div>

                    <div class="item form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <a href="${user.person.linkSelfSite}">Ссылка на внешний сайт</a>
                            <form:errors path="linkSelfSite" cssClass="error"/>
                        </div>
                    </div>


                    <input type="submit" value="Редактировать"/>
                </form:form>

                    <h1>${rating}</h1>
                </div>

            </div>

        </div>

</div>
<!-- /page content -->



<%@include file="../jspf/footer.jspf" %>