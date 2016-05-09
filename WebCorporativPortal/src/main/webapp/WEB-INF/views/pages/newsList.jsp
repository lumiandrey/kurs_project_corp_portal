<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Darya
  Date: 08.05.16
  Time: 13:59
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
                <h3>Новости <small>Новостная лента</small></h3>
            </div>
        </div>

        <div class="clearfix"></div>

        <div class="row">
            <div class="col-md-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Новости</h2>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">


                        <%--@elvariable id="newsList" type="java.util.List"--%>
                        <c:forEach var="cell" items="${newsList}">
                        <div class="item form-group">
                            <div class="x_title">
                                <h2>${cell.date} ${cell.content}</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                    <c:if test="${cell.comments.size() > 0}">
                                        <table class="table table-striped projects">
                                            <c:forEach var = "rowComent" items="${cell.comments}">
                                                <tr>
                                                    <td>>>></td>
                                                    <td style="color: brown;">
                                                            ${rowComent.content}
                                                    </td>
                                                    <td>${rowComent.date}</td>
                                                </tr>
                                            </c:forEach>

                                        </table>

                                    </c:if>
                                <form id="comment" method="post" action="/records/sendComment/${cell.idRecord}">
                                    <label>
                                        Оставить комментарий:
                                        <input name="content" type="text" />
                                    </label>
                                    <input type="submit" value="Оставить"/>
                                </form>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<!-- /page content -->

<%@include file="../jspf/footer.jspf" %>