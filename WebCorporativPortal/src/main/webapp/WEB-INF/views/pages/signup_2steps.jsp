<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sing up</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Custom Theme Style -->
    <link href="../../../resources/css/custom.css" rel="stylesheet">
</head>
<body class="nav-md">


<!-- page content -->
<div class="right_col" role="main">

    <div class="">


        <div class="row">

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">


                    <h2>Example: Vertical Style</h2>
                    <!-- Tabs -->
                    <div id="wizard_verticle" class="form_wizard wizard_verticle">
                        <ul class="list-unstyled wizard_steps">
                            <li>
                                <a href="#step-11">
                                    <span class="step_no">1</span>
                                </a>
                            </li>
                            <li>
                                <a href="#step-22">
                                    <span class="step_no">2</span>
                                </a>
                            </li>

                        </ul>

                        <div id="step-11">
                            <h2 class="StepTitle">Step 1 Content</h2>
                            <form class="form-horizontal form-label-left">

                                <span class="section">Personal Info</span>

                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3" for="first-name">First Name <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6">
                                        <input type="text" id="first-name2" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3" for="last-name">Last Name <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6">
                                        <input type="text" id="last-name2" name="last-name" required="required" class="form-control col-md-7 col-xs-12">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="middle-name" class="control-label col-md-3 col-sm-3">Middle Name / Initial</label>
                                    <div class="col-md-6 col-sm-6">
                                        <input id="middle-name2" class="form-control col-md-7 col-xs-12" type="text" name="middle-name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3">Gender</label>
                                    <div class="col-md-6 col-sm-6">
                                        <div id="gender2" class="btn-group" data-toggle="buttons">
                                            <label class="btn btn-default" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                                <input type="radio" name="gender" value="male"> &nbsp; Male &nbsp;
                                            </label>
                                            <label class="btn btn-primary" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                                <input type="radio" name="gender" value="female" checked=""> Female
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3">Date Of Birth <span class="required">*</span>
                                    </label>
                                    <div class="col-md-6 col-sm-6">
                                        <input id="birthday2" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text">
                                    </div>
                                </div>

                            </form>
                        </div>
                        <div id="step-22">
                            <h2 class="StepTitle">Step 2 Content</h2>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </p>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor
                                in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </p>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor
                                in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </p>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor
                                in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </p>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor
                                in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </p>
                        </div>

                    </div>
                    <!-- End SmartWizard Content -->
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<!-- /page content -->

<!-- footer content -->

<!-- /footer content -->
</div>
</div>


<!-- jQuery -->
<script src="../../../resources/js/jquery/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../../../resources/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="../../../resources/js/fastclick.js"></script>
<!-- NProgress -->
<script src="../../../resources/js/nprogress.js"></script>
<!-- jQuery Smart Wizard -->
<script src="../../../resources/js/jquery/jquery.smartWizard.js"></script>
<!-- Custom Theme Scripts -->
<script src="../../../resources/js/custom.js"></script>

<!-- jQuery Smart Wizard -->
<script>
    $(document).ready(function() {
        $('#wizard').smartWizard();

        $('#wizard_verticle').smartWizard({
            transitionEffect: 'slide'
        });

        $('.buttonNext').addClass('btn btn-success');
        $('.buttonPrevious').addClass('btn btn-primary');
        $('.buttonFinish').addClass('btn btn-default');
    });
</script>
<!-- /jQuery Smart Wizard -->
</body>
</html>








