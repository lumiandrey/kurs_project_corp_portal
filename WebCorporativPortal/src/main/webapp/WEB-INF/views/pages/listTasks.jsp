<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="Пол" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="by.bsuir.ief.corporativ_portal.model.entity.User" %>
<%--
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

    <!-- begin form detail department and city -->
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_content">

                <table class="table table-striped projects">

                    <thead>
                        <tr class="headings">
                            <th>Название</th>
                            <th>Дата выдачи</th>
                            <th>Дедлайн</th>
                            <th>Текущий</th>
                            <th>Тип задания</th>
                            <th>Коэффициент сложности</th>
                            <th>Процент выполненности</th>
                            <th>Завершен</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%--@elvariable id="listTasks" type="java.util.List"--%>
                        <c:forEach var="cell" items="${listTasks}">

                            <tr>
                                <td>
                                    <a>${cell.name}</a><br />
                                </td>
                                <td>${cell.date_begin}</td>
                                <td>${cell.date_end}</td>
                                <td>${cell.current}</td>
                                <td>${cell.type_pask.nameTypeTask}</td>
                                <td>${cell.type_pask.complication}</td>
                                <td class="project_progress">
                                    <div class="progress progress_sm">
                                        <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="${cell.complited}"></div>
                                    </div>
                                    <small>${cell.complited} Complete</small>
                                </td>
                                <td> <input type="checkbox" value="${cell.done}"/> </td>
                            </tr>

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