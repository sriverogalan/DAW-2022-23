<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
</head>
<body>
<form action="/webAplication_war_exploded/hello-servlet" method="post" >
    <label for="numeros">Quantes pelicules vols?</label>
    <input id="numeros" type="number" name="number">
    <input type="submit" value="Enviar">
</form>
</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>