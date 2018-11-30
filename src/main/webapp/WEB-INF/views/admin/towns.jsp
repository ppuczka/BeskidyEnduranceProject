<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vampirec
  Date: 29/11/2018
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>towns</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<%@include file="/WEB-INF/views/partials/adminNavBar.jsp"%>
<br/>
<span css="display: inline;"><h4>Lista Miejscowości</h4></span><span><a href="/admin/addTown/" role = "button" class="btn btn-primary btn-sm">Dodaj Miejscowość</a></span>
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
    </c:forEach>
    </tbody>
</table>

</body>
</html>
