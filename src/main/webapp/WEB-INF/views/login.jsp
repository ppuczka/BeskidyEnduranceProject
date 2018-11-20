<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />
    <style>.bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p, .bootstrap-iso form{font-family: Arial,
    Helvetica, sans-serif; color: black}.bootstrap-iso form button, .bootstrap-iso
    form button:hover{color: white !important;} .asteriskField{color: red;}</style>
    <title>login</title>

</head>
<body>
<div class="bootstrap-iso">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6 col-sm-6 col-xs-12">
                <form method="POST" action="/login">
                    <div class="form-group ">
                        <label class="control-label " for="email">
                            Email
                        </label>
                        <input class="form-control" id="email" name="email" type="email"/>
                    </div>
                    <div class="form-group ">
                        <label class="control-label " for="password">
                            Hasło
                        </label>
                        <input class="form-control" id="password" name="password" type="password"/>
                    </div>
                    <div class="form-group">
                        <div>
                            <button class="btn btn-primary " name="submit" type="submit">
                                Zatwierdź
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
