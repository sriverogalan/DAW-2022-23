<html>
<head>
    <meta charset="utf-8">
</head>
<body>
    <?php

        session_id("22");
        session_start();

        $_SESSION["iniciada"] = true;
        $_SESSION["nom"] = "Joan";

        var_dump($_SESSION);
        unset($_SESSION['nom']);
        if (isset($_SESSION['nom'])) {
            echo "La variable nom existeix";
        } else {
            echo "La variable nom no existeix";
        }
        session_destroy();
    ?>
</body>
</html>
