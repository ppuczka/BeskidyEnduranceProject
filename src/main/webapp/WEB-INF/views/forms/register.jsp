<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />
    <style>.bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p,
    .bootstrap-iso form{font-family: Arial, Helvetica, sans-serif; color: black}.bootstrap-iso form button, .bootstrap-iso
    form button:hover{color: white !important;} .asteriskField{color: red;}</style>


</head>
<body>
<div class="bootstrap-iso">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6 col-sm-6 col-xs-12">
                <form:form method="post" modelAttribute="user">
                    <div class="form-group ">
                    <label class="control-label " for="name">
                            Imię
                    </label>
                        <form:input path="firstName" class="form-control" id="name"/>
                    </div>
                    <div class="form-group ">
                        <label class="control-label " for="name3">
                            Nazwisko
                        </label>
                        <form:input path="lastName" class="form-control" id="name3"/>
                    </div>
                    <div class="form-group ">
                        <label class="control-label " for="email">
                            Email
                        </label>
                        <form:input path="email"  class="form-control" id="email"/>
                    </div>
                    <div class="form-group ">
                        <label class="control-label " for="password">
                            Hasło
                        </label>
                        <form:password path="password" class="form-control" id="password"/>
                    </div>
                    <div class="form-group">
                        <div>
                            <input class="btn btn-primary " name="submit" type="submit">
                                Submit
                            </input>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
