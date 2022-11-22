
<html lang="ES">
<head>
    <meta charset="utf-8">
    <title>Hola putas</title>
</head>
<body>
<?php

setcookie("micookie", 2, time() + 60);
header("Content-Type: text/html; charset=UTF-8");
setcookie("idioma", "esp");

if ($_COOKIE["idioma"] == "esp") {
    echo "Hola";
} else {
    echo "Hello";
}

unset($_COOKIE["noexpira"]);
setcookie("noexpira", "", time() - 1);


?>
</body>
</html>
