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
				<form action="/login" method="post">
				<h4>Witaj ponownie</h4><br/>
				<input type="text" id="username" name="email" class="form-control input-sm chat-input" placeholder="email" />
					</br>
				<input type="password" id="password" name="password" class="form-control input-sm chat-input" placeholder="hasło" />
					<div class="error">${error}</div>
					<br/>
					</br>
					<input type="submit" value="Zaloguj" class="btn btn-primary btn-md">
				</form>
				<div class="wrapper">
				</div>

			</div>
		</div>
	</div>
</div>
</body>
</html>