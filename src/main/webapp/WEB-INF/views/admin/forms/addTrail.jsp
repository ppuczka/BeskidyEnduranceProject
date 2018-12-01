<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <form:form modelAttribute="trail" method="post">
                    <div class="form-group ">
                        <label class="control-label " for="name">
                            Nazwa
                        </label>
                        <form:input path="name" class="form-control" name="name" ></form:input>
                        <form:errors path="name" class="error"></form:errors>
                    </div>
                    <div class="form-group ">
                        <label class="control-label requiredField">
                            Długość
                        </label>
                        <form:input path="length" class="form-control" />
                        <form:errors path="length" class="error"/>
                    </div>
                    <div class="form-group ">
                        <label class="control-label requiredField">
                            Suma przewyższeń
                        </label>
                        <form:input path="uphill" class="form-control" />
                        <form:errors path="uphill" class="error"/>
                    </div>
                    <div class="form-group ">
                        <label class="control-label requiredField">
                            Stopień trudności
                        </label>
                        <form:select path="difficluty" items="${difficulty}" class="select form-control"/>
                        <form:errors path="difficluty" class="error"/>
                    </div>
                        <div class="form-group ">
                        <label class="control-label requiredField" >
                            Typ
                        </label>
                            <form:select path="type" items="${trailTypes}" class="select form-control"/>
                            <form:errors path="type" class="error"/>
                        </div>
                    <div>
                        <label class="control-label " for="select1">
                            Góry
                        </label>
                        <form:select path="mountains" multiple="true" items="${mountains}" itemValue="mountainId" itemLabel="name" class="select form-control" name="select1"/>
                        <br/>
                    </div>
                    <div>
                        <label class="control-label " for="select1">
                            Miasta
                        </label>
                        <form:select path="towns" multiple="true" items="${towns}" itemValue="townId" itemLabel="name" class="select form-control" name="select1"/>
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
