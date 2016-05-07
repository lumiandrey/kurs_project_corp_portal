<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="Пол" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%--
  Created by IntelliJ IDEA.
  User: Darya
  Date: 05.05.16
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../jspf/header.jspf"%>

<%@include file="../jspf/left-navigator.jspf"%>

<%@include file="../jspf/top-navigators.jspf"%>

<script type="text/javascript">

    function sendMessage() {

        $.ajax({
            url: "../send",
            type: "POST",
            datatype: 'json',
            data: ({body : $('#message').val()}),
            success: function(data) {
                alert("hello!" + data);
                //addRow("messages",data.login, data.content, data.date);
                var login = data.login;
                var content = data.content;
                var date = data.date;
                $("#messages").append("<tr> <td>"+login+"</td>, <td>"+content+"</td>, <td>"+ date+"</td> </tr>");
                $("#message").html("");
            }
        });
    }

    function addRow(tableID, collumn1, collumn2, collumn3) {

        var table = document.getElementById(tableID);

        var tr = document.createElement('tr');

        table.appendChild(tr);

        var td = document.createElement('td');

        tr.appendChild(td);

        td.appendChild(collumn1);

        var td = document.createElement('td');

        tr.appendChild(td);

        td.appendChild(collumn2);

        var td = document.createElement('td');

        tr.appendChild(td);

        td.appendChild(collumn3);

        /*var rowCount = table.rows.length;
        var row = table.insertRow(rowCount);

        var cell1 = row.insertCell(0);
        cell1.appendChild(collumn1);

        var cell2 = row.insertCell(1);
        cell1.appendChild(collumn2);

        var cell3 = row.insertCell(2);
        cell1.appendChild(collumn3);*/


    }


</script>

<!-- page content -->
<div class="right_col" >

    <!-- begin edit and show detail information from person -->
    <div class="col-md-6 col-sm-12 col-xs-12">

        <div class="x_panel">

            <div class="x_content">

                <form id="messageForm" method="post">

                    <label for="message">Сообщение (не более 350 символов)</label>
                    <textarea name="message" id="message" cols="20" rows="5" maxlength="350"></textarea>
                    <input type="button" id="button" value="Отправить" onclick="sendMessage();" />
                </form>

                <br/>

            </div>

        </div>

    </div>
    <!-- end edit and show detail information from person -->

    <!-- begin form detail department and city -->
    <div class="col-md-6 col-sm-12 col-xs-12">
        <div class="x_panel">
            <table class="table table-striped jambo_table bulk_action" id="messages">
                <thead>
                <tr class="headings">
                    <th>Логин</th>
                    <th>Сообщение</th>
                    <th>Дата отправки</th>
                </tr>
                </thead>
                <tbody>
                <%--@elvariable id="listMessage" type="java.util.List"--%>
                <c:forEach var="cell" items="${listMessage}">

                    <tr class="even pointer">
                        <td>${cell.login}</td>
                        <td>${cell.content}</td>
                        <td>${cell.date}</td>
                    </tr>

                </c:forEach>

                </tbody>
            </table>

        </div>
    </div>
    <!-- end list message -->

</div>
<!-- /page content -->



