<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Peliculas</title>
</head>
<body>
    <form action='autentication' method='post'>
        <label for='nombre'>Usuario: </label>
        <input type="text" id="nombre" name="nombre" placeholder="Nombre">
        <label for='password'>Contraseña: </label>
        <input type="password" id="password" name="password" placeholder="Password">
        <input type="submit" value="Enviar">
    </form>
</body>
</html>