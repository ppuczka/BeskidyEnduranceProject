<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Beskidy Endurance</title>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/static/full.css" />" rel="stylesheet">

    <meta charset="UTF-8">
    <link href="<c:url value="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"/>" rel="stylesheet" id="bootstrap-css">
    <script src="<c:url value="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value ="//code.jquery.com/jquery-1.11.1.min.js"/>"></script>
    <link href="<c:url value="/resources/static/main.css" />" rel="stylesheet">
    <link href="<c:url value ="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"/>" rel="stylesheet">

</head>
<body>
<!-- Page Content -->
<div class="container">
    <div class="row">
        <div class="col-md-offset-5 col-md-3">
            <div class="form-login">
                <form:form method="post" modelAttribute="user">
                    <h4>Tworzenie nowego konta użytkownika</h4><br/>
                    <form:input path="firstName" class="form-control input-sm chat-input" placeholder="Imię"/>
                    <form:errors path="firstName" class="error"></form:errors>
                    <br/><br/>
                    <form:input path="lastName" class="form-control input-sm chat-input" placeholder="Nazwisko"/>
                    <form:errors path="lastName" class="error"></form:errors>
                    <br/><br/>
                    <form:input path="email"  class="form-control input-sm chat-input" placeholder="Email"/>
                    <form:errors path="email" class="error"></form:errors>
                    <br/><br/>
                    <form:password path="password" class="form-control input-sm chat-input" placeholder="Hasło"/>
                    <form:errors path="password" class="error"></form:errors>"
                    <p class="succesMessage">${successMessage}</p>
                    <br/><br/>
                    <span style="float-wrap: initial"><input type="submit" value="Utwórz konto" id="button" class="btn btn-success">
                        <a href="/login" id="button2" class="btn btn-success">Zaloguj</a></span>
                </form:form>
                <div class="wrapper">
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>