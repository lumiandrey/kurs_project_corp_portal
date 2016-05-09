<%--suppress ALL --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<div class="right_col" role="tasks">


    <div class="page-title">
        <div class="title_left">
            <h3 style="color:#10a3a3">Мои задачи</h3>
        </div>
    </div>
    <!-- begin form add Task-->

    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_content">
                <%--@elvariable id="idCreated" type="java.lang.Integer"--%>
                <jsp:useBean id="idCreated" scope="request" type="java.lang.Integer"/>
                <form:form method="POST" modelAttribute="newTask" action="/tasks/createTask/${idCreated}">

                    <div class="item form-group">
                        <form:label path="name">Наименование: <span class="required">*</span></form:label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <form:input path="name" cssClass="form-control col-md-7 col-xs-12" type="text"/>
                            <form:errors path="name" cssClass="error"/>
                        </div>
                    </div>

                    <div class="item form-group">
                        <form:label path="date_begin">Дата начала: <span class="required">*</span></form:label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <form:input path="date_begin" cssClass="form-control col-md-7 col-xs-12" id="date_time_begin" />
                            <form:errors path="date_begin" cssClass="error"/>
                        </div>
                    </div>

                    <div class="item form-group">
                        <form:label path="date_end">Дата окончания: <span class="required">*</span></form:label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <form:input path="date_end" cssClass="form-control col-md-7 col-xs-12"  id="date_time_end"/>
                            <form:errors path="date_end" cssClass="error"/>
                        </div>
                    </div>

                    <div class="item form-group">
                        <form:label path="type_pask">Тип: <span class="required">*</span></form:label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <select name="typeTasks" class="form-control col-md-7 col-xs-12">
                                <%--@elvariable id="typeTaskList" type="java.util.List"--%>
                                <c:forEach var="typeTask" items="${typeTaskList}">
                                    <option value="${typeTask.idTypeTask}" > ${typeTask.nameTypeTask} </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>


                    <input type="submit" value="Добавить"/>

                </form:form>
            </div>
        </div>
    </div>

    <!-- end form add Task-->

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
                                <td><input type="checkbox" <c:if test="${cell.current}">checked</c:if>/></td>
                                <td>${cell.type_pask.nameTypeTask}</td>
                                <td>${cell.type_pask.complication}</td>
                                <td class="project_progress">
                                    <div class="progress progress_sm">
                                        <div class="progress-bar bg-green" role="progressbar" data-transitiongoal="${cell.complited}"></div>
                                    </div>
                                    <small>${cell.complited} Complete</small>
                                </td>
                                <td>  <input type="checkbox" <c:if test="${cell.done}">checked</c:if>/>  </td>
                            </tr>

                        </c:forEach>
                    </tbody>

                </table>

            </div>
        </div>
    </div>
    <!-- end form detail department and city -->

</div>

<!-- bootstrap-daterangepicker -->
<script src="../../../resources/js/moment/moment.min.js"></script>
<script src="../../../resources/js/datepicker/daterangepicker.js"></script>


<script>
    $(document).ready(function() {
        $('#date_time_end').daterangepicker({
            singleDatePicker: true,
            calender_style: "picker_2",
            format: 'YYYY-MM-DD'
        });
        $('#date_time_begin').daterangepicker({
            singleDatePicker: true,
            calender_style: "picker_2",
            format: 'YYYY-MM-DD'
        },function(start, end, label){

        });
        //При изменении даты в 8 datetimepicker, она устанавливается как минимальная для 9 datetimepicker
        $("#date_time_begin").on("dp.change",function (e) {
            $("#date_time_end").data("DateTimePicker").setMinDate(e.date);
        });
        //При изменении даты в 9 datetimepicker, она устанавливается как максимальная для 8 datetimepicker
        $("#date_time_end").on("dp.change",function (e) {
            $("#date_time_begin").data("DateTimePicker").setMaxDate(e.date);
        });
    });
</script>

<script>
    $(document).ready(function() {
        $('#reservation').daterangepicker(null, function(start, end, label) {
            console.log(start.toISOString(), end.toISOString(), label);
        });
    });
</script>
<!-- /bootstrap-daterangepicker -->

<!-- /page content -->

<%@include file="../jspf/footer.jspf" %>