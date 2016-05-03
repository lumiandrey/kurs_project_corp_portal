<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Yuliya
  Date: 27.04.2016
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>
<body>
<div class="container">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <form:form method="POST" commandName="editPerson" action="check-edit">
            <form:hidden path="idpersonPisl" />
            <form:label path="lastName">Фамилия:</form:label>
            <form:input path="lastName"/>
            <form:errors path="lastName" cssClass="error"/>
            <form:label path="name">Имя:</form:label>
            <form:input path="name"/>
            <form:errors path="name" cssClass="error"/>
            <form:label path="firstName">Отчество:</form:label>
            <form:input path="firstName"/>
            <form:errors path="firstName" cssClass="error"/>
            <form:label path="sex">Пол:</form:label>
            <form:select path="sex">
                <form:option value="Мужской">Мужской</form:option>
                <form:option value="Женский">Женский</form:option>
            </form:select>
            <form:label path="pasportNumber">Паспортный номер:</form:label>
            <form:input path="pasportNumber"/>
            <form:errors path="pasportNumber" cssClass="error"/>
            <form:label path="hphone">Домашний телефон:</form:label>
            <form:input path="hphone"/>
            <form:errors path="hphone" cssClass="error"/>
            <form:label path="birthday">Дата рождения:</form:label>
            <form:input path="birthday"/>
            <form:errors path="birthday" cssClass="error"/>
            <form:label path="serialPasport">Серия паспорта:</form:label>
            <form:input path="serialPasport"/>
            <form:errors path="serialPasport" cssClass="error"/>
            <form:label path="organizationGivePassport">Орган выдачи:</form:label>
            <form:input path="organizationGivePassport"/>
            <form:errors path="organizationGivePassport" cssClass="error"/>
            <form:label path="dateGivePasport">Дата выдачи:</form:label>
            <form:input path="dateGivePasport"/>
            <form:errors path="dateGivePasport" cssClass="error"/>
            <form:label path="identifyNumber">Иденцификационный номер:</form:label>
            <form:input path="identifyNumber"/>
            <form:errors path="identifyNumber" cssClass="error"/>
            <form:label path="placeOfBirth">Место рождения:</form:label>
            <form:input path="placeOfBirth"/>
            <form:errors path="placeOfBirth" cssClass="error"/>
            <form:label path="adressLiving">Город рождения:</form:label>
            <form:select path="adressLiving">
                <form:option value="Minsk">Минск</form:option>
                <form:option value="Budapest">Будапешт</form:option>
                <form:option value="Oslo">Осло</form:option>
                <form:option value="Amsterdam">Амстердам</form:option>
                <form:option value="Brest">Брест</form:option>
                <form:option value="Grodno">Гродно</form:option>
                <form:option value="Madrid">Мадрид</form:option>
                <form:option value="Kiev">Киев</form:option>
                <form:option value="Moscow">Москва</form:option>
                <form:option value="Bitebsk">Витебск</form:option>
                <form:option value="Warsawa">Варшава</form:option>
                <form:option value="Mogilev">Могилёв</form:option>
                <form:option value="Orsha">Орша</form:option>
                <form:option value="Gomel">Гомель</form:option>
            </form:select>
            <form:label path="mphone">Мобильный телефон:</form:label>
            <form:input path="mphone"/>
            <form:errors path="mphone" cssClass="error"/>
            <form:label path="eMail">Почта:</form:label>
            <form:input path="eMail"/>
            <form:errors path="eMail" cssClass="error"/>
            <form:label path="workingPlace">Место работы:</form:label>
            <form:input path="workingPlace"/>
            <form:errors path="workingPlace" cssClass="error"/>
            <form:label path="post">Должность:</form:label>
            <form:input path="post"/>
            <form:errors path="post" cssClass="error"/>
            <form:label path="cityResidence">Город проживания:</form:label>
            <form:select path="cityResidence">
                <form:option value="Minsk">Минск</form:option>
                <form:option value="Budapest">Будапешт</form:option>
                <form:option value="Oslo">Осло</form:option>
                <form:option value="Amsterdam">Амстердам</form:option>
                <form:option value="Brest">Брест</form:option>
                <form:option value="Grodno">Гродно</form:option>
                <form:option value="Madrid">Мадрид</form:option>
                <form:option value="Kiev">Киев</form:option>
                <form:option value="Moscow">Москва</form:option>
                <form:option value="Bitebsk">Витебск</form:option>
                <form:option value="Warsawa">Варшава</form:option>
                <form:option value="Mogilev">Могилёв</form:option>
                <form:option value="Orsha">Орша</form:option>
                <form:option value="Gomel">Гомель</form:option>
            </form:select>
            <form:label path="addressResidence">Адрес проживания:</form:label>
            <form:input path="addressResidence"/>
            <form:errors path="addressResidence" cssClass="error"/>
            <form:label path="maritalStatus">Семейное положение:</form:label>
            <form:select path="maritalStatus">
                <form:option value="Not">Нет отношений</form:option>
                <form:option value="Merried">Merried</form:option>
                <form:option value="Женат">Женат</form:option>
                <form:option value="Замужем">Замужем</form:option>
                <form:option value="Холостой">Холостой</form:option>
                <form:option value="не_в_отношениях">В поиске</form:option>
            </form:select>
            <form:label path="nationality">Национальность:</form:label>
            <form:select path="nationality">
                <form:option value="Belarus">Беларусь</form:option>
                <form:option value="Russia">Россия</form:option>
                <form:option value="Norway">Норвегия</form:option>
                <form:option value="Niderlands">Нидерланды</form:option>
                <form:option value="Ukrain">Украина</form:option>
                <form:option value="Spain">Испания</form:option>
                <form:option value="Vengria">Венгрия</form:option>
            </form:select>
            <form:label path="disability">Инвалидность:</form:label>
            <form:select path="disability">
                <form:option value="Not">Нет</form:option>
                <form:option value="FirstGroup">1я</form:option>
                <form:option value="SecondGroup">2я</form:option>
                <form:option value="ThirdGroup">3я</form:option>
            </form:select>
            <form:label path="pensioner">Пенсионер:</form:label>
            <form:checkbox path="pensioner"  value="true"/>
            <form:label path="monthlyIncome">Месячный доход:</form:label>
            <form:input path="monthlyIncome"/>
            <form:errors path="monthlyIncome" cssClass="error"/>
            <form:label path="reservist">Годен к призыву:</form:label>
            <form:checkbox path="reservist"  value="true"/>

            <input type="submit" value="Сохранить изменения"/>
        </form:form>

    </div>
    <div class="col-md-2"></div>
</div>

</body>
</html>
