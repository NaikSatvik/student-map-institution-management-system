<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Faculty | Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="Premium Multipurpose Admin & Dashboard Template" name="description" />
    <meta content="Themesdesign" name="author" />
    <!-- App favicon -->
    <link rel="shortcut icon" href="assets/images/graduateicon.ico">
    <!-- slick css -->
    <link href="assets/libs/slick-slider/slick/slick.css" rel="stylesheet" type="text/css" />
    <link href="assets/libs/slick-slider/slick/slick-theme.css" rel="stylesheet" type="text/css" />
    <!-- jvectormap -->
    <link href="assets/libs/jqvmap/jqvmap.min.css" rel="stylesheet" />
    <!-- Bootstrap Css -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Icons Css -->
    <link href="assets/css/icons.min.css" rel="stylesheet" type="text/css" />
    <!-- App Css-->
    <link href="assets/css/app.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/libs/bootstrap-datepicker/css/bootstrap-datepicker.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</head>
<body data-sidebar="dark">
    <!-- Begin page -->
    <div id="layout-wrapper">
        <header id="page-topbar">
            <div class="navbar-header">
                <div class="d-flex">
                    <!-- LOGO -->
                    <div class="navbar-brand-box">
                        <a href="index.html" class="logo logo-dark">
                            <span class="logo-sm">
                                <img src="assets/images/logo-sm-dark.png" alt="" height="22">
                            </span>
                            <span class="logo-lg">
                                <img src="assets/images/logo-dark.png" alt="" height="20">
                            </span>
                        </a>
                        <a href="index.html" class="logo logo-light">
                            <span class="logo-sm">
                                <img src="assets/images/logo-sm-light.png" alt="" height="22">
                            </span>
                            <span class="logo-lg">
                                <img src="assets/images/studentMap.png" alt="" height="33">
                            </span>
                        </a>
                    </div>

                    <button type="button" class="btn btn-sm px-3 font-size-24 header-item waves-effect" id="vertical-menu-btn">
                        <i class="mdi mdi-backburger"></i>
                    </button>

                    <!-- App Search-->
                    <form class="app-search d-none d-lg-block">
                        <div class="position-relative">
                            <input type="text" class="form-control" placeholder="Search...">
                            <span class="mdi mdi-magnify"></span>
                        </div>
                    </form>
                </div>

                <div class="d-flex">

                    <div class="dropdown d-inline-block d-lg-none ml-2">
                        <button type="button" class="btn header-item noti-icon waves-effect" id="page-header-search-dropdown"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="mdi mdi-magnify"></i>
                        </button>
                        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right p-0"
                            aria-labelledby="page-header-search-dropdown">
                
                            <form class="p-3">
                                <div class="form-group m-0">
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="Search ..." aria-label="Recipient's username">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="submit"><i class="mdi mdi-magnify"></i></button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>

                    <div class="dropdown d-none d-lg-inline-block ml-1">
                        <button type="button" class="btn header-item noti-icon waves-effect" data-toggle="fullscreen">
                            <i class="mdi mdi-fullscreen"></i>
                        </button>
                    </div>

                    <div class="dropdown d-inline-block">
                        <button type="button" class="btn header-item waves-effect" id="page-header-user-dropdown"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <img class="rounded-circle header-profile-user" src="assets/images/online.png" alt="Header Avatar" sizes="20">
                            <span class="d-none d-sm-inline-block ml-1">${sessionScope.mail}</span>
                            <i class="mdi mdi-chevron-down d-none d-sm-inline-block"></i>
                        </button>
                        <div class="dropdown-menu dropdown-menu-right">
                            <!-- item-->
                            <a class="dropdown-item" href="/profile"><i class="mdi mdi-face-profile font-size-16 align-middle mr-1"></i> Profile</a>
                            <!-- <a class="dropdown-item" href="#"><i class="mdi mdi-credit-card-outline font-size-16 align-middle mr-1"></i> Billing</a> -->
                            <!-- <a class="dropdown-item" href="#"><i class="mdi mdi-account-settings font-size-16 align-middle mr-1"></i> Settings</a> -->
                            <!-- <a class="dropdown-item" href="#"><i class="mdi mdi-lock font-size-16 align-middle mr-1"></i> Lock screen</a> -->
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/logout"><i class="mdi mdi-logout font-size-16 align-middle mr-1"></i> Logout</a>
                        </div>
                    </div>
        
                </div>
            </div>
        </header>
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">  
            <div class="modal-dialog modal-lg">  
                <div class="modal-content">   
                <div class="modal-header">
                    <!-- <button type="button" class="close" data-dismiss="modal">??</button>   -->
                    <h4 class="modal-title">Revert Back to this Query</h4>
                </div>  
                <div class="modal-body">  
                    <!-- <p>This is a large modal.</p>   -->
                    <form class="custom-validation" action="/saveReply" method="POST">
                        <div class="form-group">
                            <label>Query</label>
                            <input name="stuQuery" type="text" class="form-control" id="query" readonly/>
                        </div>
                        <div class="form-group">
                            <textarea name="reply" required class="form-control" rows="5" cols="5"></textarea>
                        </div>

                        <div class="form-group mb-0">
                            <div>
                                <button type="submit" class="btn btn-primary waves-effect waves-light mr-1">Reply</button>
                            </div>
                        </div>
                    </form>
                </div>  
                <div class="modal-footer">  
                    <button type="submit" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>  
                </div>  
            </div>  
        </div>

        <!-- ========== Left Sidebar Start ========== -->
        <div class="vertical-menu">

            <div data-simplebar class="h-100">

                <!--- Sidemenu -->
                <div id="sidebar-menu">
                    <!-- Left Menu Start -->
                    <ul class="metismenu list-unstyled" id="side-menu">
                        <!-- <li class="menu-title">Menu</li> -->

                        <li>
                            <a href="/indexFac" class="waves-effect">
                                <i class="mdi mdi-view-dashboard"></i><span class="badge badge-pill badge-success float-right"></span>
                                <span>Faculty Dashboard</span>
                            </a>
                        </li>

                        <li>
                            <a href="/goto-yourstudents" class=" waves-effect">
                                <i class="mdi mdi-calendar-month"></i>
                                <span>Student Details</span>
                            </a>
                        </li>

                        <li>
                            <a href="javascript: void(0);" class="has-arrow waves-effect">
                                <i class="mdi mdi-email-multiple-outline"></i>
                                <span>Create & Upload</span>
                            </a>
                            <ul class="sub-menu" aria-expanded="false">
                                <li><a href="UploadGrades">Upload Grades</a></li>
                                <li><a href="UploadNotice">Upload Notice</a></li>
                                <!-- <li><a href="#">Email Compose</a></li> -->
                            </ul>
                        </li>

                        <li>
                            <a style="color: #FCFBFC;" href="javascript: void(0);" class="has-arrow waves-effect">
                                <i class="mdi mdi-account-group"></i>
                                <span>Queries</span>
                            </a>
                            <ul class="sub-menu" aria-expanded="false">
                                <li><a style="color: #FCFBFC;" href="/revertStuQueries">Student Queries</a></li>
                                <li><a href="/revertGurQueries">Guardian Queries</a></li>
                                <!-- <li><a href="auth-recoverpw.html">Recover Password</a></li> -->
                                <!-- <li><a href="auth-lock-screen.html">Lock Screen</a></li> -->
                            </ul>
                        </li>
                    </ul>
                    <div class="sidebar-section mt-5 mb-3">
                        
                    </div>
                </div>
                <!-- Sidebar -->
            </div>
        </div>
        <!-- Left Sidebar End -->

        <!-- ============================================================== -->
        <!-- Start right Content here -->
        <!-- ============================================================== -->
        <div class="main-content">

            <div class="page-content">
                <div class="container-fluid">

                    <!-- start page title -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h2>Student Queries</h2>
                        </div>
                    </div>     
                    <br>
                    <!-- end page title -->

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table style="overflow: hidden;" class="table table-centered table-nowrap mb-0" id="example" class="display">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Query</th>
                                                    <th scope="col">Reply</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="s" items="${getStuQ}">
                                                    <tr>
                                                        <td class="nr1">${s.stuQuery}</td>
                                                        <td><span class="use-address"><button class="btn btn-outline-success btn-sm" data-toggle="modal" data-target="#exampleModal">Reply</button></span></td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                        <script>
                                            $(".use-address").click(function() {
                                                var $row = $(this).closest("tr"); // Find the row
                                                var $query = $row.find(".nr1").text(); // Find the id

                                                $("#query").val($query);
                                            });
                                        </script>
                                    </div>
                                </div>
                            </div>
                        </div>    
                    </div>
                    <!-- end row -->

                    <div class="row">
                        <c:if test="${not empty msg}">
                            <div><h2><script>alert("${msg}")</script></h2></div>
                        </c:if>
                    </div>
                    <!-- end row -->

                    <div class="row">
                        
                    </div>
                    <!-- end row -->
                    

                    <div class="row">
                        
                    </div>
                    <!-- end row -->
                    
                </div> <!-- container-fluid -->
            </div>
            <!-- End Page-content -->
        </div>
        <!-- end main content-->

    </div>
    <!-- END layout-wrapper -->

    <!-- Right Sidebar -->
    <!-- /Right-bar -->

    <!-- Right bar overlay-->
    <!-- <div class="rightbar-overlay"></div> -->

    <!-- JAVASCRIPT -->
    <script src="assets/libs/jquery/jquery.min.js"></script>
    <script src="assets/libs/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="assets/libs/metismenu/metisMenu.min.js"></script>
    <script src="assets/libs/simplebar/simplebar.min.js"></script>
    <script src="assets/libs/node-waves/waves.min.js"></script>

    <!-- apexcharts -->
    <script src="assets/libs/apexcharts/apexcharts.min.js"></script>

    <script src="assets/libs/slick-slider/slick/slick.min.js"></script>

    <!-- Jq vector map -->
    <script src="assets/libs/jqvmap/jquery.vmap.min.js"></script>
    <script src="assets/libs/jqvmap/maps/jquery.vmap.usa.js"></script>

    <script src="assets/js/pages/dashboard.init.js"></script>

    <script src="assets/js/app.js"></script>
    <script src="assets/libs/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>

</body>
</html>