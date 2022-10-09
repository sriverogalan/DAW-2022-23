<html>
<head>
    <meta charset="utf-8">
</head>
<body>
    <?php
        setcookie("noexpira",1);
        setcookie("micookie",2,time()+60);

        setcookie("idioma", "esp");

        if ($_COOKIE["idioma"] == "esp") {
            echo "Hola";
        } else {
            echo "Hello";
        }

        unset($_COOKIE["noexpira"]);
        setcookie("noexpira", "", time()-1);
    ?>
</body>
</html>
