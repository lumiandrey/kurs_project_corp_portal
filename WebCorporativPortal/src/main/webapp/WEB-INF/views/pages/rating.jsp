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
                <small>Рейтинг </small><h3 style="color:#10a3a3">сотрудников компании</h3><small>по убыванию</small>
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





    <div class="col-md-4 col-sm-4 col-xs-12">
    <div class="x_panel tile fixed_height_320 overflow_hidden">
        <div class="x_title">
            <h2>Круговая диаграмма</h2>
            <div class="clearfix"></div>
        </div>
        <div class="x_content">
            <table class="" style="width:100%">
                <tr>
                    <th style="width:37%;">
                        <p>Топ сотрудников</p>
                    </th>
                    <th>
                        <div class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
                            <p class="">ФИО</p>
                        </div>
                        <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
                            <p class="">Рейтинг</p>
                        </div>
                    </th>
                </tr>
                <tr>
                    <td>
                        <canvas id="canvas1" height="140" width="140" style="margin: 15px 10px 10px 0"></canvas>
                    </td>
                    <td>
                        <table class="tile_info">
                            <c:forEach var="cell" items="${listPersonSort}">
                                <tr>
                                    <td>${cell.lastName}</td>
                                    <td>${cell.rating}</td>

                                </tr>
                            </c:forEach>

                        </table>


                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>



    <!-- Chart.js -->
    <script src="../../../resources/js/chartjs/Chart.min.js"></script>
    <!-- jVectorMap -->
    <script src="../../../resources/js/maps/jquery-jvectormap-2.0.3.min.js"></script>
    <!-- gauge.js -->
    <script src="../../../resources/js/gaudejs/gauge.min.js"></script>
    <!-- Doughnut Chart -->
    <script>
        $(document).ready(function(){
            var options = {
                legend: false,
                responsive: false
            };
            dataSource = [
                    <c:forEach var="cell" items="${listPersonSort}">
                    ${cell.rating},
                </c:forEach>
            ];

            labelData = [<c:forEach var="cell" items="${listPersonSort}">
                "${cell.lastName}",
                </c:forEach>];

            new Chart(document.getElementById("canvas1"), {
                type: 'doughnut',
                tooltipFillColor: "rgba(51, 51, 51, 0.55)",
                data: {
                    labels: labelData,
                    datasets: [{
                        data: dataSource
                    }]
                },
                options: options
            });
        });
    </script>
    <!-- /Doughnut Chart -->

</div>
<!-- /page content -->

<%@include file="../jspf/footer.jspf" %>