<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../jspf/header.jspf"%>

<%@include file="../jspf/left-navigator.jspf"%>

<%@include file="../jspf/top-navigators.jspf"%>
<%--
  Created by IntelliJ IDEA.
  User: Darya
  Date: 08.05.16
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>

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
                        <h2>Топ-рейтинговых сотрудников</h2>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">

                        <!-- start project list -->
                        <table class="table table-striped projects">
                            <thead>
                            <tr>
                                <th style="width: 1%">#</th>
                                <th>ФИО</th>
                                <th>Отдел</th>
                                <th>Рейтинг</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%--@elvariable id="listPersonSort" type="java.util.List"--%>
                            <c:forEach var="cell" items="${listPersonSort}">
                                <tr>
                                    <td>#</td>
                                    <td>${cell.lastName} ${cell.name} ${cell.patronymic}</td>
                                    <td>${cell.department.nameDepartment}</td>
                                    <td>${cell.rating}</td>
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