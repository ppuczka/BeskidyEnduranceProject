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

<%--<form:form method="post" modelAttribute="trail">--%>

    <%--Nazwa: <form:input path="name" /><form:errors path="name" /><br />--%>
    <%--Długość: <form:input path="length" /><form:errors path="lenth" /><br />--%>
    <%--Suma podjazdów: <form:input path="uphill" /><form:errors path="uphill" /><br />--%>
    <%--Typ: <form:input path="type" /><form:errors path="type" /><br />--%>
    <%--Stopień trudności: <form:select path="difficluty"/><br/>--%>
    <%--Opis: <form:textarea path="description" /><br />--%>
    <%--Wybierz góry: <form:select path="mountains" multiple="true" items = "${mountains}" itemLabel="name"/>--%>
    <%--<form:hidden path="trailId" />--%>
    <%--<input type="submit" />--%>

        <%--<div class="form-group"> <!-- Full Name -->--%>
            <%--<label for="full_name_id" class="control-label">Nazwa</label>--%>
            <%--<form:input path="name" class="form-control" id="full_name_id" name="full_name" placeholder="John Deer"/>--%>
        <%--</div>--%>

        <%--<div class="form-group"> <!-- Street 1 -->--%>
            <%--<label for="street1_id" class="control-label">Street Address 1</label>--%>
            <%--<form:input path="length" class="form-control" id="street1_id" name="street1" placeholder="Street address, P.O. box, company name, c/o"/>--%>
        <%--</div>--%>

        <%--<div class="form-group"> <!-- Street 2 -->--%>
            <%--<label for="street2_id" class="control-label">Street Address 2</label>--%>
            <%--<input type="text" class="form-control" id="street2_id" name="street2" placeholder="Apartment, suite, unit, building, floor, etc.">--%>
        <%--</div>--%>

        <%--<div class="form-group"> <!-- City-->--%>
            <%--<label for="city_id" class="control-label">City</label>--%>
            <%--<input type="text" class="form-control" id="city_id" name="city" placeholder="Smallville">--%>
        <%--</div>--%>

        <%--<div class="form-group"> <!-- State Button -->--%>
            <%--<label for="state_id" class="control-label">State</label>--%>
            <%--<select class="form-control" id="state_id">--%>

            <%--</select>--%>
        <%--</div>--%>

        <%--<div class="form-group"> <!-- Zip Code-->--%>
            <%--<label for="zip_id" class="control-label">Zip Code</label>--%>
            <%--<input type="text" class="form-control" id="zip_id" name="zip" placeholder="#####">--%>
        <%--</div>--%>

        <%--<div class="form-group"> <!-- Submit Button -->--%>
            <%--<button type="submit" class="btn btn-primary">Buy!</button>--%>
        <%--</div>--%>

    <%--</form:form>--%>

<div class="bootstrap-iso">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6 col-sm-6 col-xs-12">
                <form method="post">
                    <div class="form-group ">
                        <label class="control-label requiredField" for="name">
                            Nazwa
                            <span class="asteriskField">
        *
       </span>
                      § sawr5v>
                    <div class="form-group ">
                        <label class="control-label " for="message">
                            Typ
                        </label>
                        <textarea class="form-control" cols="40" id="message" name="message" rows="10"></textarea>
                    </div>
                    <div class="form-group ">
                        <label class="control-label requiredField" for="length">
                            Długość
                            <span class="asteriskField">
        *
       </span>
                        </label>
                        <input class="form-control" id="length" name="length" type="text"/>
                    </div>
                    <div class="form-group ">
                        <label class="control-label requiredField" for="subject">
                            Suma przewyższeń
                            <span class="asteriskField">
        *
       </span>
                        </label>
                        <input class="form-control" id="subject" name="subject" type="text"/>
                    </div>
                    <div class="form-group ">
                        <label class="control-label " for="text">
                            Text
                        </label>
                        <input class="form-control" id="text" name="text" type="text"/>
                    </div>
                    <div class="form-group ">
                        <label class="control-label " for="select">
                            Stopień trudności
                        </label>
                        <select class="select form-control" id="select" name="select">
                        </select>
                    </div>
                    <div class="form-group ">
                        <label class="control-label " for="textarea">
                            Opis
                        </label>
                        <textarea class="form-control" cols="40" id="textarea" name="textarea" rows="10"></textarea>
                    </div>
                    <div class="form-group ">
                        <label class="control-label " for="select1">
                            Szczyty
                        </label>
                        <select class="select form-control" id="select1" name="select1">
                            <option value="First Choice">
                                First Choice
                            </option>
                            <option value="Second Choice">
                                Second Choice
                            </option>
                            <option value="Third Choice">
                                Third Choice
                            </option>
                        </select>
                    </div>
                    <div class="form-group">
                        <div>
                            <button class="btn btn-primary " name="submit" type="submit">
                                Submit
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>





</body>
</html>
