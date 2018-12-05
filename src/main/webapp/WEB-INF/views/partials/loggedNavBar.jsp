<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Beskidy Endurance</title>
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/static/full.css" />" rel="stylesheet">
</head>

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
                    <a class="nav-link" href="/logout" style="color: #28a745">Wyloguj <i class="fas fa-sign-in-alt"></i></a>
                </li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
