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
    .btn {
        background-color: #28a745;
        border: none;
        color: white;
        padding: 12px 16px;
        font-size: 16px;
        cursor: pointer;
    }

    /* Darker background on mouse-over */
    .btn:hover {
        background-color: green;
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
        <p class="logged" style="text-align: right">Witaj ${loggedUser.firstName}</p>
        <a href="#menu-toggle" class="btn btn-success btn-xs" id="menu-toggle">Menu</a>
    </div>
    <table class="table table-hover">
        <h4><p align="centre">Top 5 trasy</p></h4>
        <thead>
        <tr>
            <th>Ranking</th>
            <th>Nazwa</th>
            <th>Długość</th>
            <th>Suma przewyższeń</th>
            <th>Typ</th>
            <th>Opis</th>
            <th>Stopień trudności</th>
            <th>Góry</th>
            <th>Miasta</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${trails}" var="trail">
            <tr>
                <td>${trail.rating}</td>
                <td>${trail.name}</td>
                <td>${trail.length}</td>
                <td>${trail.uphill}</td>
                <td>${trail.type}</td>
                <td>${trail.length}</td>
                <td>${trail.difficluty}</td>
                <td><a href="/admin/showMountains/${trail.trailId}" role = "button" class="btn btn-primary btn-sm">Wyświetl gory</a></td>
                <td><a href="/admin/showTowns/${trail.trailId}" role = "button" class="btn btn-primary btn-sm">Wyświetl miasta</a></td>
                <td><a href="/admin/deleteTrail/${trail.trailId}" role = "button" class="btn btn-primary btn-sm">Usuń </a>
                    <a href="/admin/editTrail/${trail.trailId}" role = "button" class="btn btn-primary btn-sm">Edytuj</a></td>
            </tr>
            <%--ewentutlanie--%>
            <%--<td><c:forEach items="${town.trailList}" var="trail">--%>
            <%--${town.trail}--%>
        </c:forEach>
        </tbody>

    </table>

    <h4><p align="centre">Top 5 użytkownicy</p></h4>
    <table class="table table-hover">

        <thead>
        <tr>
            <th>Imię</th>
            <th>Adres email</th>
            <th>Punkty</th>
            <th>Opcje</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.firstName}</td>
                <td>${user.email}</td>
                <td>${user.points}</td>
                <td><a href="/admin/showTrails/${user.userId}" role = "button" class="btn btn-primary btn-sm">Wyświetl listę tras</a></td>
                <td><a href="/admin/deleteUser/${user.userId}" role = "button" class="btn btn-primary btn-sm">Usuń </a>
                    <a href="/admin/editUser/${user.userId}" role = "button" class="btn btn-primary btn-sm">Edytuj</a></td>
            </tr>
            <%--ewentutlanie--%>
            <%--<td><c:forEach items="${town.trailList}" var="trail">--%>
            <%--${town.trail}--%>
        </c:forEach>
        </tbody>

    </table>
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
