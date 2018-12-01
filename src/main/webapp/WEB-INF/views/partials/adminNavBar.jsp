<%--
  Created by IntelliJ IDEA.
  User: vampirec
  Date: 29/11/2018
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>adminNavBar</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
        <a class="navbar-brand" href="/admin/home">Panel Administratora</a>
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item">
                <a class="nav-link" href="/admin/mountains">Góry<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/towns">Miasta</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/trails">Trasy</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/users">Użytkownicy</a>
            </li>

        </ul>
        <span class="navbar-text">Zalogowany jako: ${loggedUserName}</span>
        <div style="padding-left: 50px"></div><a href="/logout" class="btn btn-success btn-sm my-2 my-sm-0">Wyloguj</a></div>
    </div>
</nav>

</body>
</html>
