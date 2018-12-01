<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Trail</title>
    <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />
    <style>.bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p,
    .bootstrap-iso form{font-family: Arial, Helvetica, sans-serif; color: black}
    .bootstrap-iso form button, .bootstrap-iso form button:hover{color: white !important;}
    .asteriskField{color: red;}</style>

</head>
<body>
<%@include file="/WEB-INF/views/partials/adminNavBar.jsp"%>
<br/>

<div class="bootstrap-iso">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6 col-sm-6 col-xs-12">
                <form:form modelAttribute="mountain" method="post">
                    <div class="form-group ">
                        <label class="control-label " for="name">
                            Nazwa
                        </label>
                        <form:input path="name" class="form-control" name="name" />
                        <form:errors path="name" class="error"/>
                    </div>
                    <div class="form-group ">
                        <label class="control-label requiredField">
                            Wysokoś n.p.m
                        </label>
                        <form:input path="height" class="form-control"/>
                        <form:errors path="height" class="error"/>
                    </div>
                    <div>
                        <label class="control-label " for="select1">
                            Trasy
                        </label>
                        <form:select path="trailList" multiple="true" items="${trails}" itemValue="trailId" itemLabel="name" class="select form-control" name="select1"/>
                        <br/>
                    </div>
                    <br/>
                    <div class="form-group">
                        <div>
                            <button class="btn btn-success btn-sm my-2 my-sm-0" name="submit" type="submit">
                                Zatwierdź
                            </button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>



</body>
</html>
