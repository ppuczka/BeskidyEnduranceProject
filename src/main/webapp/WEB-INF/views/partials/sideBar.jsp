<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>side Bar</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/static/full.css" />" rel="stylesheet">

    <link href="<c:url value="/resources/static/simple-sidebar.css"/>" rel="stylesheet">

</head>
<body>

<div id="page-content-wrapper">
    <div id="wrapper">
        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <br/>
                </li>
                <li>
                    <a href="#">Dashboard</a>
                </li>
                <li>
                    <a href="#">Shortcuts</a>
                </li>
                <li>
                    <a href="#">Overview</a>
                </li>
                <li>
                    <a href="#">Events</a>
                </li>
                <li>
                    <a href="#">About</a>
                </li>
                <li>
                    <a href="#">Services</a>
                </li>
                <li>
                    <a href="#">Contact</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->

        <div class="container-fluid">
            <br/><br/><br/>
            <p class="logged" style="text-align: right">Witaj ${user.firstName}</p>
            <a href="#menu-toggle" class="btn btn-success btn-xs" id="menu-toggle">Rozwiń menu</a>
        </div>
    </div>
    <!-- /#page-content-wrapper -->

</div>

<script src="<c:url value="/resources/static/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/static/js/bootstrap.bundle.min.js"/>"></script>

<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });


</script>

</body>
</html>
