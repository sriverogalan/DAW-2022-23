<html>
<head>
    <meta charset="utf-8">
</head>
<body>

    <form id="miformulario" action="../index.php" method="post">
        <p>
            <label for="usuario">Nombre:</label>
            <input type="text" name="usuario" id="usuario"/>
        </p>
        <p>
            <label for="password">Contraseña:</label>
            <input type="password" name="password" id="password" />
        </p>
        <p>
            <input type="submit" name="enviar" id="enviar" value="Enviar" />
        </p>

    </form>
    <?php
        if (isset($_POST['enviar'])) {
            $usuario = $_POST['usuario'];
            $password = $_POST['password'];
            echo "El usuario es: $usuario y la contraseña es: $password";
        }
    ?>
</body>
</html>
