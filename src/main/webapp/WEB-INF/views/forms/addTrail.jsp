<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>


    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Add Trail</title>

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
        padding: 6px 12px;
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
    .tableTitle {
        text-align: right;
        padding: 16px;
        font-size: 22px;
        font: bold;
        color: #1b1e21;
    }

    .fa-envelope {
        color: #28a745;
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
                    <a href="/logged/authorizeStrava" id="strava">Strava <i class="fab fa-strava"></i></a>
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
        </div>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6 col-sm-6 col-xs-12">
                    <form:form modelAttribute="trail" method="post">
                        <div class="form-group ">
                            <label class="control-label " for="name">
                                Nazwa
                            </label>
                            <form:input path="name" class="form-control" name="name" ></form:input>
                            <form:errors path="name" class="error"></form:errors>
                        </div>
                        <div class="form-group ">
                            <label class="control-label requiredField">
                                Długość (km)
                            </label>
                            <form:input path="length" class="form-control" />
                            <form:errors path="length" class="error"/>
                        </div>
                        <div class="form-group ">
                            <label class="control-label requiredField">
                                Suma przewyższeń (m)
                            </label>
                            <form:input path="uphill" class="form-control" />
                            <form:errors path="uphill" class="error"/>
                        </div>
                        <div class="form-group ">
                            <label class="control-label requiredField">
                                Stopień trudności
                            </label>
                            <form:select path="difficluty" items="${difficulty}" class="select form-control"/>
                            <form:errors path="difficluty" class="error"/>
                        </div>
                        <div class="form-group ">
                            <label class="control-label requiredField" >
                                Typ
                            </label>
                            <form:select path="type" items="${trailTypes}" class="select form-control"/>
                            <form:errors path="type" class="error"/>
                        </div>
                        <div class="form-group">
                            <label class="control-label requiredField" >
                                Opis
                            </label>
                            <form:textarea path="description" cols="70" rows="10" class="form-control" ></form:textarea>
                        </div>
                        <div>
                            <label class="control-label " for="select1">
                                Góry
                            </label>
                            <form:select path="mountains" multiple="true" items="${mountains}" itemValue="mountainId" itemLabel="name" class="select form-control" name="select1"/>
                            <br/>
                        </div>
                        <div>
                            <label class="control-label " for="select1">
                                Miasta
                            </label>
                            <form:select path="towns" multiple="true" items="${towns}" itemValue="townId" itemLabel="name" class="select form-control" name="select1"/>
                            <form:hidden path="trailId" value="${trailId}"/>
                            <br/>
                        </div>

                        <br/>
                        <div class="form-group">
                            <div>
                                <button class="btn btn-success btn-sm my-2 my-sm-0" name="submit" type="submit">
                                    Zatwierdź
                                </button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
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