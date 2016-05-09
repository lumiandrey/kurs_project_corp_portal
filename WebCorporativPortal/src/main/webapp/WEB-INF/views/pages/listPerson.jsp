<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 07.05.2016
  Time: 2:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../jspf/header.jspf"%>

<%@include file="../jspf/left-navigator.jspf"%>

<%@include file="../jspf/top-navigators.jspf"%>

<!-- page content -->
<div class="right_col" role="main">

    <div class="">
        <div class="page-title">
            <div class="title_left">
                <h3>Контакты <small>Сотрудники компании</small></h3>
            </div>
        </div>

        <div class="clearfix"></div>

        <div class="row">
            <div class="col-md-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Контакты</h2>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">

                        <!-- start project list -->
                        <table class="table table-striped projects">
                            <thead>
                            <tr>
                                <th style="width: 20%">Фамилия</th>
                                <th>Имя</th>
                                <th>Отчество</th>
                                <th>Семейной положение</th>
                                <th>Отдел</th>
                                <th>Должность и ранг</th>
                                <th style="width: 20%">Просмотреть</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%--@elvariable id="personList" type="java.util.List"--%>
                                <c:forEach var="cell" items="${personList}">
                                    <tr>
                                        <td>${cell.lastName}</td>
                                        <td>${cell.name}</td>
                                        <td>${cell.patronymic}</td>
                                        <td>${cell.status}</td>
                                        <td>${cell.department.nameDepartment}</td>
                                        <td>${cell.post.namePost} ${cell.post.rang}</td>
                                        <td><a href="showDetails/${cell.idPerson}">Подробнее</a></td>
                                        <td><a href="/messages/go-to-conversation-person/${cell.idPerson}">Написать</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <!-- end project list -->

                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<!-- /page content -->

<%@include file="../jspf/footer.jspf" %>