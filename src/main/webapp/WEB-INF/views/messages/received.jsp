<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Beskidy Endurance Received</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/static/full.css" />" rel="stylesheet">

</head>

<body>
<!-- Navigation -->
<%@include file="/WEB-INF/views/partials/loggedNavBar.jsp"%>
<%@include file="/WEB-INF/views/partials/sideBar.jsp"%>



<!-- Page Content -->
<div class="container-fluid">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Nadawca </th>
            <th>Temat</th>
            <th>Data utwożenia</th>
            <th>Treść</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${received}" var="msg">
            <tr>
                <td>${msq.sender}</td>
                <td>${msg.title}</td>
                <td>${msq.created}</td>
                <td>${msg.text}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<!-- Bootstrap core JavaScript -->
</body>
</html>
