<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Faculty Details</title>
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
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

        <!-- Datatables CSS -->
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" type="text/css">
        <link rel="stylesheet" href="https://cdn.datatables.net/fixedheader/3.1.9/css/fixedHeader.dataTables.min.css" type="text/css">
        <!-- DataTables JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/fixedheader/3.1.9/js/dataTables.fixedHeader.min.js"></script>

        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.25/datatables.min.css"/>
 
        <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.25/datatables.min.js"></script>
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
                                <!-- <a class="dropdown-item" href="/profile"><i class="mdi mdi-face-profile font-size-16 align-middle mr-1"></i> Profile</a> -->
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
                      <!-- <button type="button" class="close" data-dismiss="modal">×</button>   -->
                      <h4 class="modal-title">Edit Faculty</h4>
                    </div>  
                    <div class="modal-body">  
                      <!-- <p>This is a large modal.</p>   -->
                      <form class="custom-validation" action="/update-faculty-admin" method="POST">
                        <div class="form-group">
                            <label>Name</label>
                            <input type="text" class="form-control" id="name" readonly/>
                        </div>

                        <div class="form-group">
                            <div>
                                <label>Email-Id</label>
                                <input type="text" class="form-control" id="email" name="facEmail" readonly />
                            </div>
                        </div>
    
                        <div class="form-group">
                            <div>
                                <label>Degination.</label>
                                <input type="text" class="form-control" id="desgi" name="facDesig" />
                            </div>
                        </div>
    
                        <div class="form-group">
                            <label>Qualification</label>
                            <div>
                                <input type="text" class="form-control" id="qua" name="facQuali" readonly/>
                            </div>
                        </div>          
    
                        <div class="form-group">
                            <label>Exprience</label>
                            <div>
                                <input type="text" class="form-control" id="exp" name="facExp" readonly/>
                            </div>
                        </div>
    
                        <div class="form-group">
                            <label>Specialaization</label>
                            <div>
                                <input type="text" class="form-control" id="spe" readonly/>
                            </div>
                        </div>
    
                        <div class="form-group mb-0">
                            <div>
                                <button type="submit" class="btn btn-primary waves-effect waves-light mr-1">
                                    UPDATE
                                </button>
                            </div>
                        </div>
                    </form>
                    </div>  
                    <div class="modal-footer">  
                      <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>  
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
                                <a href="/indexAdmin" class="waves-effect">
                                    <i class="mdi mdi-view-dashboard"></i><span class="badge badge-pill badge-success float-right"></span>
                                    <span>Admin  Dashboard</span>
                                </a>
                            </li>

                            <li>
                                <a href="/goto-viewStudents" class=" waves-effect">
                                    <i class="mdi mdi-calendar-month"></i>
                                    <span>Student Details</span>
                                </a>
                            </li>

                            <li>
                                <a href="/goto-viewfaculty" class=" waves-effect">
                                    <i class="mdi mdi-calendar-month"></i>
                                    <span style="color: #FCFBFC;">Faculty  Details</span>
                                </a>
                            </li>

                            <li>
                                <a href="/goto-viewparent" class=" waves-effect">
                                    <i class="mdi mdi-calendar-month"></i>
                                    <span>Parents Details</span>
                                </a>
                            </li>

                            <li>
                                <a href="/save-facpassandid" class=" waves-effect">
                                    <i class="mdi mdi-calendar-month"></i>
                                    <span>Generate Faculty Details </span>
                                </a>
                            </li>

                            <!-- <li>
                                <a href="javascript: void(0);" class="has-arrow waves-effect">
                                    <i class="mdi mdi-email-multiple-outline"></i>
                                    <span>Email</span>
                                </a>
                                <ul class="sub-menu" aria-expanded="false">
                                    <li><a href="email-inbox.html">Inbox</a></li>
                                    <li><a href="email-read.html">Email Read</a></li>
                                    <li><a href="email-compose.html">Email Compose</a></li>
                                </ul>
                            </li>

                            <li>
                                <a href="javascript: void(0);" class="has-arrow waves-effect">
                                    <i class="mdi mdi-account-group"></i>
                                    <span>Authentication</span>
                                </a>
                                <ul class="sub-menu" aria-expanded="false">
                                    <li><a href="auth-login.html">Login</a></li>
                                    <li><a href="auth-register.html">Register</a></li>
                                    <li><a href="auth-recoverpw.html">Recover Password</a></li>
                                    <li><a href="auth-lock-screen.html">Lock Screen</a></li>
                                </ul>
                            </li>

                            <li>
                                <a href="javascript: void(0);" class="has-arrow waves-effect">
                                    <i class="mdi mdi-google-pages"></i>
                                    <span>Pages</span>
                                </a>
                                <ul class="sub-menu" aria-expanded="false">
                                    <li><a href="pages-starter.html">Starter Page</a></li>
                                    <li><a href="pages-maintenance.html">Maintenance</a></li>
                                    <li><a href="pages-comingsoon.html">Coming Soon</a></li>
                                    <li><a href="pages-timeline.html">Timeline</a></li>
                                    <li><a href="pages-gallery.html">Gallery</a></li>
                                    <li><a href="pages-faqs.html">FAQs</a></li>
                                    <li><a href="pages-pricing.html">Pricing</a></li>
                                    <li><a href="pages-404.html">Error 404</a></li>
                                    <li><a href="pages-500.html">Error 500</a></li>
                                </ul>
                            </li> -->
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
                            <h1>Faculty Details</h1>
                        </div>

                        <div class="row">
                            <div class="col-sm-6 col-xl-3">
                                <input type="text" class="form-control" id="filter" placeholder="Search By Faculty Qualification">
                            </div>
                        </div>     
                        <!-- end page title -->

                        <div class="row"><br></div>

                        <div class="row"><br></div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="header-title mb-4">Faculty Details</h4>
                                        <script>
                                            $(document).ready(function() {
                                                (function($) {
                                                    $("#example tbody").addClass("search");
                                                    $('#filter').keyup(function() {
                                                        var rex = new RegExp($(this).val(),'i');
                                                        $('.search tr').hide();

                                                        $('.search tr').filter(function(i, v) {
                                                            var $t = $(this).children(":eq("+"3"+")");  //which column reference
                                                            return rex.test($t.text());
                                                        }).show();
                                                    });
                                                }(jQuery));
                                            });
                                        </script>

                                        <div class="table-responsive">
                                            <table style="overflow: hidden;" class="table table-centered table-nowrap mb-0" id="example" class="display">
                                                <thead>
                                                    <tr>
                                                        <th scope="col">ID & Name</th>
                                                        <th scope="col">Email</th>
                                                        <th scope="col">Designation</th>
                                                        <th scope="col">Qualification</th>
                                                        <th scope="col">Exprience</th>
                                                        <th scope="col">Specialaization</th>
                                                        <th scope="col">Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="f" items="${facultyadmin}">
                                                        <tr>
                                                            <td>
                                                                <p class="nr1" class="mb-1 font-size-12">#${f.id}</p>
                                                                <h5 class="nr2" class="font-size-15 mb-0"> ${f.facFname} ${f.facLname}</h5>
                                                            </td>
                                                            <td class="nr3">${f.facEmail}</td>
                                                            <td class="nr4">${f.facDesig}</td>
                                                            <td class="nr5">${f.facQuali}</td>
                                                            <td class="nr6">${f.facExp}</td>
                                                            <td class="nr7">${f.facSpeci}</td>
                                                            <td>
                                                                <span class="use-address"><button  type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">Edit</button> </span>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                            <script>
                                                $(".use-address").click(function() {
                                                    var $row = $(this).closest("tr"); // Find the row
                                                    var $id = $row.find(".nr1").text(); // Find the id
                                                    var $name = $row.find(".nr2").text();
                                                    var $email = $row.find(".nr3").text();
                                                    var $desgi = $row.find(".nr4").text();
                                                    var $qua = $row.find(".nr5").text();
                                                    var $exp = $row.find(".nr6").text();
                                                    var $spe = $row.find(".nr7").text();

                                                    $("#name").val($name);
                                                    $("#email").val($email)
                                                    $("#desgi").val($desgi); 
                                                    $("#qua").val($qua);
                                                    $("#exp").val($exp);
                                                    $("#spe").val($spe);
                                                });
                                            </script>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

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
    </body>
</html>