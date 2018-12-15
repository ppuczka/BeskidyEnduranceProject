<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>


    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Main Page</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="https://use.fontawesome.com/releases/v5.5.0/css/all.css"/>"
          integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/static/full.css" />" rel="stylesheet">

    <link href="<c:url value="/resources/static/simple-sidebar.css"/>" rel="stylesheet">

</head>
<style>
    /* Darker background on mouse-over */

    .btn {
        background-color: #28a745;
        border: none;
        color: white;
        padding: 6px 12px;
        margin-bottom: 20px;
        font-size: 12px;
        cursor: pointer;
    }
    .btn:hover {
        background-color: green;
    }
    .fa-strava {
        color: red;
        size: 22px;
        font-size: 16px;
        padding-left: 0;
        margin-left: 0;
    }

    #strava {
        font-size: 16px;
    }
    .messages {
        color: red;
    }

</style>


<body>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="/home">Beskidy Endurance</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/logged/mainPage">Strona główna
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/challanges">Wyzwania</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logged/message/received">Wiadomości: <span style="color: #6610f2">${loggedUser.received.size()}</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout" style="color: #28a745">Wyloguj <i class="fas fa-sign-out-alt"></i></a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div id="page-content-wrapper">
<div id="wrapper">
    <!-- Sidebar -->
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li class="sidebar-brand">
                <br/>
            </li>
            <li>
                <a href="/logged/trails/view">Trasy<i class="fas fa-map-marked-alt"></i></a>
            </li>
            <li>
                <a href="/logged/trails/favTrails">Ulubione Trasy<i class="fas fa-map-marked-alt"></i></a>
            </li>
            <li>
                <a href="/logged/ranks/">Rangi<i class="fas fa-certificate"></i></a>
            </li>
            <li>
                <a href="/logged/townsCities/viewAll/">Miasta i Szczyty<i class="fas fa-city"></i><i class="fas fa-mountain"></i></a>
            </li>
            <li>
                <a href="/logged/authorizeStrava" id="strava">Połącz z Strava<i class="fab fa-strava"></i></a>
            </li>
            <li style="background: black;">
                <label for="exampleInputEmail1"></label>
                <form method="get" action="/logged/search" class="form-control" style="background: black">
                    <input type="text" placeholder="Wyszukiwanie..." class="form-control" id="exampleInputEmail1"/><br/>
                    <input type="submit" value="Wyszukaj" class="btn btn-success btn-xs"/>
                </form>
            </li>
        </ul>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div class="container-fluid">
        <br/><br/><br/>
        <p class="logged" style="text-align: right">Witaj ${loggedUser.firstName}, liczba punktów ${loggedUser.points}</p>
        <a href="#menu-toggle" class="btn btn-success btn-xs" id="menu-toggle">Menu</a>
        <div class="messages">${stravaConnectMsg}</div>
    </div>
    <div>
        <div class="title"><b>Nazwa trasy:</b> ${trail.name}</div><br>
        <div class="description"><b>Długość:</b> ${trail.length} km</div>
        <div class="description"><b>Suma przewyższeń:</b> ${trail.uphill} m</div>
        <div class="description"><b>Opis:</b> ${trail.description}</div>
        <span class="description"><b>Miasta:</b> <c:forEach items="${towns}" var="town">
                ${town.name} ${town.height} m n.p.m.,
            </c:forEach></span><br/>
        <span class="description"><b>Góry:</b> <c:forEach items="${mountains}" var="mount">
                ${mount.name} ${mount.height} m n.p.m.,  </span>
            </c:forEach>
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
