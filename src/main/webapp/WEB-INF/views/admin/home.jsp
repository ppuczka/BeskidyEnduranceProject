<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin Home Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body class="p-3 mb-2 bg-dark text-white">
<h1>ADMIN HOME PAGE</h1>
<h2><p align="centre">Lista Gór</p></h2>
<table class="table table-striped table-dark">
    <thead>
    <tr>
        <th>Nazwa góry</th>
        <th>Wysokość</th>
        <th>Trasy</th>

    </tr>
    </thead>

    <tbody>
    <c:forEach items="${mountains}" var="mount">
        <tr>
            <td>${mount.name}</td>
            <td>${mount.height}</td>
            <td><c:forEach items="${mount.trails}" var="trail">
                    ${mount.trail}</td>
            </c:forEach>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h2><p align="centre">Lista Miejscowości</p></h2>

<table class="table table-striped table-dark">
    <thead>
    <tr>
        <th>Nazwa</th>
        <th>Wysokość npm/th>
        <th>Opis</th>
        <th>Lista Tras</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${towns}" var="town">
        <tr>
            <td>${town.name}</td>
            <td>${town.height}</td>
            <td>${town.decription}</td>
            <td><c:forEach items="${town.trailList}" var="trail">
                ${town.trail}
            </c:forEach></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
