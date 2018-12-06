<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <title>Trails</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<%@include file="/WEB-INF/views/partials/adminNavBar.jsp"%>
<br/>
<span css="display: inline;"><h4>Lista Trails</h4></span><span><a href="/admin/addTrail/" role = "button" class="btn btn-primary btn-sm">Dodaj Trasę<br/></a><br/></span>
<br/>
<table class="table table-hover">

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
</body>
</html>
