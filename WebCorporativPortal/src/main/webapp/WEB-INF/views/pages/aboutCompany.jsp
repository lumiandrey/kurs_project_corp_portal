<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="Пол" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Yuliya
  Date: 26.04.2016
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>

<%@include file="../jspf/header.jspf"%>

<%@include file="../jspf/left-navigator.jspf"%>

<%@include file="../jspf/top-navigators.jspf"%>


<div class="container body">
    <div class="main_container">
<!-- page content -->
<div class="right_col" role="main">

    <div class="">
        <div class="page-title">
            <div class="title_left">
                <h3 style="color:#272bbf">О компании</h3>
            </div>

            <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
                              <button class="btn btn-default" type="button">Go!</button>
                          </span>
                    </div>
                </div>
            </div>
        </div>
        <div class="clearfix"></div>

        <div class="row">

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">

                    <div class="x_content">


                        <!-- Smart Wizard -->
                        <p>This is a basic form wizard example that inherits the colors from the selected scheme.</p>
                        <div id="wizard" class="form_wizard wizard_horizontal">
                            <ul class="wizard_steps">
                                <li>
                                    <a href="#step-1">
                                        <span class="step_no">1</span>
                            <span class="step_descr">
                                               1<br />
                                              <small>О нас</small>
                                          </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#step-2">
                                        <span class="step_no">2</span>
                            <span class="step_descr">
                                              2<br />
                                              <small>Контактные данные</small>
                                          </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#step-3">
                                        <span class="step_no">3</span>
                            <span class="step_descr">
                                              3<br />
                                              <small>Вакансии</small>
                                          </span>
                                    </a>
                                </li>

                            </ul>
                            <div id="step-1">
                                <h2 class="StepTitle">О нас</h2>
                                <div> <img src="../../../resources/css/images/4.jpg" alt="image" class="img-circle profile_img"></div>
                                <p>Компания ДВА Ю
                                    Наши услуги:</br>
                                    Аутсорсинг разработки программного обеспечения:</br>
                                    Техническая поддержка IT-проектов и их тестирование;</br>
                                    Разработка программного обеспечения в короткие сроки;</br>
                                    IT-консалтинг и многое другое.</br>
                                    На сегодняшний день компания реализовала более трехсот проектов в различных экономических отраслях! Мы делаем свою работу качественно и тщательно подбираем материал. Проекты компании ISsoft отличаются широким спектром используемых процессов разработки, тестирования, а также высоким технологическим уровнем.</br>
                                    Наши сотрудники со всей ответственностью подходят к решению поставленной задачи. В короткие сроки мы окажем вам услуги по разработке программного обеспечения практически любой сложности.

                                   </p>
                            </div>
                            <div id="step-2">
                                <h2 class="StepTitle">Контактные данные</h2>
                                <div> <img src="../../../resources/css/images/ofic.jpg" alt="image" class="img-circle profile_img"></div>
                                <p>
                                    "ДВА Ю" – офис на ул. Чапаева</br>
                                    220034, Беларусь, Минск   ул. Чапаева, 5, офис 424</br>
                                    Как нас найти</br>
                                    тел. (+375) 17 294 51 61</br>
                                    тел. (+375) 17 294 65 62</br>
                                    тел. (+375) 17 294 65 63</br>
                                    info@dvaj.by
                                 </p>
                            </div>
                            <div id="step-3">
                                <h2 class="StepTitle">Вакансии</h2>
                                <p>
                                    Мы помогаем компаниям по всему миру в разработке программного обеспечения, проектировании баз данных, программировании и IT -консалтинге. Мы гордимся нашей работой, и в настоящее время обновляем список клиентов, для которых мы разрабатываем программное обеспечение и оказываем услуги по тестированию.</br>

                                      </p>
                                <p>
                                    Мы создаем благоприятные условия, нанимая талантливых людей, которые разделяют наше стремление к созданию программного обеспечения и хотят с удовольствием заниматься свои делом.</br>
                                </p>
                                <p>
                                    ISsoft предлагает целый ряд бенефитов, в том числе обеды предоставляемые за счет компании и бесплатные уроки английского языка, медицинская страховка, регулярные корпоративные мероприятия, такие как новогодняя вечеринка, различные спортивные мероприятия,  гибкий график работы, подготовка молодых специалистов с последующим трудоустройством.</p>
                            </div>

                        </div>
                        <!-- End SmartWizard Content -->



                        <!-- End SmartWizard Content -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../jspf/footer.jspf" %>