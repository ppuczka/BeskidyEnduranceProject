<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <title>Admin Home Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<%--<body class="p-3 mb-2 bg-white">--%>
<%--<nav class="navbar navbar-expand-lg navbar-dark bg-primary">--%>
    <%--<a class="navbar-brand" href="/admin/homePage">Panel administratora</a>--%>

    <%--<div class="collapse navbar-collapse" id="navbarNavAltMarkup">--%>
        <%--<div class="navbar-nav">--%>
            <%--<a class="nav-item nav-link active" href="/admin/homePage">Strona Główna<span class="sr-only">(current)</span></a>--%>
            <%--<a class="nav-item nav-link" href="/admin/mountains">Góry</a>--%>
            <%--<a class="nav-item nav-link" href="/admin/towns">Miasta</a>--%>
            <%--<a class="nav-item nav-link" href="/admin/trails">Trasy</a>--%>
            <%--<a class="nav-item nav-link" href="/admin/users">Użytkownicy</a>--%>
            <%--<button class="btn btn-outline-success my-2 my-lg-0" type="submit" >Wyloguj</button>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</nav>--%>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
        <a class="navbar-brand" href="/admin/homePage">Panel Administratora</a>
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
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
<br/>

<h4><p align="centre">Lista Gór</p></h4>
<table class="table table-hover">
    <thead>
    <tr>
        <th>Nazwa </th>
        <th>Wysokość</th>
        <th>Trasy</th>
        <th>Opcje</th>

    </tr>
    </thead>

    <tbody>
    <c:forEach items="${mountains}" var="mount">
        <tr>
            <td>${mount.name}</td>
            <td>${mount.height}</td>
            <td><a href="/admin/showTrails/${mount.mountainId}" role = "button" class="btn btn-primary btn-sm">Wyświetl listę tras</a></td>
            <td><a href="/admin/deleteMount/${mount.mountainId}" role = "button" class="btn btn-primary btn-sm">Usuń</a>
                <a href="/admin/editMount/${mount.mountainId}" role = "button" class="btn btn-primary btn-sm">Edytuj</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h4><p align="centre">Lista Miejscowości</p></h4>
<table class="table table-hover">
    <thead>
    <tr>
        <th>Nazwa</th>
        <th>Wysokość npm</th>
        <th>Opis</th>
        <th>Trasy</th>
        <th>Opcje</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${towns}" var="town">
        <tr>
            <td>${town.name}</td>
            <td>${town.height}</td>
            <td>${town.decription}</td>
            <td><a href="/admin/showTrails/${town.townId}" role = "button" class="btn btn-primary btn-sm">Wyświetl listę tras</a></td>
            <td><a href="/admin/deleteTown/${town.townId}" role = "button" class="btn btn-primary btn-sm">Usuń</a>
                <a href="/admin/editTown/${town.townId}" role = "button" class="btn btn-primary btn-sm">Edytuj</a></td>
        </tr>
                <%--ewentutlanie--%>
            <%--<td><c:forEach items="${town.trailList}" var="trail">--%>
                <%--${town.trail}--%>
    </c:forEach>
    </tbody>
</table>

<h4><p align="centre">Lista Użytkowników</p></h4>
<table class="table table-hover">

        <thead>
        <tr>
            <th>Id</th>
            <th>Imię</th>
            <th>Nazwisko</th>
            <th>Adres email</th>
            <th>Ulubione Trasy</th>
            <th>Opcje</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.userId}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
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
</body>
</html>
