<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 12.05.2016
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../jspf/header.jspf"%>

<%@include file="../../jspf/left-navigator.jspf"%>

<%@include file="../../jspf/top-navigators.jspf"%>

<!-- page content -->
<div class="right_col" role="main">

    <!-- begin edit and show detail information from person -->
    <div class="col-md-6 col-sm-12 col-xs-12">

       // private Integer idPerson;

       // private String lastName;

      //  private String name;

       // private String patronymic;


      //  private Date dateOfBirth;

       // private String sex;

       // private String status;

        @Email(message = "Пример: vjdso@mail.ru")
      //  private String eMail;

        @URL
      //  private String linkSelfSite;

        @NotNull
      //  private Double rating;

        private City city;
        private Department department;
        private Post post;
        private byte[] photo;


        <div class="x_panel">

            <div class="x_content">
                <h1 style="color:#10a3a3">Мой профиль</h1>
                <form:form method="POST" modelAttribute="createperson" action="/person-control/add-person"
                           class="form-horizontal form-label-left" enctype="multipart/form-data">

                    <div class="item form-group">
                        <form:label path="lastName">Фамилия <span class="required">*</span></form:label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <form:input path="lastName" cssClass="form-control col-md-7 col-xs-12" type="text"/>
                            <form:errors path="lastName" cssClass="error"/>
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
                        <form:label path="patronymic">Отчество <span class="required">*</span></form:label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <form:input path="patronymic" cssClass="form-control col-md-7 col-xs-12" type="text"/>
                            <form:errors path="patronymic" cssClass="error"/>
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
                                <form:option value="Нет отношений">Нет отношений</form:option>
                                <form:option value="Женат">Женат</form:option>
                                <form:option value="Замужем">Замужем</form:option>
                                <form:option value="Холост">Холост</form:option>
                                <form:option value="В поиске">В поиске</form:option>
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
                            <label>Страна проживания <span class="required">*</span>
                                <select id="countrylist" name="country">
                                </select>
                            </label>
                        </div>
                    </div>

                    <div class="item form-group">
                        <form:label path="linkSelfSite">Ссылка на внешний сайт<span class="required">*</span></form:label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <form:input path="linkSelfSite" type="text"/>
                            <form:errors path="linkSelfSite" cssClass="error"/>
                        </div>
                    </div>

                    <div class="item form-group">
                        <label>Загрузить фото на профиль <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input name="file" type="file"/>
                        </div>
                    </div>

                    <input type="submit" value="Добавить"/>
                </form:form>

            </div>

        </div>

    </div>
    <!-- end edit and show detail information from person -->

    <!-- begin form detail department and city -->
    <div class="col-md-6 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_content">
                <br />

                <div class="form-group">

                    <div class="x_title">
                        <h2 style="color:#1d71a3">Информация об отделе</h2>
                        <div class="clearfix"></div>
                    </div>
                    <br/>
                    <h4>Название отдела: ${user.person.department.nameDepartment}</h4><br/>
                    <h4>Направление работы: ${user.person.department.wayWork}</h4><br/>
                </div>
                <div class="form-group">

                    <div class="x_title">
                        <h2 style="color:#1d71a3">Информация о должности</h2>
                        <div class="clearfix"></div>
                    </div>
                    <br/>
                    <h4 >Название должности: ${user.person.post.namePost}</h4><br/>
                    <h4>Ранг должности: ${user.person.post.rang}</h4><br/>
                    <h4>Зарплата: ${user.person.post.income} у.е</h4><br/>
                    <h4>График работы: ${user.person.post.workingSchedule}</h4><br/>
                </div>
                <div class="form-group">
                    <div class="x_title">
                        <h2 style="color:#1d71a3">Информация о месте проживания</h2>
                        <div class="clearfix"></div>
                    </div><br/>
                    <h4>Город: ${user.person.city.cityName}</h4><br/>
                    <h4>Страна: ${user.person.city.country.countryName}</h4><br/>
                </div>
                <div class="form-group">
                    <br/><h1>Ваш рейтинг: ${user.person.rating}</h1><br/>
                </div>


            </div>
        </div>
    </div>
    <!-- end form detail department and city -->

</div>
<!-- /page content -->

<script>
    $(document).ready(function() {

        $.ajax({
            url: "/person-control/country",
            type: "GET",
            cache: false,
            success: function(response){
                $("select[name='country']").empty();
                for (var id in response)
                    $("select[name='country']").append($("<option value='" + id.idCountryt + "'>" + id.countryName + "</option>"));
            },
            error: function() {alert("error!");}
        });

        $.ajax({
            url: "/person-control/country",
            type: "GET",
            cache: false,
            success: function(response){
                $("select[name='country']").empty();
                for (var id in response)
                    $("select[name='country']").append($("<option value='" + id.idCountryt + "'>" + id.countryName + "</option>"));
            },
            error: function() {alert("error!");}
        });

    });
    function selectCountry()
    {
        $.ajax({
            url: "/person-control/country",
            type: "GET",
            cache: false,
            success: function(response){
                $("select[name='country']").empty();
                for (var id in response)
                    $("select[name='country']").append($("<option value='" + id.idCountryt + "'>" + id.countryName + "</option>"));
            },
            error: function() {alert("error!");}
        });
    }
</script>

<%@include file="../../jspf/footer.jspf" %>