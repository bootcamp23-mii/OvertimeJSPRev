<%@page import="models.Overtime"%>
<!DOCTYPE html>

<%  boolean cekData = session.getAttribute("data") != null;
    Overtime ov = (cekData) ? (Overtime) session.getAttribute("overtime") : null;
    boolean cekList = session.getAttribute("data") != null;
    boolean cekList2 = session.getAttribute("all") != null;
    boolean cekList3 = session.getAttribute("dataEmp") != null;
    boolean cekLog = session.getAttribute("login") != null;
    boolean cekRole = session.getAttribute("role") != null;
    if (!cekLog) {
        response.sendRedirect("./LoginServlet");
    } else if (!cekList || !cekList2) {
        response.sendRedirect("./HistoryServlet");
    } else if (!cekList3) {
        response.sendRedirect("./AdminServlet");
    }
%>
<html lang="en">
    <jsp:include page="head.jsp"/>
    <h1><%out.print(cekLog); %></h1>
    <body class="animsition">
        <div class="page-wrapper">
            <!-- HEADER MOBILE-->
            <header class="header-mobile d-block d-lg-none">
                <div class="header-mobile__bar">
                    <div class="container-fluid">
                        <div class="header-mobile-inner">
                            <a class="logo" href="index.html">
                                <img src="images/icon/home.png" alt="CoolAdmin" />
                            </a>
                            <button class="hamburger hamburger--slider" type="button">
                                <span class="hamburger-box">
                                    <span class="hamburger-inner"></span>
                                </span>
                            </button>
                        </div>
                    </div>
                </div>
                <jsp:include page="navbarmobile.jsp"/>
            </header>
            <!-- END HEADER MOBILE-->

            <!-- MENU SIDEBAR-->
            <%if (cekRole) {
                    if (session.getAttribute("role").equals("JOB03")) {%>
            <jsp:include page="sidebarAdmin.jsp"/>
            <% } else if (session.getAttribute("role").equals("JOB02")) {%>
            <jsp:include page="sidebarManager.jsp"/>
            <%} else {%>
            <jsp:include page="sidebar.jsp"/>
            <% }%>
            <% }%>
            <!-- END MENU SIDEBAR-->

            <!-- PAGE CONTAINER-->
            <div class="page-container">
                <!-- HEADER DESKTOP-->
                <jsp:include page="header.jsp"/>
                <!-- HEADER DESKTOP-->
                <!-- MAIN CONTENT-->
                <div class="main-content-p" id="loadthis">
                    <jsp:include page="content.jsp"/>
                </div>
                <!-- END MAIN CONTENT-->
                <!-- END PAGE CONTAINER-->
            </div>
            <jsp:include page="footer.jsp"/>
        </div>

        <!-- Jquery JS-->
        <script src="vendor/jquery-3.2.1.min.js"></script>

        <!-- Bootstrap JS-->
        <script src="vendor/bootstrap-4.1/popper.min.js"></script>
        <script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>

        <!-- Vendor JS       -->
        <script src="vendor/slick/slick.min.js">
        </script>
        <script src="vendor/wow/wow.min.js"></script>
        <script src="vendor/animsition/animsition.min.js"></script>
        <script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
        </script>
        <script src="vendor/counter-up/jquery.waypoints.min.js"></script>
        <script src="vendor/counter-up/jquery.counterup.min.js">
        </script>
        <script src="vendor/circle-progress/circle-progress.min.js"></script>
        <script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
        <script src="vendor/chartjs/Chart.bundle.min.js"></script>
        <script src="vendor/select2/select2.min.js">
        </script>

        <!-- Main JS-->
        <script src="js/main.js"></script>
        <script src="js/selfScript.js"></script>
    </body>
</html>
<!-- end document-->
