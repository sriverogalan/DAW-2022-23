<html>
<head>
    <meta charset="utf-8">
</head>
<body>
    <form id="form" action="../index.php" method="post" enctype="multipart/form-data">
        <p>
            <label for="imagen">Fotografia:</label>
            <input type="file" name="imagen" id="imagen" />
        </p>

        <p>
            <input type="submit" name="submit" value="Subir" />
        </p>
    </form>

    <?php
        var_dump($_FILES);

        $directorio = ini_get('upload_tmp_dir');
        echo $directorio;

        $directorioTemporal = $_FILES['imagen']['tmp_name'];
        move_uploaded_file($directorioTemporal, $_FILES['imagen']['tmp_name']);
    ?>
</body>
</html>
