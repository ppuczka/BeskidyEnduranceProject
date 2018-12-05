<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>


    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Beskidy Endurance</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">

    <link rel="stylesheet" href="<c:url value="https://use.fontawesome.com/releases/v5.5.0/css/all.css" />"
          integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/static/full.css" />" rel="stylesheet">

</head>
<style>

.btn {
background-color: #28a745;
border: none;
color: white;
padding: 12px 16px;
font-size: 12px;
cursor: pointer;
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
                    <a class="nav-link" href="/home">Strona główna</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/about">O nas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/register">Rejestracja</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/login" style="color:lawngreen">Logowanie <i class="fas fa-sign-in-alt"></i></a>
                </li>
            </ul>
        </div>
    </div>
</nav>


<!-- Page Content -->
<!-- Bootstrap core JavaScript -->
</body>
</html>
